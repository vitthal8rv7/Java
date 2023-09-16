package com.learn.java.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.service.AsyncDemoService;

@RestController
public class AsyncController {

	@Autowired
	AsyncDemoService asyncObj;
	
	//Method level executor demo
	@GetMapping("/testDemo1")
	public String testDemo1() {
		System.out.println("Inside Controller: testDemo1: Thread Name - " + Thread.currentThread().getName());
		asyncObj.testAsyncMethod("asd");
		return "test completed";
	}
	
	//Application level executor demo
	@GetMapping("/testDemo2")
	public String testDemo2() {
		System.out.println("Inside Controller: testDemo2: Thread Name - " + Thread.currentThread().getName());
		asyncObj.testAsyncMethod2("asd");
		return "test completed";

	}
	
	//Method level executor demo
	@GetMapping("/testDemo3")
	public String testDemo3() {
		System.out.println("Inside Controller: testDemo1: Thread Name - " + Thread.currentThread().getName());
		Future<String> result = asyncObj.testAsyncMethod3("asd");
		while(true) {
			if(result.isDone()) {
				try {
					System.out.println("Result is : "+result.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break; //break loop
			}
			System.out.println("Waiting to complete the task.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "test completed";
	}
	
	//Application level executor demo
	@GetMapping("/testDemo4")
	public String testDemo4() {
		System.out.println("Inside Controller: testDemo2: Thread Name - " + Thread.currentThread().getName());
		CompletableFuture<String> result = asyncObj.testAsyncMethod4("asd");
		result.thenAccept(r -> {
			System.out.println("Result is : "+r);		    
		}).exceptionally(ex -> {
			System.out.println("Exception: "+ ex.getMessage());
			return null;
		});
		System.out.println("Inside Controller after async called, main thread works.");
		return "test completed";

	}

	//Application level executor demo
	@GetMapping("/testDemo5")
	public String testDemo5() {
		System.out.println("Inside Controller: testDemo2: Thread Name - " + Thread.currentThread().getName());
		CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
		    System.out.println("Your asynchronous task logic here");
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return "42";
		});
		result.thenAccept(r -> {
			System.out.println("Result is : "+r);		    
		}).exceptionally(ex -> {
			System.out.println("Exception: "+ ex.getMessage());
			return null;
		});
		System.out.println("Inside Controller after async called, main thread works.");
		return "test completed";

	}
	
}
