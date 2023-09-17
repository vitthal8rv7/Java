package com.learn.java.generics.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class GenericService {

	public void testBasicRules() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("ONE");
		arrayList.add(null);
		arrayList.add("TWO");
		System.out.println("You Can Add Only String Type Of Values Or null.");
		System.out.println("Generic ArrayList With String Parameter Type Tested." + arrayList);

		// ArrayList<Object> arrayList = new ArrayList<String>(); //InValid
		// Type mismatch: cannot convert from ArrayList<String> to ArrayList<Object>
		// Polymorphism concept is not application for generics parameter type.

		// Parameter Type can be any class or interface but parameter type should not be
		// primitive.
		// ArrayList<int> arrayList = new ArrayList<int>(); //InValid
		// Syntax error, insert "Dimensions" to complete ReferenceType

		class GenericClassDemo<T> {
			private T genericObject;

			GenericClassDemo() {

			}

			GenericClassDemo(T ob) { // parameterised constructor
				genericObject = ob;
			}

			public T getGenericObject() {
				return genericObject;
			}

			public void setGenericObject(T ob) {
				genericObject = ob;
			}
		}

		GenericClassDemo<String> gen = new GenericClassDemo<>();
		GenericClassDemo<String> gen2 = new GenericClassDemo<>("Vitthal 2");
		gen.setGenericObject("Vitthal");
		System.out.println("setGenericObject: " + gen.getGenericObject());
		System.out.println("setGenericObject2: " + gen2.getGenericObject());

		GenericClassDemo<Integer> gen3 = new GenericClassDemo<>();
		GenericClassDemo<Integer> gen4 = new GenericClassDemo<>(4);
		gen3.setGenericObject(3);
		System.out.println("setGenericObject3: " + gen3.getGenericObject());
		System.out.println("setGenericObject4: " + gen4.getGenericObject());

	}

	public void boundParameterTypeDemo() {
		class GenericClassDemo<T extends Number & Comparable> { // & Runnable> {
			// Bound mismatch: The type Integer is not a valid substitute for the bounded
			// parameter <T extends Number & Comparable & Runnable> of the type
			// GenericClassDemo<T>
			private T genericObject;

			GenericClassDemo() {

			}

			GenericClassDemo(T ob) { // parameterised constructor
				genericObject = ob;
			}

			public T getGenericObject() {
				return genericObject;
			}

			public void setGenericObject(T ob) {
				genericObject = ob;
			}

		}
		// Incorrect number of arguments for type
		// GenericClassDemo<T,Runnable,Comparator>; it cannot be parameterized with
		// arguments <String>
//		GenericClassDemo <String> gen = new GenericClassDemo<>();
//		GenericClassDemo <String> gen2 = new GenericClassDemo<>("Vitthal 2");
//		gen.setGenericObject("Vitthal");
//		System.out.println("setGenericObject: "+ gen.getGenericObject());
//		System.out.println("setGenericObject2: "+ gen2.getGenericObject());

		GenericClassDemo<Integer> gen3 = new GenericClassDemo<>();
		GenericClassDemo<Double> gen4 = new GenericClassDemo<Double>(4d);
		gen3.setGenericObject(3);
		System.out.println("setGenericObject3: " + gen3.getGenericObject());
		System.out.println("setGenericObject4: " + gen4.getGenericObject());

		class GenericClassDemo2<T extends Number & Comparable, K extends Runnable> { // & Runnable> {
			// Bound mismatch: The type Integer is not a valid substitute for the bounded
			// parameter <T extends Number & Comparable & Runnable> of the type
			// GenericClassDemo<T>
			private T genericObject;
			private K genericObject2;

			GenericClassDemo2(T ob) { // parameterised constructor
				genericObject = ob;
			}

			GenericClassDemo2(T ob, K ob2) { // parameterised constructor
				genericObject = ob;
				genericObject2 = ob2;
			}

			public T getGenericObjectT() {
				return genericObject;
			}

			public void setGenericObjectT(T ob) {
				genericObject = ob;
			}

			public K getGenericObjectK() {
				return genericObject2;
			}

			public void setGenericObjectK(K ob2) {
				genericObject2 = ob2;
			}

		}
		// Incorrect number of arguments for type
		// GenericClassDemo<T,Runnable,Comparator>; it cannot be parameterized with
		// arguments <String>
//			GenericClassDemo <String> gen = new GenericClassDemo<>();
//			GenericClassDemo <String> gen2 = new GenericClassDemo<>("Vitthal 2");
//			gen.setGenericObject("Vitthal");
//			System.out.println("setGenericObject: "+ gen.getGenericObject());
//			System.out.println("setGenericObject2: "+ gen2.getGenericObject());
		Thread t = new Thread();
		GenericClassDemo2<Integer, Thread> gen5 = new GenericClassDemo2<Integer, Thread>(4, t);
		GenericClassDemo2<Double, Thread> gen6 = new GenericClassDemo2<Double, Thread>(4d);
		gen5.setGenericObjectT(3);
		gen6.setGenericObjectK(t);
		System.out.println("setGenericObject5: " + gen5.getGenericObjectT());
		System.out.println("setGenericObject6: " + gen6.getGenericObjectK());

	}

	public void wildCartCharacterDemo(ArrayList<?> arrayList) {
		// ArrayList<?> arrayList
		// We can to addition operation with wild card character.
		System.out.println("arrayList values: " + arrayList);
		System.out.println("arrayList type: " + arrayList.getClass().getName());
		System.out.println("arrayList value type: " + arrayList.get(0).getClass().getName());

	}

	public void wildCartCharacterDemo2(ArrayList<? extends Number> arrayList) {
		// ArrayList<?> arrayList
		// We can to addition operation with wild card character.
		System.out.println("arrayList values: " + arrayList);
		System.out.println("arrayList type: " + arrayList.getClass().getName());
		System.out.println("arrayList value type: " + arrayList.get(0).getClass().getName());

	}

	public void parameterTypeScopeDemo(ArrayList<String> arrayList) { // only string parameter type allowed here, caller
																		// type doesn`t matter
		arrayList.add("Value2");
		// arrayList.add(1d);
		// The method add(String) in the type ArrayList<String> is not applicable for
		// the arguments (double)
		System.out.println("arrayList values: " + arrayList);

	}

	// Generic concept is compile time only so, run time above method and this
	// method signature will become same
	// So, JVM face conflict, JVM can not resolve for calling which one of them
	// That why, we have to use diff method name here.
	public void parameterTypeScopeDemo2(ArrayList arrayList) { // all type allowed here, caller parameter type doesn`t
																// matter
		arrayList.add("Value2");
		arrayList.add(1d);
		arrayList.add(1);
		arrayList.add(true);
		System.out.println("arrayList values: " + arrayList);

	}

}
