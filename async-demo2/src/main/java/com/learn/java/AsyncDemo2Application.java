package com.learn.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.learn.java")
@EnableAsync
public class AsyncDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(AsyncDemo2Application.class, args);
	}

}
