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
	
	@GetMapping("/lambda-expression-collection1")
	public String lambdaExpressionCollectionDemo1() {
		java8FeaturesService.lambdaExpressionCollectionDemo1();
		return "Lambda Expression Collection Rules Tested Successfully.";
	}
	
	@GetMapping("/default-method")
	public String defaultMethodDemo1() {
		java8FeaturesService.defaultMethodDemo1();
		return "Default Method Rules Tested Successfully.";
	}
	
	@GetMapping("/static-method")
	public String staticMethodDemo1() {
		java8FeaturesService.staticMethodDemo1();
		return "Static Method Rules Tested Successfully.";
	}
	
	@GetMapping("/predicate")
	public String predicateDemo1() {
		java8FeaturesService.predicateDemo1();
		return "Predicate Rules Tested Successfully.";
	}

	@GetMapping("/function")
	public String functionDemo1() {
		java8FeaturesService.functionDemo1();
		return "Function Rules Tested Successfully.";
	}

	@GetMapping("/consumer")
	public String consumerDemo1() {
		java8FeaturesService.consumerDemo1();
		return "Consumer Rules Tested Successfully.";
	}

	@GetMapping("/supplier")
	public String supplierDemo1() {
		java8FeaturesService.supplierDemo1();
		return "Supplier Rules Tested Successfully.";
	}
	
	@GetMapping("/primitive/functions")
	public String primitiveFunctionsDemo1() {
		java8FeaturesService.primitiveFunctionsDemo1();
		return "Primitive Functions Rules Tested Successfully.";
	}
	
	@GetMapping("/reference")
	public String referenceDemo1() {
		java8FeaturesService.referenceDemo1();
		return "Method Reference, Constructor Reference, and :: operator Rules Tested Successfully.";
	}

}
