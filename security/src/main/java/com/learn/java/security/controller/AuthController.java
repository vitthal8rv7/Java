package com.learn.java.security.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.security.service.UserService;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@GetMapping("/test/enable-method-security")
	public String testEnableMethodSecurity() {
//		userService.testEnableMethodSecurity();
		userService.preAuthorizeTest1();
//		userService.preAuthorizeTest2("");
//		userService.preAuthorizeTest3("", "");
//		userService.preAuthorizeTest4(Arrays.asList("", ""));
//		userService.preAuthorizeTest5(Arrays.asList("", ""), Arrays.asList("", ""));
//		userService.preAuthorizeTest1();
		return "tested enable-method-security";
	}

	
	@GetMapping("/registerUser")
	public String registerUser() {
		userService.registerUser();
		return "userRegistered";
	}
	
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
