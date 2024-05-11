package com.learn.java.junit5.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

class TimeoutDemo {

    @BeforeEach
    @Timeout(5)
    void setUp() {
        // fails if execution time exceeds 5 seconds
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds500Milliseconds() {
    	try {
			Thread.sleep(280);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	var j = 10;
    	var i = 9;
    	assertTrue((j-i) == 1);
        // fails if execution time exceeds 500 milliseconds
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    void failsIfExecutionTimeExceeds500MillisecondsInSeparateThread() {
    	System.out.println(""+Thread.currentThread().getName());
//    	var k = 200;
//    	try {
//			Thread.sleep(j);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
//    	for(int i = 0; i<10000; i++) {
//        	for(int j = 0; j<10000; j++) {
//        		if(i == j) {
//        			//
//        		} else {
//        			//
//        		}
//        	}    		
//    	}
    	System.out.println(""+Thread.currentThread().getName());
        // fails if execution time exceeds 500 milliseconds, the test code is executed in a separate thread
    }

}
