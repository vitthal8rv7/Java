package com.learn.java.rest.service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	int counter = 1;

	@Retryable
	public String retryService(String data) {
		System.out.println("\nIn Retry Service...");
		System.out.println("time: " + System.currentTimeMillis());
		if (data.length() > 2) {
			System.out.println("Retry Again...");
			System.out.println("Retry Count = " + counter++);
			if (counter > 3) {
				counter = 1;
			}
			throw new NumberFormatException();
		}
		return "Operation data: " + data;
	}

//	@Recover
//	String recover(NumberFormatException e, String data) {
//		System.out.println("In Recovery Method Service...");
//		System.out.println("We will try another ways to complete this task.");
//		return ""+e;
//	}
	
	@Recover
	String recover(Exception e, String data) {
		System.out.println("In Recovery Method Service...");
		System.out.println("We will try another ways to complete this task.");
		return ""+e;
	}
}
