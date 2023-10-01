package com.learn.java.multithreading.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

@Service
public class MultithreadingService {

	static ThreadLocal<String> threadLocal = new ThreadLocal<>();

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
	public String threadMethodsDemo1() {

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
				System.out.println("--Current Thread Class Name: " + Thread.currentThread().getClass().getName()
						+ " of " + Thread.currentThread().getName());
				for (int i = 0; i < 10000; i++) {
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
				for (int i = 0; i < 10000; i++) {
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
		System.out.println("t1.getPriority() " + t1.getPriority());
		System.out.println("t2.getPriority() " + t2.getPriority());
		t1.setPriority(6);
		t2.setPriority(10);
		System.out.println("t1.getPriority() " + t1.getPriority());
		System.out.println("t2.getPriority() " + t2.getPriority());
		System.out.println("t1.getThreadGroup().getName() " + t1.getThreadGroup().getName());
		System.out.println("t2.getThreadGroup().getName() " + t2.getThreadGroup().getName());

		System.out.println("t1.isAlive() " + t1.isAlive());
		System.out.println("t1.isDaemon() " + t1.isDaemon());

		System.out.println("t2.isAlive() " + t2.isAlive());
		System.out.println("t2.isDaemon() " + t2.isDaemon());

		t2.setDaemon(false);
		System.out.println("t1.isDaemon() " + t1.isDaemon());
		System.out.println("t2.isDaemon() " + t2.isDaemon());

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
					System.out.println("Consumer: Waiting for data..." + data + System.currentTimeMillis());
					data.wait(1000);
					System.out.println("Consumer: Consuming data....." + data + System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}

			}
		});
		Thread thread2 = new Thread(() -> {
			synchronized (data) {
				System.out.println("Producer: Producing data....." + data + System.currentTimeMillis());
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
		System.out.println("t1.isAlive() " + thread1.isAlive());
		System.out.println("t2.isAlive() " + thread2.isAlive());

//		thread1.start();
//		thread2.start();
		return "Done.";
	}

	public String synchronizedDemo1() {
		String data = "New Data";
		Thread thread1 = new Thread(() -> {
			synchronized (data) {
				try {
					System.out.println("Consumer: Waiting for data..." + data + System.currentTimeMillis());
					Thread.sleep(20);
					System.out.println("Consumer: Consuming data....." + data + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
				}
			}
		});
		Thread thread2 = new Thread(() -> {
			synchronized (data) {
				System.out.println("Producer: Producing data....." + data + System.currentTimeMillis());
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
		System.out.println("t1.isAlive() " + thread1.isAlive());
		System.out.println("t2.isAlive() " + thread2.isAlive());
		return "Done.";
	}

	public String threadGroupDemo1() {
		System.out.println("Thread.currentThread().getThreadGroup().getName(): "
				+ Thread.currentThread().getThreadGroup().getName());
		System.out.println("Thread.currentThread().getThreadGroup().getParent().getName(): "
				+ Thread.currentThread().getThreadGroup().getParent().getName());
		ThreadGroup tg = new ThreadGroup("newTG");
		tg.setMaxPriority(7);
		System.out.println("tg.getName(): " + tg.getName());
		System.out.println("tg.getParent().getName(): " + tg.getParent().getName());
		System.out.println("tg.getMaxPriority: " + tg.getMaxPriority());
		ThreadGroup tg2 = new ThreadGroup(tg, "newTG2");
		System.out.println("tg2.getName(): " + tg2.getName());
		System.out.println("tg2.getParent().getName(): " + tg2.getParent().getName());
		System.out.println("tg2.getMaxPriority: " + tg2.getMaxPriority());

		Thread newThread1 = new Thread(tg, () -> {
			System.out.println("Thread.currentThread().getThreadGroup().getName(): "
					+ Thread.currentThread().getThreadGroup().getName());
			System.out.println("Thread.currentThread().getThreadGroup().getParent().getName(): "
					+ Thread.currentThread().getThreadGroup().getParent().getName());
			System.out.println("Thread.currentThread().getPriority(): " + Thread.currentThread().getPriority());
		});
		newThread1.setPriority(8);
		Thread newThread2 = new Thread(tg2, () -> {
			System.out.println("Thread.currentThread().getThreadGroup().getName(): "
					+ Thread.currentThread().getThreadGroup().getName());
			System.out.println("Thread.currentThread().getThreadGroup().getParent().getName(): "
					+ Thread.currentThread().getThreadGroup().getParent().getName());
			System.out.println("Thread.currentThread().getPriority(): " + Thread.currentThread().getPriority());
		});
		newThread2.setPriority(8);
		newThread1.start();
		tg2.setMaxPriority(7);
		newThread2.start();
		Thread.currentThread().getThreadGroup().list();
		tg.list();
		tg2.list();

		System.out.println("Thread.currentThread().getThreadGroup().activeCount(): "
				+ Thread.currentThread().getThreadGroup().activeCount());
		System.out.println("Thread.currentThread().getThreadGroup().activeGroupCount(): "
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		System.out.println("tg.activeCount(): " + tg.activeCount());
		System.out.println("tg.activeGroupCount(): " + tg.activeGroupCount());
		System.out.println("tg2.activeCount(): " + tg2.activeCount());
		System.out.println("tg2.activeGroupCount(): " + tg2.activeGroupCount());

		return "Done.";
	}

	public String concurrentLockDemo1() {
		String data = "New Data";
		ReentrantLock locker = new ReentrantLock();
		Thread thread1 = new Thread(() -> {
			locker.lock();
			locker.lock();
			try {
				System.out.println("Consumer: Waiting for data..." + data + System.currentTimeMillis());
				Thread.sleep(20);
				System.out.println("Consumer: Consuming data....." + data + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("locker.isFair(): " + locker.isFair());
			System.out.println("locker.isLocked(): " + locker.isLocked());
			System.out.println("locker.isHeldByCurrentThread(): " + locker.isHeldByCurrentThread());
			System.out.println("locker.getHoldCount(): " + locker.getHoldCount());
			System.out.println("locker.getQueueLength(): " + locker.getQueueLength());
			System.out.println("locker.hasQueuedThreads(): " + locker.hasQueuedThreads());
			locker.unlock();
			System.out.println("locker.getHoldCount(): " + locker.getHoldCount());
			locker.unlock();
		});
		Thread thread2 = new Thread(() -> {
			locker.lock();
			System.out.println("Producer: Producing data....." + data + System.currentTimeMillis());
			locker.unlock();
		});

		thread1.start();
		thread2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Part 2\n\n\n");
		System.out.println("t1.isAlive() " + thread1.isAlive());
		System.out.println("t2.isAlive() " + thread2.isAlive());

		return "Done.";
	}

	public String concurrentTrylockDemo1() {
		String data = "New Data";
		ReentrantLock locker = new ReentrantLock();
		Thread thread1 = new Thread(() -> {
			if (locker.tryLock()) {
				try {
					System.out.println("Consumer: Waiting for data..." + data + System.currentTimeMillis());
					Thread.sleep(20);
					System.out.println("Consumer: Consuming data....." + data + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("locker.getHoldCount(): " + locker.getHoldCount());
				locker.unlock();
			} else {
				System.out.println("Didn`t get lock for Thread 1... so no action performed yet.");
			}
		});
		Thread thread2 = new Thread(() -> {
			while (true) {
				if (locker.tryLock()) {
					System.out.println("Producer: Producing data....." + data + System.currentTimeMillis());
					locker.unlock();
					break;
				} else {
					System.out.println("Didn`t get lock for Thread 2... so no action performed yet.");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
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
		System.out.println("t1.isAlive() " + thread1.isAlive());
		System.out.println("t2.isAlive() " + thread2.isAlive());

		return "Done.";

	}

	public String threadPoolDemo1() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Thread t1 = new Thread(() -> {
			System.out.println("New Thread: t1 " + Thread.currentThread().getName());
		});

		Thread t2 = new Thread(() -> {
			System.out.println("New Thread: t2 " + Thread.currentThread().getName());
		});

		Thread t3 = new Thread(() -> {
			System.out.println("New Thread: t3 " + Thread.currentThread().getName());
		});

		Thread t4 = new Thread(() -> {
			System.out.println("New Thread: t4 " + Thread.currentThread().getName());
		});

		Thread t5 = new Thread(() -> {
			System.out.println("New Thread: t5 " + Thread.currentThread().getName());
		});

		Thread t6 = new Thread(() -> {
			System.out.println("New Thread: t6 " + Thread.currentThread().getName());
		});
		service.submit(t1);
		service.submit(t2);
		service.submit(t3);
		service.submit(t4);
		service.submit(t5);
		service.submit(t6);
		service.submit(t1);
		service.submit(t2);
		service.submit(t1);
		service.submit(t2);
		service.submit(t1);
		service.submit(t3);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
		return "Done.";
	}

	public String threadLocalDemo1() {
		System.out.println("Thread: " + Thread.currentThread().getName());
		System.out.println("Default threadLocal: " + threadLocal.get());
		System.out.println("\n\n");
		Thread t1 = new Thread(() -> {
			System.out.println("New Thread: t1 " + Thread.currentThread().getName());
			System.out.println("Default threadLocal: " + threadLocal.get());
			threadLocal.set("This Is A New Value For Thread t1");
			System.out.println("Thread Local: " + threadLocal.get());
			newThreadLocalMethod();
		});

		Thread t2 = new Thread(() -> {
			System.out.println("New Thread: t2 " + Thread.currentThread().getName());
			System.out.println("Default threadLocal: " + threadLocal.get());
			threadLocal.set("This Is A New Value For Thread t2");
			System.out.println("Thread Local: " + threadLocal.get());
		});

		Thread t3 = new Thread(() -> {
			System.out.println("New Thread: t3 " + Thread.currentThread().getName());
			System.out.println("Default threadLocal: " + threadLocal.get());
			threadLocal.set("This Is A New Value For Thread t3");
			System.out.println("Thread Local: " + threadLocal.get());
		});
		t1.start();
		t2.start();
		t3.start();
		return "Done.";
	}

	private void newThreadLocalMethod() {
		System.out.println(
				"We can access current thread`s Thread Local(without passing as a argument) in method chaining(any method).: "
						+ threadLocal.get());
	}

}
