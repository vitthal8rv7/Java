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
//    @Scheduled(cron = "* * * * * ?")
//    public void cronJob() {
//        System.out.println("Scheduled job executed at: " + LocalDateTime.now());
//    }
//		SAME AS ABOVE    
//    @Scheduled(cron = "* * * * * *")
//    public void cronJob2() {
//        System.out.println("Scheduled job executed at: " + LocalDateTime.now());
//    }
    
    /*
     * The task will run at seconds 1, 12, 14, 15, 16, 17, 18, 19, 22, and 58 of each minute, 
     * every hour, every day of the month, every month, day of the week
     * */
//    @Scheduled(cron = "1,12,14-19,22,58 * * * * ?")
//    public void cronJob3() {
//        System.out.println("Scheduled job executed at: " + LocalDateTime.now());
//    }
//

	/*
	 * every 4th Second of 43th Minute of every Hours 
	   of every Day of month (no specific value) 
	   of every Month (every month) of every Day of the week
     *
     *
     * every 4th Second of 43th Minute of every Hours 
     * 			==> 15 time in 1 every 1 Hour, again 15 time in next Hour and so on... 
    */	
//  @Scheduled(cron = "*/4 43 * * * ?")
//  public void cronJob4() {
//      System.out.println("Scheduled job executed at: " + LocalDateTime.now());
//  }

//	  @Scheduled(cron = "0/4 * * * * ?")
//	  public void cronJob5() {
//	      System.out.println("Scheduled job 5 executed at: " + LocalDateTime.now());
//	  }
//
//	  @Scheduled(cron = "*/4 * * * * ?")
//	  public void cronJob6() {
//	      System.out.println("Scheduled job 6 executed at: " + LocalDateTime.now());
//	  }
//	  @Scheduled(cron = "0/4 * * * * ?") (cronJob5):
//	    every 4 seconds starting from the 0th second of each minute. 
//	    Starting Point: starts the job at the exact 0th second of each minute 
//		  
//	  @Scheduled(cron = "*/4 * * * * ?") (cronJob6):
//		every 4 seconds. 
//		Starting Point: starts the job at any second of the minute, not wait for 0th second

//		But Practically both run any 4th second of the minute, not wait for 0th second
//	  	@Scheduled(cron = "0/4 * * * * ?") (cronJob5): not wait for 0th second, it work like @Scheduled(cron = "*/4 * * * * ?") (cronJob6):

	  
	  
	
}