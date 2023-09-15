package com.learn.java.collection.service;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

import org.springframework.stereotype.Service;

import com.learn.java.collection.model.Student;

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

	/*
	 * 0.) Underlying Data Structure: Hash Table (Internally its buckets usages linked list or tree in collision)
	 * 
	 * 1.) Insertion Order Not Preserved (as per hashing logic) 
	 * 2.) Duplicate Keys Not Allowed, Values can be duplicate 
	 * 3.) NULL insertion is possible 
	 * 4.) No AutoSorting
	 * 
	 * Always check / compare reference not content. Due to this, IdentityHashMap can have duplicate keys
	 */
	public void identityHashMapDemo() {
		IdentityHashMap<String, String> identityHashMapDemo = new IdentityHashMap<>();
		String student = new String("sv");
		System.out.println(student);
		identityHashMapDemo.put(student, "A");
		identityHashMapDemo.put(new String("1"), "An");
		identityHashMapDemo.put(new String("1"), "BE");
		identityHashMapDemo.put(new String("3"), "Z");
		identityHashMapDemo.put(new String("4"), "Z");
		identityHashMapDemo.put(student, "K");
		System.out.println(identityHashMapDemo.toString());
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
			e.printStackTrace();
		}
		System.out.println(identityHashMapDemo);

		WeakHashMap<String, String> weakHashMapDemo = new WeakHashMap<>();
		String student1 = new String("sv");
		System.out.println(student1);
		weakHashMapDemo.put(student1, "A");
		weakHashMapDemo.put(new String("1"), "An");
		weakHashMapDemo.put(new String("1"), "BE");
		weakHashMapDemo.put(new String("3"), "Z");
		weakHashMapDemo.put(new String("4"), "Z");
		weakHashMapDemo.put(student1, "K");
		System.out.println(weakHashMapDemo.toString());
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
			e.printStackTrace();
		}
		System.out.println(weakHashMapDemo);
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
		Student student = new Student(1, "1");
		System.out.println(student);
		weakHashMap.put(student, "A1");
		weakHashMap.put(new Student(), "BE");
		weakHashMap.put(new Student(), "Z");
		weakHashMap.put(new Student(1,"1"), "K1");
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

	/*
	 * 0.) Underlying Data Structure: RED-BLACK TREE
	 * 
	 * 1.) Insertion Order Preserved (according to sorting order) 
	 * 2.) Duplicates Not Allowed 
	 * 3.) NULL insertion is NOT possible //NPE 
	 * 4.) AutoSorting (Default:DNSO) 
	 * 5.)
	 * 
	 */
	public void treeMapDemo() {
		TreeMap<String, String> treeMap = new TreeMap<>();
		treeMap.put("A", "A");
		treeMap.put("B", "B");
		treeMap.put("D", "D");
		treeMap.put("C", "C");
		treeMap.put("F", "F");
		treeMap.put("W", "W");
		treeMap.put("Z", "Z");
		treeMap.put("S", "S");
		treeMap.put("R", "R");
		treeMap.put("A", "A"); //if same key and same value...no changes
//		System.out.println("puted Hash Map: " + treeMap);
//		treeMap.put(null, null);
//		System.out.println("Hash Map after puting null: " + treeMap);
//		treeMap.put(null, null);
		System.out.println("Hash Map after puting null: " + treeMap);
		treeMap.put("K", null);
		System.out.println("Hash Map again puting null: " + treeMap);
		treeMap.put("A", "R");
		System.out.println("Hash Map again puting R: " + treeMap);
		System.out.println("Hash Map Contains R? => " + treeMap.containsKey("R"));
//		System.out.println("Hash Map Contains null? => " + treeMap.containsKey(null));
//		System.out.println("Hash Map removing R by index: " + treeMap.remove(treeMap.size() - 1));
		System.out.println(treeMap);
		System.out.println("Hash Map removing R by Object: " + treeMap.remove("R"));
		System.out.println(treeMap);
		System.out.println(treeMap.entrySet().toString());
		System.out.println(treeMap.entrySet().getClass());

		
		// Navigation Methods.
		System.out.println(
				"Returns the least element in this map greater than or equal to the given element, or null if there is no such element. ceiling: "
						+ treeMap.ceilingKey("D"));
		System.out.println(
				"Returns the least element in this map strictly greater than the given element, or null if there is no such element.\n"
						+ "Specified by: higher(...) in NavigableSet higher: " + treeMap.higherKey("D"));

		System.out.println(
				"Returns the greatest element in this map less than or equal to the given element, or null if there is no such element. floor: "
						+ treeMap.floorKey("D"));
		System.out.println(
				"Returns the greatest element in this map strictly less than the given element, or null if there is no such element. lower: "
						+ treeMap.lowerKey("D"));

		/*
		 * Returns a view of the portion of this map whose elements are strictly less
		 * than toElement. The returned map is backed by this map, so changes in the
		 * returned map are reflected in this map, and vice-versa. The returned map
		 * supports all optional map operations that this map supports. The returned map
		 * will throw an IllegalArgumentException on an attempt to insert an element
		 * outside its range.
		 */
		System.out.println("Head map: " + treeMap.headMap("D"));

		/*
		 * Returns a view of the portion of this map whose elements are less than (or
		 * equal to, if inclusive is true) toElement. The returned map is backed by this
		 * map, so changes in the returned map are reflected in this map, and
		 * vice-versa. The returned map supports all optional map operations that this
		 * map supports. The returned map will throw an IllegalArgumentException on an
		 * attempt to insert an element outside its range.
		 */
		System.out.println("Head map: " + treeMap.headMap("D", true));

		System.out.println();
		System.out.println();
		System.out.println(
				"Returns the least element in this map greater than or equal to the given element, or null if there is no such element. ceiling: "
						+ treeMap.ceilingKey("E"));
		System.out.println(
				"Returns the least element in this map strictly greater than the given element, or null if there is no such element.\n"
						+ "Specified by: higher(...) in NavigableSet higher: " + treeMap.higherKey("E"));

		System.out.println(
				"Returns the greatest element in this map less than or equal to the given element, or null if there is no such element. floor: "
						+ treeMap.floorKey("E"));
		System.out.println(
				"Returns the greatest element in this map strictly less than the given element, or null if there is no such element. lower: "
						+ treeMap.lowerKey("E"));

		/*
		 * Returns a view of the portion of this map whose elements are strictly less
		 * than toElement. The returned map is backed by this map, so changes in the
		 * returned map are reflected in this map, and vice-versa. The returned map
		 * supports all optional map operations that this map supports. The returned map
		 * will throw an IllegalArgumentException on an attempt to insert an element
		 * outside its range.
		 */
		System.out.println("Head Map: " + treeMap.headMap("E"));

		/*
		 * Returns a view of the portion of this map whose elements are less than (or
		 * equal to, if inclusive is true) toElement. The returned map is backed by this
		 * map, so changes in the returned map are reflected in this map, and
		 * vice-versa. The returned map supports all optional map operations that this
		 * map supports. The returned map will throw an IllegalArgumentException on an
		 * attempt to insert an element outside its range.
		 */
		System.out.println("Head Map: " + treeMap.headMap("E", true));

		System.out.println("descending Map: " + treeMap.descendingMap());
	}

}
