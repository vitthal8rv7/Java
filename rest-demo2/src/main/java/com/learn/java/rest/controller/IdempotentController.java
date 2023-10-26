package com.learn.java.rest.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/demo")
public class IdempotentController {

	private Set<String> processedKeys = new HashSet<>();
	
	@GetMapping("/idempotent/test")
	@ResponseBody
	public ResponseEntity<String> testidempotent(@RequestHeader("Idempotency-Key") String idempotencyKey) {
		if (processedKeys.contains(idempotencyKey)) {      //retry same request
			// Return the result of the previous operation
			System.out.println("Return the result of the previous operation.");
			return ResponseEntity.ok("Request with the same idempotency key already processed.");
		} else {
			//Create Resource and Increase Counter.
			System.out.println("Create Resource.");
			processedKeys.add(idempotencyKey);
			return ResponseEntity.status(HttpStatus.CREATED).body("Resource created.");
		}
	}
}