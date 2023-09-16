	package com.learn.java.config;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	    @Override
	    public void handleUncaughtException(final Throwable throwable, final Method method, final Object... obj) {
	        System.out.println("INSIDE EXCEPTION HANDLER");
	    	System.out.println("Exception message - " + throwable.getMessage());
	        System.out.println("Method name - " + method.getName());
	        for (final Object param : obj) {
	            System.out.println("Param - " + param);
	        }
	    }

	}
