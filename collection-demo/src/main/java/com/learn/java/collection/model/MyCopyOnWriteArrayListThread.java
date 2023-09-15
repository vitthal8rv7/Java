package com.learn.java.collection.model;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class MyCopyOnWriteArrayListThread extends Thread {
	
	Integer counter = 10;
	public static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
	

	public void iterate() {
		concurrentHashMap.put("1", "A");
		concurrentHashMap.put("2", "B");
		concurrentHashMap.put("3", "C");
		concurrentHashMap.put("4", "D");
		concurrentHashMap.put("5", "E");
		concurrentHashMap.put("6", "F");
		Iterator<Map.Entry<String,String>> iterator = (Iterator<Map.Entry<String,String>>) concurrentHashMap.entrySet().iterator();
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
		System.out.println("concurrentHashMap is : "+ concurrentHashMap);	
	}
	
	public void run () {
		try {
			counter = getCounter();
			System.out.println("Other Thread Adding Values..."+this.getName() + "  "+counter);
			
			if(counter == 10) {
				concurrentHashMap.put(""+counter, "F"+counter); 
				Thread.sleep(100);
			} else if(counter == 11) {
				concurrentHashMap.put(""+counter, "F"+counter); 
				Thread.sleep(100);
			} else if(counter == 12) {
				concurrentHashMap.put(""+counter, "F"+counter); 
				Thread.sleep(100);
			}
			System.out.println("concurrentHashMap : "+concurrentHashMap);
			
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
