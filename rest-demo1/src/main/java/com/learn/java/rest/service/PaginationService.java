package com.learn.java.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.learn.java.rest.model.Employee;
import com.learn.java.rest.model.EmployeeListResponse;
import com.learn.java.rest.model.Pager;

@Service
public class PaginationService {

	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeListResponse getEmployeeList(Pageable pageable, String someRequestParam) {
		List<Employee> employeeList = getEmployeeList();
		System.out.println("pageable.getOffset();: "+ pageable.getOffset());
		System.out.println("pageable.getPageSize();: "+ pageable.getPageSize());
		System.out.println("employeeList.size();: "+ employeeList.size());
		
		Integer start = (int) pageable.getOffset();
		Integer end = Math.min(start + pageable.getPageSize(), employeeList.size());

        Page<Employee> resultPage = new PageImpl<>(
        		employeeList.subList(start, end), pageable, employeeList.size());
        
        Double totalPages = Math.ceil((double) employeeList.size() / pageable.getPageSize());

        Pager pager = new Pager(pageable.getPageNumber(), pageable.getPageSize(),
                pageable.getOffset(), totalPages.intValue());
//        EmployeeListResponse response = EmployeeListResponse.builder()
//                .emergencyInformationList(resultPage.getContent()).pager(pager).build();
        EmployeeListResponse response = new EmployeeListResponse(resultPage.getContent(), pager);   
        
		return response;
	}

	public EmployeeListResponse getEmployeeList(Pageable pageable) {
		List<Employee> employeeList = getEmployeeList();
		System.out.println("pageable.getOffset();: "+ pageable.getOffset());
		System.out.println("pageable.getPageSize();: "+ pageable.getPageSize());
		System.out.println("employeeList.size();: "+ employeeList.size());
		
		Integer start = (int) pageable.getOffset();
		Integer end = Math.min(start + pageable.getPageSize(), employeeList.size());

        Page<Employee> resultPage = new PageImpl<>(
        		employeeList.subList(start, end), pageable, employeeList.size());
        
        Double totalPages = Math.ceil((double) employeeList.size() / pageable.getPageSize());

        Pager pager = new Pager(pageable.getPageNumber(), pageable.getPageSize(),
                pageable.getOffset(), totalPages.intValue());
        EmployeeListResponse response = new EmployeeListResponse(resultPage.getContent(), pager);   
        
		return response;
	}
	
	
	private List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("id1", "ename1"));
		employeeList.add(new Employee("id2", "ename2"));
		employeeList.add(new Employee("id3", "ename3"));
		employeeList.add(new Employee("id4", "ename4"));
		employeeList.add(new Employee("id5", "ename5"));
		employeeList.add(new Employee("id6", "ename6"));
		employeeList.add(new Employee("id7", "ename7"));
		employeeList.add(new Employee("id8", "ename8"));
		employeeList.add(new Employee("id9", "ename9"));
		employeeList.add(new Employee("id10", "ename10"));
		employeeList.add(new Employee("id11", "ename11"));
		employeeList.add(new Employee("id12", "ename12"));
		employeeList.add(new Employee("id13", "ename13"));
		employeeList.add(new Employee("id14", "ename14"));
		return employeeList;
	}

	public String getEmployeeListFromApp2(Pageable pageable) {
		List<Employee> employeeList = getEmployeeList();
		System.out.println("pageable.getOffset();: "+ pageable.getOffset());
		System.out.println("pageable.getPageSize();: "+ pageable.getPageSize());
		System.out.println("employeeList.size();: "+ employeeList.size());
		
		final String localhost = "http://localhost:8081";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"/rest/demo/employee/list");
		builder.queryParam("page", 4);
		builder.queryParam("size", 3);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = null;
        try {
        	response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
                    requestEntity, String.class);
        	//We can try to convert to to Java Model using Mapper Class?
        } catch (Exception e) {
        	System.out.println("Exception: "+e);
        	return null;
        }
		return response.getBody();

	}
	
	public EmployeeListResponse getEmployeeListPageableFromApp2(Pageable pageable) {
		List<Employee> employeeList = getEmployeeList();
		System.out.println("pageable.getOffset();: "+ pageable.getOffset());
		System.out.println("pageable.getPageSize();: "+ pageable.getPageSize());
		System.out.println("employeeList.size();: "+ employeeList.size());
		
		final String localhost = "http://localhost:8081";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost+"/rest/demo/employee/list");
		builder.queryParam("page", 4);
		builder.queryParam("size", 3);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<EmployeeListResponse> response = null;
        try {
        	response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
                    requestEntity, EmployeeListResponse.class);
        } catch (Exception e) {
        	System.out.println("Exception: "+e);
        	return null;
        }
		return response.getBody();

	}

}
