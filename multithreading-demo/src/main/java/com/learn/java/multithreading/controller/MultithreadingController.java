package com.learn.java.multithreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.multithreading.service.MultithreadingService;

@RestController
@RequestMapping("/multithreading/demo")
public class MultithreadingController {

	@Autowired
	private MultithreadingService multithreadingService;

//	@Autowired
//	private HttpServletRequest request;

	@GetMapping("/extend/thread")
	public String multithreadingByExtendingThreadClassDemo1() {
		System.out.println(multithreadingService.multithreadingByExtendingThreadClassDemo1());
		return "Multithreading By Extending Thread Class Tested Successfully.";
	}

	@GetMapping("/implement/runnable")
	public String multithreadingByImplementingRunnableInterfaceDemo1() {
		System.out.println(multithreadingService.multithreadingByImplementingRunnableInterfaceDemo1());
		return "Multithreading By Implementing Runnable Interface Tested Successfully.";
	}

	@GetMapping("/start")
	public String startDemo1() {
		System.out.println(multithreadingService.startDemo1());
		return "Start Method Tested Successfully.";
	}

	@GetMapping("/thread/methods")
	public String threadMethodsDemo1() {
		System.out.println(multithreadingService.threadMethodsDemo1());
		return "Thread Method Tested Successfully.";
	}

	@GetMapping("/wait/notify")
	public String waitNotifyDemo1() {
		System.out.println(multithreadingService.waitNotifyDemo1());
		return "Wait Notify Method Tested Successfully.";
	}

	@GetMapping("/synchronized")
	public String synchronizedDemo1() {
		System.out.println(multithreadingService.synchronizedDemo1());
		return "Synchronized Keyword Tested Successfully.";
	}

	@GetMapping("/thread/group")
	public String threadGroupDemo1() {
		System.out.println(multithreadingService.threadGroupDemo1());
		return "Thread Group Tested Successfully.";
	}

}
