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
	 */
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
		System.out.println("Added Array List: " + arrayList);
		arrayList.add(null);
		System.out.println("Array List after adding null: " + arrayList);
		arrayList.add(null);
		System.out.println("Array List again adding null: " + arrayList);
		arrayList.add("R");
		System.out.println("Array List again adding R: " + arrayList);
		System.out.println("ArrayList Contains R? => " + arrayList.contains("R"));
		System.out.println("ArrayList Contains null? => " + arrayList.contains(null));
		System.out.println("ArrayList Contains index of given object ? => " + arrayList.indexOf(null));
		System.out.println("ArrayList Contains Object at index 4 ? => " + arrayList.get(4));
		System.out.println("Array List removing R: " + arrayList.remove(arrayList.size() - 1));
		System.out.println("Array List set R at null: " + arrayList.set(10, "R"));
		System.out.println("Array List again adding R: " + arrayList);

	}

	/*
	 * 0.) Underlying Data Structure: LinkedList
	 * 
	 * 1.) Insertion Order Preserved 
	 * 2.) Duplicates Allowed 
	 * 3.) NULL insertion is possible 
	 * 4.) No AutoSorting
	 * 
	 */
	public void linkedListDemo() {
		// TODO Auto-generated method stub
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("D");
		linkedList.add("C");
		linkedList.add("F");
		linkedList.add("W");
		linkedList.add("Z");
		linkedList.add("S");
		linkedList.add("R");
		linkedList.add("A");
		System.out.println("Added Linked List: " + linkedList);
		linkedList.add(null);
		System.out.println("Linked List after adding null: " + linkedList);
		linkedList.add(null);
		System.out.println("Linked List again adding null: " + linkedList);
		linkedList.add("R");
		System.out.println("Linked List again adding R: " + linkedList);
		System.out.println("Linked List Contains R? => " + linkedList.contains("R"));
		System.out.println("Linked List Contains null? => " + linkedList.contains(null));
		System.out.println("Linked List Contains index of given object ? => " + linkedList.indexOf(null));
		System.out.println("Linked List Contains Object at index 4 ? => " + linkedList.get(4));
		System.out.println("Linked List removing R: " + linkedList.remove(linkedList.size() - 1));
		System.out.println("Linked List set R at null: " + linkedList.set(10, "R"));
		System.out.println("Linked List again adding R: " + linkedList);
		System.out
				.println("Retrieves, but does not remove, the head (first element) of this list. " + linkedList.peek());
		System.out.println(linkedList);
		System.out.println("Retrieves and removes the head (first element) of this list.: " + linkedList.poll());
		System.out.println(linkedList);
		System.out.println("Adding New Element.");
		linkedList.push("New Element");
		System.out.println("After Adding New Element.");
		System.out.println(linkedList);
		System.out.println();
	}

}
