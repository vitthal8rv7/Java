package com.learn.java.service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncDemoService {

	//Method level executor demo
	@Async("threadPoolTaskExecutor2")
	public void testAsyncMethod(String data)  {
		System.out.println("Inside Async Demo: testAsyncMethod: Thread Name - " + Thread.currentThread().getName());
		sleep(15);
		System.out.println(10 / 0);
	}

	//Application level executor demo
	@Async
	public void testAsyncMethod2(String data)  {
		System.out.println("Inside Async Demo: testAsyncMethod2: Thread Name - " + Thread.currentThread().getName());
		sleep(15);
		System.out.println(10 / 0);
	}

	//Application level executor demo
	@Async
	public Future<String> testAsyncMethod3(String data)  {
		System.out.println("Inside Async Demo: testAsyncMethod2: Thread Name - " + Thread.currentThread().getName());
		sleep(5);
		return new AsyncResult<String>(data + new Date().getMinutes());
	}
	
	//Application level executor demo
	@Async
	public CompletableFuture<String> testAsyncMethod4(String data)  {
		System.out.println("Inside Async Demo: testAsyncMethod2: Thread Name - " + Thread.currentThread().getName());
		sleep(15);
		return new CompletableFuture<String>().supplyAsync(() -> (data + new Date().getMinutes()));
	}

	 private void sleep(int args) {
	        try {
	            TimeUnit.SECONDS.sleep(args);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
