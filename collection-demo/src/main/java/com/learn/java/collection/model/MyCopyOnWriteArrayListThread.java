package com.learn.java.collection.model;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

@Component
public class MyCopyOnWriteArrayListThread extends Thread {
	
	Integer counter = 10;
	public static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
	

	public void iterate() {
		copyOnWriteArrayList.add("A");
		copyOnWriteArrayList.add("B"); 
		copyOnWriteArrayList.add("B"); 
		Iterator<String> iterator =  copyOnWriteArrayList.iterator();
		this.setName("Main Thread");
		MyCopyOnWriteArrayListThread myThread = new MyCopyOnWriteArrayListThread();
		myThread.setName("Thread0");
		myThread.start();

		MyCopyOnWriteArrayListThread myThread1 = new MyCopyOnWriteArrayListThread();
		myThread1.start();
		myThread1.setName("Thread1");
		
		MyCopyOnWriteArrayListThread myThread2 = new MyCopyOnWriteArrayListThread();
		myThread2.start();
		myThread2.setName("Thread2");

		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println("Iterator Thread Sleeping..."+this.getName() );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("concurrentHashMap is : "+ copyOnWriteArrayList);	
	}
	
	public void run () {
		try {
			counter = getCounter();
			System.out.println("Other Thread Adding Values..."+this.getName() + "  "+counter);
			
			if(counter == 10) {
				copyOnWriteArrayList.add("F"+counter); 
				Thread.sleep(100);
			} else if(counter == 11) {
				copyOnWriteArrayList.add("F"+counter); 
				Thread.sleep(100);
			} else if(counter == 12) {
				copyOnWriteArrayList.add("F"+counter); 
				Thread.sleep(100);
			}
			System.out.println("copyOnWriteArrayList : "+copyOnWriteArrayList);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private Integer getCounter() {
		Integer counter2 = counter;
		counter = counter + 1;
		return counter2;
	}
}
