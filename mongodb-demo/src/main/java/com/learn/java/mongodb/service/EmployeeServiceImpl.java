package com.learn.java.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mongodb.collection.Employee;
import com.learn.java.mongodb.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(String id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(String id, String name) {
		Optional<Employee> employeeOp = employeeRepository.findById(id);
		if (employeeOp.isPresent()) {
			Employee employee = employeeOp.get();
			employee.setName(name);
			return employeeRepository.save(employee);
		} else
			return null;
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully";
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween(Float minSalary, Float maxSalary) {
		return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
	}

}
