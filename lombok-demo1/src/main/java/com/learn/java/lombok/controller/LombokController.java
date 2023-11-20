package com.learn.java.lombok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.lombok.model.Employee;

@RestController
@RequestMapping("/lombok/demo")
public class LombokController {

	@GetMapping("/employee")
	Employee getEmplyee() {
		Employee employee = new Employee();
		
		return employee;
	}
}
