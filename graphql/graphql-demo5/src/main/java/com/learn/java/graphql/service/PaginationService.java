package com.learn.java.graphql.service;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.java.graphql.model.EmployeeListResponse;

@Service
public class PaginationService {

	@Autowired
	private RestTemplate restTemplate;

	public EmployeeListResponse getEmployeeList(Pageable pageable) {
//		final String localhost = "http://localhost:8090";
		final String url = "http://localhost:8090/graphql";
//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(localhost + "/graphql");
		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Content-Type", "application/json");		
		String query =  "{\"query\":\"\\nquery {\\n  getEmployeeList(paging: {\\n    pageSize: "+pageable.getPageSize()+",\\n    pageNumber: "+pageable.getPageNumber()+"\\n  }) {\\n    employeeList {\\n      id\\n      name\\n    },\\n    pager {\\n      pageSize\\n      pageNumber\\n      totalPages\\n      offset\\n    }\\n  }\\n}\",\"variables\":{}}";		
		HttpEntity<String> requestEntity = new HttpEntity<>(query, headers);
		EmployeeListResponse response = null;
		ResponseEntity<String> responseString = null;
		String result = null;
		try {
//			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, requestEntity,
//					EmployeeListResponse.class);
			responseString = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
					String.class);
			result = responseString.getBody();
			result = result.substring(0, result.length()-2);
			System.out.println("result: "+ result);
			result = result.substring(28, result.length());
			result = "{"+result;
			
			System.out.println("result: "+ result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			System.out.println("responseString: "+responseString.getBody());
			return null;
		}
		
		System.out.println("responseString: "+responseString.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			response = objectMapper.readValue(result, EmployeeListResponse.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		return response;
	}

}
