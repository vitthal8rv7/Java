package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AnonymousInnerClassService;
import com.example.demo.service.MethodLocalInnerClassService;
import com.example.demo.service.RegularInnerClassService;

@RestController
@RequestMapping("/inner-class/demo")
public class InnerClassController {

	@Autowired
	private RegularInnerClassService regularInnerClassService;

	@Autowired
	private MethodLocalInnerClassService methodLocalInnerClassService;

	@Autowired
	private AnonymousInnerClassService anonymousInnerClassService;
	
	@GetMapping("/regular-inner-class")
	public String regularInnerClassDemo() {
		regularInnerClassService.regularInnerClassDemo();
		return "Regular Inner Class Rules Tested Successfully.";
	}
	
	@GetMapping("/method-local-inner-class")
	public String methodLocalInnerClassDemo() {
		methodLocalInnerClassService.methodLocalInnerClassDemo();
		return "Method Local Inner Class Rules Tested Successfully.";
	}
	
	@GetMapping("/anonymous-inner-class")
	public String anonymousInnerClassDemo() {
		anonymousInnerClassService.anonymousInnerClassDemo();
		return "Anonymous Inner Class Rules Tested Successfully.";
	}
}
