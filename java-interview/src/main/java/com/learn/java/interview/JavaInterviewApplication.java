package com.learn.java.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.java.interview.service.InterviewDemoService;

@SpringBootApplication
public class JavaInterviewApplication {

	@Autowired
	private InterviewDemoService interviewDemoService;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaInterviewApplication.class, args);
		
	}

}
