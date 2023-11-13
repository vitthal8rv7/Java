package com.learn.java.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.EmployeeListResponse;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private PaginationService paginationService;

	@GraphQLQuery(name = "getEmployeeList", description = "get employee list with pagination")
	public EmployeeListResponse getEmployeeList(@GraphQLArgument(name = "paging")Pageable paging) {
		return paginationService.getEmployeeList(paging);
	}
}
