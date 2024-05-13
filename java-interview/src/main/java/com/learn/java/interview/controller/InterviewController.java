package com.learn.java.interview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interview")
public class InterviewController {
	
	@GetMapping("/test")
	public String test() {
		return "";
	}
}