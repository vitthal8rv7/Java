package com.learn.java.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
//@EnableRetry
public class RestDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestDemo1Application.class, args);
	}

}
