package com.learn.java.graphql.service;

import org.springframework.data.domain.Pageable;

import com.learn.java.graphql.model.EmployeeListResponse;

public interface EmployeeService {

	public EmployeeListResponse getEmployeeList(Pageable paging);
}
