package com.learn.java.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.Employee;
import com.learn.java.graphql.model.EmployeeListResponse;
import com.learn.java.graphql.model.Pager;



@Service
public class PaginationService {

	public EmployeeListResponse getEmployeeList(Pageable pageable) {
		List<Employee> employeeList = getEmployeeList();
		System.out.println("pageable.getOffset();: " + pageable.getOffset());
		System.out.println("pageable.getPageSize();: " + pageable.getPageSize());
		System.out.println("employeeList.size();: " + employeeList.size());

		Integer start = (int) pageable.getOffset();
		Integer end = Math.min(start + pageable.getPageSize(), employeeList.size());

		Page<Employee> resultPage = new PageImpl<>(employeeList.subList(start, end), pageable, employeeList.size());

		Double totalPages = Math.ceil((double) employeeList.size() / pageable.getPageSize());

		Pager pager = new Pager(pageable.getPageNumber(), pageable.getPageSize(), pageable.getOffset(),
				totalPages.intValue());
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

}
