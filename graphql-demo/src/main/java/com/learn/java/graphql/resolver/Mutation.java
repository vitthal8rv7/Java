package com.learn.java.graphql.resolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.learn.java.graphql.model.Employee;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
@Configuration
public class Mutation implements GraphQLMutationResolver {

	public Employee addEmployee(Employee employee) {
		System.out.println("Id: "+ employee.getId());
		return employee;
	}
}
