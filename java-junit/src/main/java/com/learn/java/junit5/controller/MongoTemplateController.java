package com.learn.java.junit5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.junit5.collection.Employee;
import com.learn.java.junit5.service.MongoTemplateService;

@RestController
@RequestMapping("/mongo/template/demo")
public class MongoTemplateController {

	@Autowired
	private MongoTemplateService employeeService;

	@GetMapping("/employee/all")
	public List<Employee> getEmployeeAll() {
		return employeeService.getEmployeeAll();
	}

	@GetMapping("/employee")
	public Employee getEmployee(@RequestParam(name = "id") String id) {
		return employeeService.getEmployee(id);
	}

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name) {
		return employeeService.updateEmployee(id, name);
	}

	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam(name = "id") String id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("/employee/salary")
	public List<Employee> getEmployeeBySalary(@RequestParam(name = "salary") Float salary) {
		return employeeService.getEmployeeBySalary(salary);
	}

	@GetMapping("/employee/salary/between")
	public List<Employee> getEmployeeBySalaryBetween(@RequestParam(name = "minSalary") Float minSalary,
			@RequestParam(name = "maxSalary") Float maxSalary) {
		return employeeService.getEmployeeBySalaryBetween(minSalary, maxSalary);
	}

	@GetMapping("/test/mongo-template-criteria")
	public String testCriteriaWithMongoTemplate() {
		employeeService.testCriteriaWithMongoTemplate();
		return "Tested All Criterias With Mongo Template";
	}
}
