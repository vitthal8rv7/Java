package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RegularInnerClassService;

@RestController
@RequestMapping("/inner-class/demo")
public class InnerClassController {

	@Autowired
	private RegularInnerClassService regularInnerClassService;
	
	@GetMapping("/regular-inner-class")
	public String regularInnerClassDemo() {
		regularInnerClassService.regularInnerClassDemo();
		return "Regular Inner Class Rules Tested Successfully.";
	}
}
