package com.learn.java.graphql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.graphql.annotation.ValidateRequest;

@RestController
public class TestController {

	@ValidateRequest(message = "not valid request.")
	Integer value = 10;
	
	@GetMapping("/valid")
	@ValidateRequest(message = "not valid request.")
	String getResult() {
		System.out.println("INSIDE getResult1.");
		
		value = 20;
		System.out.println("INSIDE getResult2."+ value);
		return "";
	}
}
