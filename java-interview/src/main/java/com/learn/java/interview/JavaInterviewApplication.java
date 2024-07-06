package com.learn.java.interview;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.learn.java.interview.service.InterviewDemoService;

@SpringBootApplication
//@EnableScheduling
public class JavaInterviewApplication {

	@Autowired
	private InterviewDemoService interviewDemoService;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaInterviewApplication.class, args);
		
	}

	//The seven parameter CRON expression is only supported as of Spring 5.3 with Spring Boot 2.7
	//@Scheduled(cron = "* * * ? * * 2002-2025")
	//Encountered invalid @Scheduled method 'cronJob': 
	//Cron expression must consist of 6 fields (found 7 in "* * * ? * * 2002-2025")
	
	
	
//	@Scheduled(cron = "0 15 10 ? * 6L 2002-2025")
//	@Scheduled(cron = "* * * ? * * 2002-2025")
//	public void cronJob() {
//		System.out.println(LocalTime.now().getSecond());
//	}

}
