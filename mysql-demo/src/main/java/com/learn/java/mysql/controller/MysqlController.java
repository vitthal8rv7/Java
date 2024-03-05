package com.learn.java.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.mysql.model.dto.EmployeeDto;
import com.learn.java.mysql.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mysql/demo")
public class MysqlController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/{employeeId}")
	public EmployeeDto readEmployee(@PathVariable String employeeId) {
		return employeeService.readEmployee(employeeId);
	}

	@GetMapping("/all/employee")
	public List<EmployeeDto> readAllEmployee() {
		return employeeService.readAllEmployee();
	}

	@PostMapping("/employee")
	public List<EmployeeDto> saveEmployee(@Valid @RequestBody List<EmployeeDto> employees) {
		return employeeService.saveEmployees(employees);
	}

	@PutMapping("/employee")
	public EmployeeDto updateEmployee(@RequestParam(name = "id") String id, @RequestParam(name = "name", required = true) String name) {
		return employeeService.updateEmployee(id, name);
	}

	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam(name = "id") String id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("/test/auto-generated-spring-data-queries")
	public String testAutoGeneratedQueries() {
		employeeService.testAutoGeneratedQueries();
		return "Tested auto-generated-spring-data-queries";
	}

	
	@GetMapping("/test/jpql-queries")
	public String testJpqlQueries() {
		employeeService.testJpqlQueries();
		return "Tested jpql-queries";
	}

}