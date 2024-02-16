package com.learn.java.mongodb.service;

import com.learn.java.mongodb.collection.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public Employee getEmployee(String id);

	public Employee updateEmployee(String id, String name);

	public String deleteEmployee(String id);

}
