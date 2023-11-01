package com.learn.java.graphql.resolver;

import org.springframework.context.annotation.Configuration;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learn.java.graphql.model.Employee;

@Configuration
public class EmployeeMutations implements GraphQLMutationResolver {

	public Employee addEmployee(Employee employee) {
		return null;
	}
}
