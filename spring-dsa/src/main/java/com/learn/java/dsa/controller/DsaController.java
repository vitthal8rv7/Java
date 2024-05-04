package com.learn.java.dsa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.dsa.leetcode.Example1;

@RestController
public class DsaController {
	
	@GetMapping("/testExample1")
	public String testExample1() {
		Example1.testExample1();
		return "example1 tested successfully.2";
	}

}
