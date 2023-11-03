package com.learn.java.graphql.service;

import java.util.List;

import com.learn.java.graphql.model.Employee;

public interface EmployeeService {

	public Employee getEmployee(String id);

	public List<Employee> getAllEmployees();

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Boolean deleteEmployee(Employee employee);
}
