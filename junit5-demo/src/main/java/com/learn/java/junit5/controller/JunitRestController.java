package com.learn.java.junit5.controller;

import com.learn.java.junit5.model.Employee;
import com.learn.java.junit5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class JunitRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<String> returnStringWithResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/get-string")
    public String returnString() {
        return "Hello World!";
    }

    @GetMapping("/employee-as-string")
    public String returnEmployeeAsString() {
        return employeeService.getEmployeeAsString();
    }

    @GetMapping("/employee")
    public Employee returnEmployee() {
        return employeeService.getEmployee();
    }

    @PostMapping("/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/read-multipart-file")
    public ResponseEntity<String> readData(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(file.getOriginalFilename());
    }
}
