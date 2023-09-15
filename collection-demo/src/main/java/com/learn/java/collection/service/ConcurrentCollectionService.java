package com.learn.java.collection.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.collection.model.MyConcurrentHashMapThread;

@Service
public class ConcurrentCollectionService {

	@Autowired
	private MyConcurrentHashMapThread myConcurrentHashMapThread;
	
	public void concurrentHashMapDemo() {
		
		//Concurrent hash map new methods
		
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("1", "A");
		concurrentHashMap.put("1", "B"); //if key exists, old value will replace with new value 
		System.out.println("if key exists, old value will replace with new value "+concurrentHashMap);
		System.out.println();
		
		concurrentHashMap.put("2", "C");
		concurrentHashMap.putIfAbsent("2", "D"); //if key exists, no action performed. skipped
		System.out.println("if key exists, no action performed. skipped "+concurrentHashMap);
		System.out.println();
		
		concurrentHashMap.replace("2", "D", "C"); //if key and value not match, no action performed
		System.out.println("if key and value not match, no action performed "+concurrentHashMap);  
		concurrentHashMap.replace("2", "C", "D"); //if key and value match, replacement happened
		System.out.println("if key and value match, replacement happened "+concurrentHashMap);
		System.out.println();
		
		concurrentHashMap.remove("2", "C"); //if key and value not match, no action performed
		System.out.println("if key and value not match, no action performed "+concurrentHashMap);
		concurrentHashMap.remove("2", "D"); //if key and value match, removed action performed
		System.out.println("if key and value match, removed action performed "+concurrentHashMap);
		System.out.println();
		
		System.out.println("Calling iterator method...");
		myConcurrentHashMapThread.iterate();
		
		
	}

	public void copyOnWriteArrayListDemo() {
		// TODO Auto-generated method stub
		
	}

	public void copyOnWriteArraySetDemo() {
		// TODO Auto-generated method stub
		
	}

}
