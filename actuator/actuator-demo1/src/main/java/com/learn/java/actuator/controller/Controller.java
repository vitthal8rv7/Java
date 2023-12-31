package com.learn.java.actuator.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.java.actuator.model.Employee;

@RestController
@RequestMapping("/rest/demo")
public class Controller {

	@Autowired
	InMemoryAuditEventRepository repository;
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable String id, @RequestParam String name) {
		System.out.println("Employee Id: " + id + "\nEmployee name: " + name);
		// Get Employee Logic
		AuditEvent event = new AuditEvent("auditEvent1", "auditEvent1", "auditEvent1", "A2");
		repository.add(event);
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
	public Employee setEmployeePicture(@RequestParam(required = true) MultipartFile image) {
		Employee employee = new Employee();
		System.out.println("Employee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		return employee;
	}

	
	@PostMapping(value= "/employee/multipart2")
	public Employee setEmployeePicture2(@RequestParam(required = true) List<MultipartFile> image) {
		Employee employee = new Employee();
		System.out.println("Employee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		return employee;
	}
	
	@GetMapping("/timeout/check1")
	@ResponseBody
	public String testTimeout1() {
		System.out.println("testTimeout1...");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "testTimeout1";
	}


}
