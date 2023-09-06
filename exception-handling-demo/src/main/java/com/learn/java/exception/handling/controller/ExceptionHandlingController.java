package com.learn.java.exception.handling.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.exception.handling.service.ExceptionHandlingService;

@RestController
public class ExceptionHandlingController {

	@Autowired
	public ExceptionHandlingService exceptionHandlingService;
	
	@GetMapping("/try/catch")
	public String tryCatchDemo() {
		exceptionHandlingService.tryCatchDemo();
		return "Try Catch Tested.";
	}

	@GetMapping("/try/multilevel-catch")
	public String tryMultiLevelCatchDemo() {
		exceptionHandlingService.tryMultiLevelCatchDemo();
		return "Try with Multi Level Catch Tested.";
	}

	@GetMapping("/try/multiple-catch")
	public String tryMultipleCatchDemo() {
		exceptionHandlingService.tryMultipleCatchDemo();
		return "Try with Multiple Catch Tested.";
	}
	
	@GetMapping("/try/catch/finally")
	public String tryCatchFinallyDemo() {
		exceptionHandlingService.tryCatchFinallyDemo();
		return "Try Catch Finally Tested.";
	}

	@GetMapping("/try/finally")
	public String tryFinallyDemo() {
		exceptionHandlingService.tryFinallyDemo();
		return "Try Finally Tested.";
	}

	@GetMapping("/try-with-resources")
	public String tryWithResourcesDemo() {
		exceptionHandlingService.tryWithResourcesDemo();
		return "Try With Resources Tested.";
	}

	@GetMapping("/throws")
	public String throwsDemo() throws FileNotFoundException {
		exceptionHandlingService.throwsDemo();
		return "Throws exception to caller Tested.";
	}

	@GetMapping("/throw")
	public String throwDemo() {
		exceptionHandlingService.throwDemo();
		return "Throw new FileNotFound Exception Tested.";
	}

}
