package com.learn.java.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@GetMapping("/login")
	public String login() {
		return "login-form";
	}
	
	@GetMapping("/ignore-request")
	public String ignoreRequest() {
		return "ignore-request using webSecurityCustomizer";
	}
	
	@GetMapping("/")
	public String root() {
		return "root";
	}
	
	@GetMapping("/home")
	public String home() {
		return "HomePage";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/user-specific")
	public String userSpecific() {
		return "user-specific";
	}
	
	@GetMapping("/user-specific-readonly")
	public String userSpecificReadonly() {
		return "user-specific-readonly";
	}
	
	@GetMapping("/admin-specific")
	public String adminSpecific() {
		return "admin-specific";
	}
	

	@GetMapping("/update-api")
	public String updateApi() {
		return "update-api";
	}

}
