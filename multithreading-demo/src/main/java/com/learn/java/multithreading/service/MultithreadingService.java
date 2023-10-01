package com.learn.java.multithreading.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

	@SuppressWarnings("static-access")
	public String  threadMethodsDemo1() {
		
		class MyThread extends Thread {
			static int j = 0;
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("--Current Thread Name: " + Thread.currentThread().getName());
				System.out.println("--Current Thread Class Name: " + Thread.currentThread().getClass().getName() + " of " + Thread.currentThread().getName());
				for(int i = 0; i < 10000; i++) {
					j = i;
					j = j + j;
					j = j - j - 1;
					j = 1 + j + 123;
					j = j - 124;
				}
			}
		}
		class MyThread2 implements Runnable {
			static int j = 0;
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("t2::Current Thread Name: " + Thread.currentThread().getName());
				System.out.println("t2::Current Thread Class Name: " + Thread.currentThread().getClass().getName());
				for(int i = 0; i < 10000; i++) {
					j = i;
					j = j + j;
					j = j - j - 1;
					j = 1 + j + 123;
					j = j - 124;
				}				
			}
		}

		Thread t1 = new Thread(new MyThread());
		t1.setName("t1");
		Thread t4 = new Thread(new MyThread());
		t4.setName("t4");
		Thread t2 = new Thread(new ThreadGroup("customThreadGroup"), new MyThread2(), "t2");
		System.out.println("t1.getPriority() "+t1.getPriority());
		System.out.println("t2.getPriority() "+t2.getPriority());
		t1.setPriority(6);
		t2.setPriority(10);
		System.out.println("t1.getPriority() "+t1.getPriority());
		System.out.println("t2.getPriority() "+t2.getPriority());
		System.out.println("t1.getThreadGroup().getName() "+t1.getThreadGroup().getName());
		System.out.println("t2.getThreadGroup().getName() "+t2.getThreadGroup().getName());

		System.out.println("t1.isAlive() "+t1.isAlive());
		System.out.println("t1.isDaemon() "+t1.isDaemon());
		
		System.out.println("t2.isAlive() "+t2.isAlive());
		System.out.println("t2.isDaemon() "+t2.isDaemon());
		
		t2.setDaemon(false);
		System.out.println("t1.isDaemon() "+t1.isDaemon());
		System.out.println("t2.isDaemon() "+t2.isDaemon());
		

		t1.start();
		t4.start();
		t4.yield();
		t2.start();
		try {
			t2.join(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t3 = new Thread(new MyThread());
		t3.start();
		t3.suspend();
		t3.resume();
		t3.stop();
		
		
		
		
		return "Done.";
	}

	public String waitNotifyDemo1() {
		String data = "New Data";
		Thread thread1 = new Thread(() -> {
			synchronized (data) {
				try {
					System.out.println("Consumer: Waiting for data..."+data+System.currentTimeMillis());
					data.wait(1000);
					System.out.println("Consumer: Consuming data....."+data+System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {}	
					
			}
		});		
		Thread thread2 = new Thread(() -> {
			synchronized (data) {
				 System.out.println("Producer: Producing data....."+data+System.currentTimeMillis());
				 data.notify();
			}
		});		
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Part 2\n\n\n");
		System.out.println("t1.isAlive() "+thread1.isAlive());
		System.out.println("t2.isAlive() "+thread2.isAlive());

//		thread1.start();
//		thread2.start();
		return "Done.";
	}

	public String synchronizedDemo1() {
		String data = "New Data";
		Thread thread1 = new Thread(() -> {
			synchronized (data) {
				try {
					System.out.println("Consumer: Waiting for data..."+data+System.currentTimeMillis());
					Thread.sleep(20);
					System.out.println("Consumer: Consuming data....."+data+System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {}
			}
		});		
		Thread thread2 = new Thread(() -> {
			synchronized (data) {
				 System.out.println("Producer: Producing data....."+data+System.currentTimeMillis());
			}
		});		

		thread1.start();
		thread2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Part 2\n\n\n");
		System.out.println("t1.isAlive() "+thread1.isAlive());
		System.out.println("t2.isAlive() "+thread2.isAlive());
		return "Done.";
	}

}
