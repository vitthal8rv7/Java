package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RegularInnerClassService {

	int x = 234;
	static int y = 343;
	int j = 123456;

	class RegularInnerClass {
		static int i = 10; //
		int j = 20;

		public static void display2() {
			System.out.println("static display method");
			System.out.println("i = " + i);
			// System.out.println("j = " + j); //non-static variable not allowed
			// System.out.println("x = " + x); //non-static variable not allowed
			System.out.println("y = " + y);
		}

		public void display() {
			int j = 100000;
			System.out.println("display method");
			System.out.println("i = " + i);
			System.out.println("j = " + j);
			System.out.println("this.j = " + this.j);
			System.out.println("RegularInnerClassService.this.j = " + RegularInnerClassService.this.j);
			System.out.println("x = " + x);
			System.out.println("y = " + y);
			System.out.println("this => inside inner clas = " + this.getClass().getName());
			System.out.println(
					"RegularInnerClass.this => inside inner clas = " + RegularInnerClass.this.getClass().getName());
			System.out.println("RegularInnerClassService.this => inside inner clas = "
					+ RegularInnerClassService.this.getClass().getName());
			System.out.println("=======================================================================");
		}

	}

	public void regularInnerClassDemo() {
		System.out.println("inside outer class instace method");
//		i = 10; Inner class fields not directly accessible from outer class. [use inner class object to access them]
//		j = 20;
		System.out.println("this => inside inner clas = " + this.getClass().getName());
		// System.out.println("RegularInnerClass.this => inside inner clas = " +
		// RegularInnerClass.this.getClass().getName());
		// No enclosing instance of the type RegularInnerClassService.RegularInnerClass
		// is accessible in scope
		System.out.println("RegularInnerClassService.this => inside inner clas = "
				+ RegularInnerClassService.this.getClass().getName());

		RegularInnerClass.display2();
		RegularInnerClass regularInnerClass = new RegularInnerClass();
		regularInnerClass.display();
		staticRegularInnerClassDemo();
		TestRegularInnerClassService.staticRegularInnerClassDemo();
		new TestRegularInnerClassService().regularInnerClassDemo();

	}

	public static void staticRegularInnerClassDemo() {
		System.out.println("inside outer class static method");
		RegularInnerClassService regularInnerClassService = new RegularInnerClassService();
		RegularInnerClassService.RegularInnerClass regularInnerClass = regularInnerClassService.new RegularInnerClass();
		regularInnerClass.display();

	}

}

class TestRegularInnerClassService {
	public void regularInnerClassDemo() {
		System.out.println("inside class outside outer class instace method");
		RegularInnerClassService regularInnerClassService = new RegularInnerClassService();
		RegularInnerClassService.RegularInnerClass regularInnerClass = regularInnerClassService.new RegularInnerClass();
		regularInnerClass.display();

	}

	public static void staticRegularInnerClassDemo() {
		System.out.println("inside class outside outer class static method");
		RegularInnerClassService regularInnerClassService = new RegularInnerClassService();
		RegularInnerClassService.RegularInnerClass regularInnerClass = regularInnerClassService.new RegularInnerClass();
		regularInnerClass.display();

	}

}
