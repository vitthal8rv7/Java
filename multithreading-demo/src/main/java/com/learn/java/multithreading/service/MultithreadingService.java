package com.learn.java.multithreading.service;

import org.springframework.stereotype.Service;

@Service
public class MultithreadingService {

	public String multithreadingByExtendingThreadClassDemo1() {
		class MyThread extends Thread {
			public void run() {
				System.out.println("Current Thread Name: " + Thread.currentThread().getName());
				System.out.println("Current Thread Class Name: " + Thread.currentThread().getClass().getName());
			}
		}
		MyThread t1 = new MyThread();
		t1.setName("MyThread_1");
		t1.start();
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		System.out.println("Current Thread Class Name: " + Thread.currentThread().getClass().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("isAlive: " + t1.isAlive());
		return "Done.";
	}

	public String multithreadingByImplementingRunnableInterfaceDemo1() {
		class MyThread implements Runnable {
			public void run() {
				System.out.println("Current Thread Name: " + Thread.currentThread().getName());
				System.out.println("Current Thread Class Name: " + Thread.currentThread().getClass().getName());
			}
		}

		Thread t2 = new Thread(new MyThread());
		t2.setName("MyThread_2");
		t2.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("is t2 Alive: " + t2.isAlive());
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		System.out.println("Current Thread Class Name: " + Thread.currentThread().getClass().getName());
		return "Done.";
	}

	public String startDemo1() {

		class MyThread extends Thread {
			public void run() {
				System.out.println("-Current Thread Name: " + Thread.currentThread().getName());
				System.out.println("-Current Thread Class Name: " + Thread.currentThread().getClass().getName());
			}

			public void start() {
				System.out.println("In Overrided Start Method."); // start method called by main/default thread only. So
																	// current thread is main/default thread.
				System.out.println(":Current Thread Name: " + Thread.currentThread().getName());
				System.out.println(":Current Thread Class Name: " + Thread.currentThread().getClass().getName());
				super.start(); // Thread class start method invoked, new thread will be created
			}
		}
		MyThread t1 = new MyThread();
		t1.setName("MyThread_1");
		t1.start();
		System.out.println(".Current Thread Name: " + Thread.currentThread().getName());
		System.out.println(".Current Thread Class Name: " + Thread.currentThread().getClass().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("isAlive: " + t1.isAlive());
		return "Done.";
	}

}
