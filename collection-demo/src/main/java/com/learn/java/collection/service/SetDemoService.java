package com.learn.java.collection.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

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
	 */
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
		System.out.println("Added Hash Set: " + hashSet);
		hashSet.add(null);
		System.out.println("Hash Set after adding null: " + hashSet);
		hashSet.add(null);
		System.out.println("Hash Set again adding null: " + hashSet);
		hashSet.add("R");
		System.out.println("Hash Set again adding R: " + hashSet);
		System.out.println("Hash Set Contains R? => " + hashSet.contains("R"));
		System.out.println("Hash Set Contains null? => " + hashSet.contains(null));
		System.out.println("Hash Set removing R by index: " + hashSet.remove(hashSet.size() - 1));
		System.out.println(hashSet);
		System.out.println("Hash Set removing R by Object: " + hashSet.remove("R"));
		System.out.println(hashSet);

	}

	/*
	 * 0.) Underlying Data Structure: Linked List + Hash Table
	 * 
	 * 1.) Insertion Order Preserved (due to linked list) 
	 * 2.) Duplicates Not Allowed
	 * 3.) NULL insertion is possible 
	 * 4.) No AutoSorting 5.) LinkedList class also implement Queue Interface (follows FIFO)
	 * 
	 */
	public void linkedHashSetDemo() {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("A");
		linkedHashSet.add("B");
		linkedHashSet.add("D");
		linkedHashSet.add("C");
		linkedHashSet.add("F");
		linkedHashSet.add("W");
		linkedHashSet.add("Z");
		linkedHashSet.add("S");
		linkedHashSet.add("R");
		linkedHashSet.add("A");
		System.out.println("Added Linked Hash Set: " + linkedHashSet);
		linkedHashSet.add(null);
		System.out.println("Linked Hash Set after adding null: " + linkedHashSet);
		linkedHashSet.add(null);
		System.out.println("Linked Hash Set again adding null: " + linkedHashSet);
		linkedHashSet.add("R");
		System.out.println("Linked Hash Set again adding R: " + linkedHashSet);
		System.out.println("Linked Hash Set Contains R? => " + linkedHashSet.contains("R"));
		System.out.println("Linked Hash Set Contains null? => " + linkedHashSet.contains(null));
		System.out.println("Linked Hash Set removing R by index: " + linkedHashSet.remove(linkedHashSet.size() - 1));
		System.out.println(linkedHashSet);
		System.out.println("Linked Hash Set removing R by Object: " + linkedHashSet.remove("R"));
		System.out.println(linkedHashSet);

	}

	/*
	 * 0.) Underlying Data Structure: BalanceTree
	 * 
	 * 1.) Insertion Order Preserved (according to sorting order) 
	 * 2.) Duplicates Not Allowed 
	 * 3.) NULL insertion is NOT possible //NPE 
	 * 4.) AutoSorting (Default:DNSO) 
	 * 5.)
	 * 
	 */
	public void treeSetDemo() {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("D");
		treeSet.add("C");
		treeSet.add("F");
		treeSet.add("W");
		treeSet.add("Z");
		treeSet.add("S");
		treeSet.add("R");
		treeSet.add("A");
		System.out.println("Added Tree Set: " + treeSet);
		// treeSet.add(null); //NPE
		// System.out.println("Tree Set after adding null: "+treeSet);
		// treeSet.add(null); //NPE
		// System.out.println("Tree Set again adding null: "+treeSet);
		treeSet.add("R");
		System.out.println("Tree Set again adding R: " + treeSet);
		System.out.println("Tree Set Contains R? => " + treeSet.contains("R"));
		// System.out.println("Tree Set Contains null? => "+treeSet.contains(null));
		// //can`t check null value::NPE
		// System.out.println("Tree Set removing R by index:
		// "+treeSet.remove(treeSet.size()-1));
		// while removing TreeSet Object, Given Object should be of same type, else
		// ::ClassCastException
		System.out.println(treeSet);
		System.out.println("Tree Set removing R by Object: " + treeSet.remove("R"));
		System.out.println(treeSet);

		// Navigation Methods.
		System.out.println(
				"Returns the least element in this set greater than or equal to the given element, or null if there is no such element. ceiling: "
						+ treeSet.ceiling("D"));
		System.out.println(
				"Returns the least element in this set strictly greater than the given element, or null if there is no such element.\n"
						+ "Specified by: higher(...) in NavigableSet higher: " + treeSet.higher("D"));

		System.out.println(
				"Returns the greatest element in this set less than or equal to the given element, or null if there is no such element. floor: "
						+ treeSet.floor("D"));
		System.out.println(
				"Returns the greatest element in this set strictly less than the given element, or null if there is no such element. lower: "
						+ treeSet.lower("D"));

		/*
		 * Returns a view of the portion of this set whose elements are strictly less
		 * than toElement. The returned set is backed by this set, so changes in the
		 * returned set are reflected in this set, and vice-versa. The returned set
		 * supports all optional set operations that this set supports. The returned set
		 * will throw an IllegalArgumentException on an attempt to insert an element
		 * outside its range.
		 */
		System.out.println("Head Set: " + treeSet.headSet("D"));

		/*
		 * Returns a view of the portion of this set whose elements are less than (or
		 * equal to, if inclusive is true) toElement. The returned set is backed by this
		 * set, so changes in the returned set are reflected in this set, and
		 * vice-versa. The returned set supports all optional set operations that this
		 * set supports. The returned set will throw an IllegalArgumentException on an
		 * attempt to insert an element outside its range.
		 */
		System.out.println("Head Set: " + treeSet.headSet("D", true));

		System.out.println();
		System.out.println();
		System.out.println(
				"Returns the least element in this set greater than or equal to the given element, or null if there is no such element. ceiling: "
						+ treeSet.ceiling("E"));
		System.out.println(
				"Returns the least element in this set strictly greater than the given element, or null if there is no such element.\n"
						+ "Specified by: higher(...) in NavigableSet higher: " + treeSet.higher("E"));

		System.out.println(
				"Returns the greatest element in this set less than or equal to the given element, or null if there is no such element. floor: "
						+ treeSet.floor("E"));
		System.out.println(
				"Returns the greatest element in this set strictly less than the given element, or null if there is no such element. lower: "
						+ treeSet.lower("E"));

		/*
		 * Returns a view of the portion of this set whose elements are strictly less
		 * than toElement. The returned set is backed by this set, so changes in the
		 * returned set are reflected in this set, and vice-versa. The returned set
		 * supports all optional set operations that this set supports. The returned set
		 * will throw an IllegalArgumentException on an attempt to insert an element
		 * outside its range.
		 */
		System.out.println("Head Set: " + treeSet.headSet("E"));

		/*
		 * Returns a view of the portion of this set whose elements are less than (or
		 * equal to, if inclusive is true) toElement. The returned set is backed by this
		 * set, so changes in the returned set are reflected in this set, and
		 * vice-versa. The returned set supports all optional set operations that this
		 * set supports. The returned set will throw an IllegalArgumentException on an
		 * attempt to insert an element outside its range.
		 */
		System.out.println("Head Set: " + treeSet.headSet("E", true));

		System.out.println("descendingSet: " + treeSet.descendingSet());

	}

}
