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

	@GetMapping("/concurrent/lock")
	public String concurrentLockDemo1() {
		System.out.println(multithreadingService.concurrentLockDemo1());
		return "Concurrent Lock Tested Successfully.";
	}

	@GetMapping("/concurrent/trylock")
	public String concurrentTrylockDemo1() {
		System.out.println(multithreadingService.concurrentTrylockDemo1());
		return "Concurrent Try-Lock Tested Successfully.";
	}

	@GetMapping("/thread/pool")
	public String threadPoolDemo1() {
		System.out.println(multithreadingService.threadPoolDemo1());
		return "Thread Pool Tested Successfully.";
	}

	@GetMapping("/thread/pool/config")
	public String threadPoolDemo2() {
		System.out.println(multithreadingService.threadPoolExecutorDemo2());
		return "Thread Pool Executor Config Tested Successfully.";
	}

	@GetMapping("/thread/local")
	public String threadLocalDemo1() {
		System.out.println(multithreadingService.threadLocalDemo1());
		return "Thread Local Tested Successfully.";
	}

}
