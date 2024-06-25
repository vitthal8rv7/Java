package com.learn.java.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public Employee setEmployeePicture(@RequestParam(required = true) MultipartFile image) {
		Employee employee = new Employee();
		System.out.println("Employee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		return employee;
	}


	//select form-data
	//Add "image"(param name mentioned in this method) with file
	//Add more "image" with different file for multiple uploads. 
	@PostMapping(value= "/employee/multipart2")
	public Employee setEmployeePicture2(@RequestParam(required = true) List<MultipartFile> image) {
		Employee employee = new Employee();
		System.out.println("Employee Id: " + employee.getId() + "\nEmployee name: " + employee.getName());
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		return employee;
	}
	
	@PostMapping(value= "/employee/multipart3")
	public ResponseEntity<Resource> setEmployeePicture3(@RequestParam(required = false) List<MultipartFile> image, 
			@RequestParam(value = "emp", required = false) String emp) {
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		System.out.println("Is Empty Emp: " + Objects.isNull(emp));
		System.out.println("Emp: " + emp);
		// Set Employee Logic
		 try {
	            // Convert MultipartFile to Resource
	            Resource resource = new InputStreamResource(image.get(0).getInputStream());

	            // Set the response headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + image.get(0).getOriginalFilename());
	            headers.add(HttpHeaders.CONTENT_TYPE, image.get(0).getContentType());

	            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        } 
		
	}

	@PostMapping(value= "/employee/multipart4")
	public ResponseEntity<List<Resource>> setEmployeePicture4(@RequestParam(required = false) List<MultipartFile> image) {
		System.out.println("Is Empty Image: " + Objects.isNull(image));
		// Set Employee Logic
		 List<Resource> resources = new ArrayList<>();
	     List<String> fileNames = new ArrayList<>();
		 try {
			 for (MultipartFile file : image) {
	                if (!file.isEmpty()) {
	                    // Convert MultipartFile to Resource
	                    Resource resource = new InputStreamResource(file.getInputStream());
	                    resources.add(resource);
	                    fileNames.add(file.getOriginalFilename());
	                }
	            }
	          
			 	// Set the response headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + String.join(", ", fileNames));
	            headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");

	            return new ResponseEntity<>(resources, headers, HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        } 
		
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
