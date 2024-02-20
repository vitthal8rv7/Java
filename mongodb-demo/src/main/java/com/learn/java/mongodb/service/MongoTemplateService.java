package com.learn.java.mongodb.service;

import java.util.List;

import com.learn.java.mongodb.collection.Employee;

public interface MongoTemplateService {

	public Employee saveEmployee(Employee employee);

	public Employee getEmployee(String id);

	public List<Employee> getEmployeeAll();

	public Employee updateEmployee(String id, String name);

	public String deleteEmployee(String id);
}
