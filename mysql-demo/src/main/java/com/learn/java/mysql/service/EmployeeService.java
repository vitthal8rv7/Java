package com.learn.java.mysql.service;

import java.util.List;

import com.learn.java.mysql.model.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto readEmployee(String employeeId);

	public List<EmployeeDto> readAllEmployee();

	public List<EmployeeDto> saveEmployees(List<EmployeeDto> employees);

	public EmployeeDto updateEmployee(String id, String name);

	public String deleteEmployee(String id);
}
