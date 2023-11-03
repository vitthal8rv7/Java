package com.learn.java.graphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.Employee;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@GraphQLQuery(name = "getEmployee", description = "get employee by id")
	@Override
	public Employee getEmployee(@GraphQLArgument(name = "id")String id) {
		Employee employee = new Employee();
		employee.setId(id);
		return employee;
	}

	@GraphQLQuery(name = "getAllEmployees", description = "get all employees")
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employees.add(employee);
		Employee employee2 = new Employee();
		employees.add(employee2);
		return employees;
	}

	@GraphQLMutation(name = "addEmployee", description = "add new employee")
	@Override
	public Employee addEmployee(@GraphQLArgument(name = "employee")Employee employee) {
		return employee;
	}

	@GraphQLMutation(name = "updateEmployee", description = "updated existing employee")
	@Override
	public Employee updateEmployee(@GraphQLArgument(name = "employee")Employee employee) {
		return employee;
	}

	@GraphQLMutation(name = "deleteEmployee", description = "delete employee")
	@Override
	public Boolean deleteEmployee(@GraphQLArgument(name = "employee")Employee employee) {
		if (Objects.isNull(employee)) {
			return false;
		} else {
			return true;
		}
	}

}
