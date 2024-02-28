package com.learn.java.mysql.service;

import java.util.List;

import com.learn.java.mysql.model.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto readEmployee(String employeeId);

	public List<EmployeeDto> readAllEmployee();
}
