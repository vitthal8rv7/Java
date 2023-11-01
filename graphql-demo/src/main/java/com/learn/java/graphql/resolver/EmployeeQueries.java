package com.learn.java.graphql.resolver;

import org.springframework.context.annotation.Configuration;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learn.java.graphql.model.Employee;

@Configuration
public class EmployeeQueries implements GraphQLQueryResolver {

	public Employee getEmployee(String id) {
		return null;
	} 
}
