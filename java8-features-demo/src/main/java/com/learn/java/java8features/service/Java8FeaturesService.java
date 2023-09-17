package com.learn.java.java8features.service;

import org.springframework.stereotype.Service;

@Service
public class Java8FeaturesService {

	public void lambdaExpressionMultithreadingDemo1() {
		Runnable r = () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}		
		};
		Thread t = new Thread(r);
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}		
		
		
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}		
		});
		t2.start();
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}	
	}

}
