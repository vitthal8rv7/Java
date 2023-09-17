package com.learn.java.java8features.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.java8features.service.Java8FeaturesService;

@RestController
@RequestMapping("/java8-features/demo")
public class Java8FeaturesController {

	@Autowired
	private Java8FeaturesService java8FeaturesService;
	
	@GetMapping("/lambda-expression-multithreading1")
	public String lambdaExpressionMultithreadingDemo1() {
		java8FeaturesService.lambdaExpressionMultithreadingDemo1();
		return "Lambda Expression Multithreading Rules Tested Successfully.";
	}
}
