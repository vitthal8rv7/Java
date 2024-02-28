package com.learn.java.mysql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mysql.model.dto.EmployeeDto;
import com.learn.java.mysql.model.entity.Employee;
import com.learn.java.mysql.repository.EmployeeRepository;
import com.learn.java.mysql.service.EmployeeService;
import com.learn.java.mysql.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	 
	@Override
	public EmployeeDto readEmployee(String employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if(employeeOptional.isPresent()) {
			Employee employee = null;
			employee = employeeOptional.get();
			return EmployeeUtil.getEmployee(employee);
		}
		return null;
	}

	@Override
	public List<EmployeeDto> readAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return EmployeeUtil.getEmployees(employees);
	}
}
