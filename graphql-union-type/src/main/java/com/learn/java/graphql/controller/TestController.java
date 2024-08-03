package com.learn.java.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.graphql.annotation.ValidateRequest;
import com.learn.java.graphql.model.User;
import com.learn.java.graphql.service.UserService;

@RestController
public class TestController {

	@Autowired
	private UserService userService;
	
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
	
	@GetMapping("/user")
	List<User> getUsers() {
		//System.out.println("INSIDE getResult1.");
		return userService.getUsers();
	}
	
	@PutMapping("/user")
	User updateUser(@RequestParam(name = "uid") String uid, @RequestParam(name = "uname") String uname) {
		//System.out.println("INSIDE getResult1.");
		return userService.updateUser(new User(uid, uname));
	}
	
	@DeleteMapping("/user")
	User deleteUser(@RequestParam(name = "uid") String uid) {
		//System.out.println("INSIDE getResult1.");
		return userService.deleteUser(uid);
	}
}
