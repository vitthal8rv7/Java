package com.learn.java.multithreading;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.learn.java.multithreading")
public class MultithreadingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultithreadingDemoApplication.class, args);
	}

}