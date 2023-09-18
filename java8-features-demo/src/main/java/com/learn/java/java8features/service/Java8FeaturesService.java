package com.learn.java.java8features.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

@Service
public class Java8FeaturesService {

	public void lambdaExpressionMultithreadingDemo1() {
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public void lambdaExpressionCollectionDemo1() {
		ArrayList<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(22);
		integerList.add(21);
		integerList.add(4);
		integerList.add(6);
		integerList.add(100);
		System.out.println("Insertion Order: " + integerList);
		Collections.sort(integerList, (a, b) -> a - b); // ascending a-b
		System.out.println("Ascending  Order : " + integerList);
		Collections.sort(integerList, (a, b) -> b - a); // descending b-a
		System.out.println("Descending Order : " + integerList);

		class Employee {
			Integer eno;
			String name;

			Employee(Integer eno, String name) {
				this.eno = eno;
				this.name = name;
			}

			public String toString() {
				return "eno:" + eno + " name:" + name;
			}
		}

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "name1"));
		employeeList.add(new Employee(22, "name22"));
		employeeList.add(new Employee(4, "name4"));
		employeeList.add(new Employee(99, "name99"));
		employeeList.add(new Employee(101, "name101"));
		System.out.println("Insertion Order: " + employeeList);
		Collections.sort(employeeList, (a, b) -> a.eno - b.eno); // ascending a-b
		System.out.println("Ascending  Order By Eno : " + employeeList);
		Collections.sort(employeeList, (a, b) -> -(a.eno - b.eno)); // descending b-a
		System.out.println("Descending Order By Eno" + employeeList);

		Collections.sort(employeeList, (a, b) -> a.name.compareTo(b.name)); // ascending a-b
		System.out.println("Ascending  Order By Eno : " + employeeList);
		Collections.sort(employeeList, (a, b) -> -(a.name.compareTo(b.name))); // descending b-a
		System.out.println("Descending Order By Eno" + employeeList);

	}

	public void defaultMethodDemo1() {
		interface TestInterface {
			default void testMethod() {
				System.out.println("This is test default method of TestInterface");
			}
		}

		interface TestInterface2 {
			default void testMethod() {
				System.out.println("This is test default method of TestInterface2");
			}
		}

//		Duplicate default methods named testMethod with the parameters () and () are inherited from the types TestInterface2 and TestInterface
//		class TestClass implements TestInterface, TestInterface2 {
		class TestClass implements TestInterface {
			public void defaultMethodCaller() {
				testMethod(); // HAS-A Relationship with TestInterface [ Inheritance ]

			}

//			Default methods are allowed only in interfaces.
//			default void testMethod2() { 
//				System.out.println("This is test default method.");
//			}

		}

//		Java allowed multiple inheritance for interfaces if and only if implementing class should override default methods(if found).
		class TestClass2 implements TestInterface, TestInterface2 {
			public void defaultMethodCaller() {
				testMethod(); // HAS-A Relationship with TestInterface [ Inheritance ]

			}
			public void testMethod() {
				System.out.println("This is test default method of TestClass2");
				TestInterface2.super.testMethod();
			}
		}
		
		TestClass testClass = new TestClass();
		testClass.defaultMethodCaller();
		TestClass2 testClass2 = new TestClass2();
		testClass2.defaultMethodCaller();
		
	}
}
