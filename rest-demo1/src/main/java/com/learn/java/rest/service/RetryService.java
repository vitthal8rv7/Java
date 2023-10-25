package com.learn.java.rest.service;

import java.sql.SQLException;

import org.springframework.retry.annotation.Backoff;
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
		return "" + e;
	}

	@Retryable(value = {SQLException.class}, maxAttempts = 4, backoff = @Backoff(delay = 100))
	public String retryService2(String data) {
		System.out.println("\nIn Retry Service... & exceptionExpression = \"SQLException.class\"");
		System.out.println("time: " + System.currentTimeMillis());
		if (data.length() > 3) {
			System.out.println("Retry Again...");
			System.out.println("Retry Count = " + counter++);
			if (counter > 3) {
				counter = 1;
			}
			throw new NumberFormatException();
		}
		return "Operation data: " + data;
	}
	
	@Retryable(value = {NumberFormatException.class}, maxAttempts = 5, backoff = @Backoff(delay = 100))
	public String retryService3(String data) {
		System.out.println("\nIn Retry Service... & exceptionExpression = \"NumberFormatException.class\"");
		System.out.println("time: " + System.currentTimeMillis());
		if (data.length() > 7) {
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
