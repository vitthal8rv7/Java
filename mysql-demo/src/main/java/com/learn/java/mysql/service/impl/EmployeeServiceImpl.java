package com.learn.java.mysql.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
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

	private Employee findById(String employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if (employeeOptional.isPresent()) {
			return employeeOptional.get();
		}
		return null;

	}

	@Override
	public EmployeeDto readEmployee(String employeeId) {
		Employee employee = null;
		employee = findById(employeeId);
		if (Objects.isNull(employee)) {
			return null;
		}
		return EmployeeUtil.getEmployee(employee);
	}

	@Override
	public List<EmployeeDto> readAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return EmployeeUtil.convertEmployeeListToEmployeeDtoList(employees);
	}

	@Override
	public List<EmployeeDto> saveEmployees(List<EmployeeDto> employees) {
		List<Employee> employeeList = EmployeeUtil.convertEmployeeDtoListToEmployeeList(employees);
		employeeList = employeeRepository.saveAll(employeeList);
		if (CollectionUtils.isNotEmpty(employeeList)) {
			employees = EmployeeUtil.convertEmployeeListToEmployeeDtoList(employeeList);
			return employees;
		}
		return null;
	}

	@Override
	public EmployeeDto updateEmployee(String id, String name) {
		Employee employee = findById(id);
		employee.setName(name);
		employee = employeeRepository.save(employee);
		return EmployeeUtil.getEmployee(employee);
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee deleted successfully.";
	}

}
