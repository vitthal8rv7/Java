package com.learn.java.interview.schedule;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	
	//The seven parameter CRON expression is only supported as of Spring 5.3 with Spring Boot 2.7
	//@Scheduled(cron = "* * * ? * * 2002-2025")
	//Encountered invalid @Scheduled method 'cronJob': 
	//Cron expression must consist of 6 fields (found 7 in "* * * ? * * 2002-2025")
	
	//But still not working with updated version...
	
	/*
	 * every Second, 
	 * every Minute, 
	 * every Hours, 
	 * every Day of month (no specific value), 
	 * every Month (every month), 
	 * every Day of the week
     *
    */
    @Scheduled(cron = "* * * * * ?")
    public void cronJob() {
        System.out.println("Scheduled job executed at: " + LocalDateTime.now());
    }
//		SAME AS ABOVE    
//    @Scheduled(cron = "* * * * * *")
//    public void cronJob2() {
//        System.out.println("Scheduled job executed at: " + LocalDateTime.now());
//    }
    
    
//    @Scheduled(cron = "* 1, 12, 14-19, 22, 58 * * * ?")
//    public void cronJob3() {
//        System.out.println("Scheduled job executed at: " + LocalDateTime.now());
//    }
    
    
}