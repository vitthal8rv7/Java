package com.learn.java.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.Employee;
import com.learn.java.graphql.service.EmployeeService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class EmployeeResolver {

	@Autowired
	private EmployeeService employeeService;
	
	@GraphQLQuery(name = "testQuery", description = "test query")
	public String testGraphqlDemo3() {
		return "Graphql Demo 3";
	}

	@GraphQLQuery(name = "testQuery2", description = "test query2")
	public String testGraphqlDemo33(@GraphQLArgument(name = "id") String id) {
		return "Graphql Demo 33";
	}
	
	@GraphQLQuery(name = "getEmployee", description = "get employee by id")
	public Employee getEmployee(@GraphQLArgument(name = "id")String id) {
		return employeeService.getEmployee(id);
	}

	@GraphQLQuery(name = "getAllEmployees", description = "get all employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	 @GraphQLMutation(name = "addEmployee", description = "add new employee")
	public Employee addEmployee(@GraphQLArgument(name = "employee")Employee employee) {
		System.out.println("in Add Employee");
		return employeeService.addEmployee(employee);
	}

	 @GraphQLMutation(name = "updateEmployee", description = "updated existing employee")
	public Employee updateEmployee(@GraphQLArgument(name = "employee")Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	 @GraphQLMutation(name = "deleteEmployee", description = "delete employee")
	public Boolean deleteEmployee(@GraphQLArgument(name = "employee")Employee employee) {
		return employeeService.deleteEmployee(employee);
	}

	
}
