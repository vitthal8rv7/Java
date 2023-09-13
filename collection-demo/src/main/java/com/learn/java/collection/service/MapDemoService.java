package com.learn.java.collection.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class MapDemoService {

	/*
	 * 0.) Underlying Data Structure: Hash Table (Internally its buckets usages linked list or tree in collision)
	 * 
	 * 1.) Insertion Order Not Preserved (as per hashing logic) 
	 * 2.) Duplicate Keys Not Allowed, Values can be duplicate 
	 * 3.) NULL insertion is possible 
	 * 4.) No AutoSorting
	 * 
	 */
	public void hashMapDemo() {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("A", "A");
		hashMap.put("B", "B");
		hashMap.put("D", "D");
		hashMap.put("C", "C");
		hashMap.put("F", "F");
		hashMap.put("W", "W");
		hashMap.put("Z", "Z");
		hashMap.put("S", "S");
		hashMap.put("R", "R");
		hashMap.put("A", "A"); //if same key and same value...no changes
		System.out.println("puted Hash Map: " + hashMap);
		hashMap.put(null, null);
		System.out.println("Hash Map after puting null: " + hashMap);
		hashMap.put(null, null);
		System.out.println("Hash Map after puting null: " + hashMap);
		hashMap.put("K", null);
		System.out.println("Hash Map again puting null: " + hashMap);
		hashMap.put("A", "R");
		System.out.println("Hash Map again puting R: " + hashMap);
		System.out.println("Hash Map Contains R? => " + hashMap.containsKey("R"));
		System.out.println("Hash Map Contains null? => " + hashMap.containsKey(null));
		System.out.println("Hash Map removing R by index: " + hashMap.remove(hashMap.size() - 1));
		System.out.println(hashMap);
		System.out.println("Hash Map removing R by Object: " + hashMap.remove("R"));
		System.out.println(hashMap);
		System.out.println(hashMap.entrySet().toString());
		System.out.println(hashMap.entrySet().getClass());

	}

	public void linkedHashMapDemo() {
		// TODO Auto-generated method stub

	}

	public void identityHashMapDemo() {
		// TODO Auto-generated method stub

	}

	public void weakHashMapDemo() {
		// TODO Auto-generated method stub

	}

	public void treeMapDemo() {
		// TODO Auto-generated method stub

	}

}
