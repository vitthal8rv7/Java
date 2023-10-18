package com.learn.java.rest.controller;

import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.java.rest.model.Employee;

@RestController
@RequestMapping("/rest/demo")
public class Controller {

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable String id, @RequestParam String name) {
		System.out.println("Employee Id: " + id + "\nEmployee name: " + name);
		// Get Employee Logic
		Employee employee = new Employee(id, name);
		return employee;
	}

	@PostMapping("/employee")
	public Employee setEmployee(@RequestBody Employee employee) {
		System.out.println("Employee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		// Set Employee Logic
		return employee;
	}

//	@PostMapping(value= "/employee/multipart", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE},
//    produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value= "/employee/multipart")
	public Employee setEmployeePicture(@RequestParam(value = "image", required = false) MultipartFile image) {
		Employee employee = new Employee();
		System.out.println("Employee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		return employee;
	}

}
