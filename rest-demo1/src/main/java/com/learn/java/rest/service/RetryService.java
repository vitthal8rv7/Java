package com.learn.java.rest.service;

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
}
