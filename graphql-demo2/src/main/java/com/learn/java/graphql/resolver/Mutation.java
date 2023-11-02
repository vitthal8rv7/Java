package com.learn.java.graphql.resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.learn.java.graphql.model.Employee;

@Controller
public class Mutation {

	@MutationMapping
	public Employee addEmployee(@Argument Employee employee) {
		System.out.println("Id: "+ employee.getId());
		return employee;
	}
}
