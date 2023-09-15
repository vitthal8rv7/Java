package com.learn.java.collection.model;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Component;

@Component
public class MyCopyOnWriteArraySetThread extends Thread {
	
	Integer counter = 10;
	public static CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
	

	public void iterate() {
		copyOnWriteArraySet.add("A");
		copyOnWriteArraySet.add("B"); 
		copyOnWriteArraySet.add("B"); 
		Iterator<String> iterator =  copyOnWriteArraySet.iterator();
		this.setName("Main Thread");
		MyCopyOnWriteArraySetThread myThread = new MyCopyOnWriteArraySetThread();
		myThread.setName("Thread0");
		myThread.start();

		MyCopyOnWriteArraySetThread myThread1 = new MyCopyOnWriteArraySetThread();
		myThread1.start();
		myThread1.setName("Thread1");
		
		MyCopyOnWriteArraySetThread myThread2 = new MyCopyOnWriteArraySetThread();
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
		System.out.println("copyOnWriteArraySet is : "+ copyOnWriteArraySet);	
	}
	
	public void run () {
		try {
			counter = getCounter();
			System.out.println("Other Thread Adding Values..."+this.getName() + "  "+counter);
			
			if(counter == 10) {
				copyOnWriteArraySet.add("F"+counter); 
				Thread.sleep(100);
			} else if(counter == 11) {
				copyOnWriteArraySet.add("F"+counter); 
				Thread.sleep(100);
			} else if(counter == 12) {
				copyOnWriteArraySet.add("F"+counter); 
				Thread.sleep(100);
			}
			System.out.println("copyOnWriteArraySet : "+copyOnWriteArraySet);
			
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
