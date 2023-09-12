package com.learn.java.collection.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

@Service
public class SetDemoService {

	/*
	 * 0.) Underlying Data Structure: Hash Table
	 * 
	 * 1.) Insertion Order Not Preserved (as per hashing logic)
	 * 2.) Duplicates Not Allowed
	 * 3.) NULL insertion is possible
	 * 4.) No AutoSorting
	 * 
	 * 
	 * */
	public void hashSetDemo() {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("D");
		hashSet.add("C");
		hashSet.add("F");
		hashSet.add("W");
		hashSet.add("Z");
		hashSet.add("S");
		hashSet.add("R");
		hashSet.add("A");
		System.out.println("Added Hash Set: "+hashSet);
		hashSet.add(null);
		System.out.println("Hash Set after adding null: "+hashSet);
		hashSet.add(null);
		System.out.println("Hash Set again adding null: "+hashSet);
		hashSet.add("R");
		System.out.println("Hash Set again adding R: "+hashSet);
		System.out.println("Hash Set Contains R? => "+hashSet.contains("R"));
		System.out.println("Hash Set Contains null? => "+hashSet.contains(null));		
		System.out.println("Hash Set removing R by index: "+hashSet.remove(hashSet.size()-1));
		System.out.println(hashSet);
		System.out.println("Hash Set removing R by Object: "+hashSet.remove("R"));
		System.out.println(hashSet);

	}

	public void linkedHashSetDemo() {
		// TODO Auto-generated method stub
		
	}

	public void treeSetDemo() {
		// TODO Auto-generated method stub
		
	}

}
