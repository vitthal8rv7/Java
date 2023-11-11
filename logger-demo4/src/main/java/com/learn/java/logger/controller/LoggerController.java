package com.learn.java.logger.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.logger.model.Employee;

@RestController
@RequestMapping("/logger/demo")
public class LoggerController {

	private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@GetMapping("/log-levels")
	public String checkLogLevels() {
		logger.info("Log Level : INFO");
		logger.trace("Log Level : TRACE");
		logger.warn("Log Level : WARN");
		logger.debug("Log Level : DEBUG");
		logger.error("Log Level : ERROR");
		return "Log Level Checked.\n Default Log Level Is INFO.";
	}

	@GetMapping("/employee")
	public Employee getEmployee(@RequestParam String employeeId) {
		logger.info("Inside get employee");
		Employee employee = new Employee();
		employee.setId(employeeId);
		employee.setName("E-" + employeeId);
		return employee;
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("Inside add employee");
		return employee;
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		logger.info("Inside update employee");
		return employee;
	}

	@PatchMapping("/employee")
	public Employee updateEmployeeName(@RequestParam String employeeId, @RequestParam String employeeName) {
		logger.info("Inside update employee name");
		Employee employee = new Employee();
		employee.setId(employeeId);
		employee.setName(employeeName);
		return employee;
	}

	@DeleteMapping("/employee")
	public Boolean deleteEmployee(@RequestParam String employeeId) {
		logger.info("Inside delete employee");
		return true;
	}

}
