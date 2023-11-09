package com.learn.java.swagger.service;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class DefaultListenerSupport extends RetryListenerSupport {

	@Override
	public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
			Throwable throwable) {
		// logger.info("onClose");
		// ...
		System.out.println("onClose");
		System.out.println("Do some work after retryable completed.(with failed or success)");
		super.close(context, callback, throwable);
	}

	@Override
	public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
			Throwable throwable) {
//        logger.info("onError"); 
//        ...
		System.out.println("onError");
		System.out.println("Do some work when retryable failed.");
		super.onError(context, callback, throwable);
	}

	@Override
	public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
//        logger.info("onOpen");
//        ...
		System.out.println("onOpen");
		System.out.println("Do some work before retryable started.");
		return super.open(context, callback);
	}
}