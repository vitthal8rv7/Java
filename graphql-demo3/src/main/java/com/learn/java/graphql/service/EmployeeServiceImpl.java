package com.learn.java.graphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.learn.java.graphql.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public Employee getEmployee(String id) {
		Employee employee = new Employee();
		employee.setId(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee employee = new Employee();
		employees.add(employee);
		Employee employee2 = new Employee();
		employees.add(employee2);
		return employees;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employee;
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		if(Objects.isNull(employee)) {
			return false;
		} else {
			return true;
		}
	}

	
}
