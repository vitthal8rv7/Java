package com.learn.java.collection.service;

import java.util.ArrayList;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class ListDemoService {



	/*
	 * 0.) Underlying Data Structure: Resizable/Growable Array
	 * 
	 * 1.) Insertion Order Preserved
	 * 2.) Duplicates Allowed
	 * 3.) NULL insertion is possible
	 * 4.) No AutoSorting
	 * 
	 * 
	 * */
	public void arrayListDemo() {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("D");
		arrayList.add("C");
		arrayList.add("F");
		arrayList.add("W");
		arrayList.add("Z");
		arrayList.add("S");
		arrayList.add("R");
		arrayList.add("A");
		System.out.println("Added Array List: "+arrayList);
		arrayList.add(null);
		System.out.println("Array List after adding null: "+arrayList);
		arrayList.add(null);
		System.out.println("Array List again adding null: "+arrayList);
		arrayList.add("R");
		System.out.println("Array List again adding R: "+arrayList);
		System.out.println("ArrayList Contains R? => "+arrayList.contains("R"));
		System.out.println("ArrayList Contains null? => "+arrayList.contains(null));		
		System.out.println("ArrayList Contains index of given object ? => "+arrayList.indexOf(null));
		System.out.println("ArrayList Contains Object at index 4 ? => "+arrayList.get(4) );
		System.out.println("Array List removing R: "+arrayList.remove(arrayList.size()-1));
		System.out.println("Array List set R at null: "+arrayList.set(10, "R"));
		System.out.println("Array List again adding R: "+arrayList);

	}

	public void linkedListDemo() {
		// TODO Auto-generated method stub
		
	}
	
	


}
