package com.learn.java.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.rest.service.RetryService;

@RestController
@RequestMapping("/rest/demo")
public class RetryController {

	@Autowired
	private RetryService retryService;
	
	@GetMapping("/retry/test1")
	String retryService(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		//try {
			result = retryService.retryService(data);
		//} catch(Exception e) {
		//	System.out.println("Exception e: "+e);
		//}
		return result;
	}
}