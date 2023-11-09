package com.learn.java.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.swagger.service.RetryService;

@RestController
@RequestMapping("/swagger/demo")
public class RetryController {

	@Autowired
	private RetryService retryService;

	@GetMapping("/retry/test1")
	String retryService(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		// try {
		result = retryService.retryService(data);
		// } catch(Exception e) {
		// System.out.println("Exception e: "+e);
		// }
		return result;
	}

	@GetMapping("/retry/customize/test2")
	String retryService2(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		// try {
		result = retryService.retryService2(data);
		// } catch(Exception e) {
		// System.out.println("Exception e: "+e);
		// }
		return result;
	}

	@GetMapping("/retry/customize/test3")
	String retryService3(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		// try {
		result = retryService.retryService3(data);
		// } catch(Exception e) {
		// System.out.println("Exception e: "+e);
		// }
		return result;
	}

	@GetMapping("/retry/customize-spring-properties/test4")
	String retryService4(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		// try {
		result = retryService.retryService4(data);
		// } catch(Exception e) {
		// System.out.println("Exception e: "+e);
		// }
		return result;
	}

	@GetMapping("/retry/customize-retry-template/test5")
	String retryService5(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		// try {
		result = retryService.retryService5(data);
		// } catch(Exception e) {
		// System.out.println("Exception e: "+e);
		// }
		return result;
	}

	@GetMapping("/retry/customize-retry-template-listener/test6")
	String retryService6(@RequestParam String data) {
		System.out.println("\nIn Retry Controller...");
		String result = null;
		// try {
		result = retryService.retryService6(data);
		// } catch(Exception e) {
		// System.out.println("Exception e: "+e);
		// }
		return result;
	}
}