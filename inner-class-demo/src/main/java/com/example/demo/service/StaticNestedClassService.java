package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class StaticNestedClassService {

	static class StaticClass {
		static int score = 0;

		public void displayAllFormat() {
			System.out.println("We play Test.");
			System.out.println("We play ODI.");
			System.out.println("We play T20.");
			System.out.println("Default Score: " + score);
		}
	}

	public void staticNestedClassDemo() {
		StaticClass staticClass = new StaticClass();
		staticClass.displayAllFormat();
		staticNestedClassDemo2();
		OtherClass.staticNestedClassDemo2();
		new OtherClass().staticNestedClassDemo();
	}

	public static void staticNestedClassDemo2() {
		StaticClass staticClass = new StaticClass();
		staticClass.displayAllFormat();
	}

}

class OtherClass {
	public void staticNestedClassDemo() {
		StaticNestedClassService.StaticClass staticClass = new StaticNestedClassService.StaticClass();
		staticClass.displayAllFormat();
		staticNestedClassDemo2();
	}

	public static void staticNestedClassDemo2() {
		StaticNestedClassService.StaticClass staticClass = new StaticNestedClassService.StaticClass();
		staticClass.displayAllFormat();
	}
}
