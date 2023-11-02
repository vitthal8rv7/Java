package com.learn.java.graphql.resolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.learn.java.graphql.model.Employee;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
@Configuration
public class Query implements GraphQLQueryResolver {

    public String testQuery() {
    	System.out.println("Id: ");
    	return "OK";
    }
	
	public Employee getEmployee(String id) {
		Employee employee = new Employee();
		employee.setId(id);
		System.out.println("Id: "+ id);
		return employee;
	} 
}
