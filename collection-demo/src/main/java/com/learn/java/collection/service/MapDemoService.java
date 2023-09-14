package com.learn.java.collection.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;

import org.springframework.stereotype.Service;

import com.learn.java.collection.mpdel.Student;

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

	/*
	 * 0.) Underlying Data Structure: LinkedList + Hash Table
	 * 
	 * 1.) Insertion Order Preserved (due to linked list) 
	 * 2.) Duplicate Keys Not Allowed, Values can be duplicate 
	 * 3.) NULL insertion is possible 
	 * 4.) No AutoSorting
	 * 
	 */
	public void linkedHashMapDemo() {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("A", "A");
		linkedHashMap.put("B", "B");
		linkedHashMap.put("D", "D");
		linkedHashMap.put("C", "C");
		linkedHashMap.put("F", "F");
		linkedHashMap.put("W", "W");
		linkedHashMap.put("Z", "Z");
		linkedHashMap.put("S", "S");
		linkedHashMap.put("R", "R");
		linkedHashMap.put("A", "A"); //if same key and same value...no changes
		System.out.println("puted Linked Hash Map: " + linkedHashMap);
		linkedHashMap.put(null, null);
		System.out.println("Linked Hash Map after puting null: " + linkedHashMap);
		linkedHashMap.put(null, null);
		System.out.println("Linked Hash Map after puting null: " + linkedHashMap);
		linkedHashMap.put("K", null);
		System.out.println("Linked Hash Map again puting null: " + linkedHashMap);
		linkedHashMap.put("A", "R");
		System.out.println("Linked Hash Map again puting R: " + linkedHashMap);
		System.out.println("Linked Hash Map Contains R? => " + linkedHashMap.containsKey("R"));
		System.out.println("Linked Hash Map Contains null? => " + linkedHashMap.containsKey(null));
		System.out.println("Linked Hash Map removing R by index: " + linkedHashMap.remove(linkedHashMap.size() - 1));
		System.out.println(linkedHashMap);
		System.out.println("Linked Hash Map removing R by Object: " + linkedHashMap.remove("R"));
		System.out.println(linkedHashMap);
		System.out.println(linkedHashMap.entrySet().toString());
		System.out.println(linkedHashMap.entrySet().getClass());
	}

	public void identityHashMapDemo() {
		// TODO Auto-generated method stub

	}

	/*
	 * 0.) Underlying Data Structure: Hash Table (Internally its buckets usages
	 * linked list or tree in collision)
	 * 
	 * 1.) Insertion Order Not Preserved (as per hashing logic) 
	 * 2.) Duplicate Keys Not Allowed, Values can be duplicate 
	 * 3.) NULL insertion is possible 
	 * 4.) No AutoSorting
	 * 
	 * Exactly same as HashMap Except following differences If any Object not have
	 * any reference variable but it associated with HashMap then GC collector can
	 * not destroy this object. But If any Object not have any reference variable
	 * but it associated with WeakHashMap then GC collector can destroy this object.
	 */
	public void weakHashMapDemo() {
		WeakHashMap<Student, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(new Student(), "A");
		weakHashMap.put(new Student(), "BE");
		weakHashMap.put(new Student(), "Z");
		weakHashMap.put(new Student(), "K");
		weakHashMap.put(new Student(), "A");
		System.out.println(weakHashMap.toString());
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
			e.printStackTrace();
		}
		System.out.println(weakHashMap);

	}

	public void treeMapDemo() {
		// TODO Auto-generated method stub

	}

}
