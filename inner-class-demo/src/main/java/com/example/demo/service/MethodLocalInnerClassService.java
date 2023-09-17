package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MethodLocalInnerClassService {

	int x = 1;
	static int y = 1;
	int j = 1;
	
	interface Cricket { 
		public void fiveDayMatch();		
		public void oneDayMatch();		
		public void shortDayMatch();
	
	}

	class BhartiyaCricket implements Cricket {
		
		public void fiveDayMatch() {
			System.out.println("We play Test.");
		}
		
		public void oneDayMatch() {
			System.out.println("We play ODI.");
		}
		
		public void shortDayMatch() {
			System.out.println("We play T20.");
		}
	}
	
	public void methodLocalInnerClassDemo() {
		int x = 2;
		//static int y = 343; //Illegal modifier for parameter y; only final is permitted
		int j = 2;
		
		int methodLocalVariable = 2;
		methodLocalVariable = 5;
		
		int methodLocalVariable2 = 2;
		
		class MethodClass {
			int x = 3;
			static int y = 3;
			int j = 3;
			
			public void display() {
				int x = 4;
				//static int y = 4; //Illegal modifier for parameter y; only final is permitted
				int j = 4;				
				System.out.println("x : "+x);
				System.out.println("y : "+y);
				System.out.println("j : "+j);
				//System.out.println("methodLocalVariable : "+methodLocalVariable);
				//Local variable methodLocalVariable defined in an enclosing scope must be final or effectively final
				
				System.out.println("methodLocalVariable : "+methodLocalVariable2);

				
				System.out.println("this => "+this.getClass().getName());
				System.out.println("this.x : "+this.x);
				System.out.println("this.y : "+MethodClass.y);
				System.out.println("this.j : "+this.j);

				System.out.println("MethodLocalInnerClassService.this => "+MethodLocalInnerClassService.this.getClass().getName());
				System.out.println("MethodLocalInnerClassService.this.x : "+MethodLocalInnerClassService.this.x);
				System.out.println("MethodLocalInnerClassService.this.y : "+MethodLocalInnerClassService.this.y);
				System.out.println("MethodLocalInnerClassService.this.j : "+MethodLocalInnerClassService.this.j);

			}
		}
		MethodClass methodClass = new MethodClass();
		methodClass.display();
		System.out.println("=================================================================================");
		staticMethodLocalInnerClassDemo();
	}
	
	public static void staticMethodLocalInnerClassDemo() {
		int x = 2;
		//static int y = 343; //Illegal modifier for parameter y; only final is permitted
		int j = 2;
		
		int methodLocalVariable = 2;
		methodLocalVariable = 5;
		
		int methodLocalVariable2 = 2;
		
		class MethodClass {
			int x = 3;
			static int y = 3;
			int j = 3;
			
			public void display() {
				int x = 4;
				//static int y = 4; //Illegal modifier for parameter y; only final is permitted
				int j = 4;				
				System.out.println("x : "+x);
				System.out.println("y : "+y);
				System.out.println("j : "+j);
				//System.out.println("methodLocalVariable : "+methodLocalVariable);
				//Local variable methodLocalVariable defined in an enclosing scope must be final or effectively final
				
				System.out.println("methodLocalVariable : "+methodLocalVariable2);

				
				System.out.println("this => "+this.getClass().getName());
				System.out.println("this.x : "+this.x);
				System.out.println("this.y : "+MethodClass.y);
				System.out.println("this.j : "+this.j);

				//System.out.println("MethodLocalInnerClassService.this => "+MethodLocalInnerClassService.this.getClass().getName());
				//System.out.println("MethodLocalInnerClassService.this.x : "+MethodLocalInnerClassService.this.x);
				//System.out.println("MethodLocalInnerClassService.this.y : "+MethodLocalInnerClassService.this.y);
				//System.out.println("MethodLocalInnerClassService.this.j : "+MethodLocalInnerClassService.this.j);

			}
		}
		MethodClass methodClass = new MethodClass();
		methodClass.display();
	}

	public void anonymousInnerClassDemo() {
		
		//Anonymous Class Extends Class
		BhartiyaCricket bhartiyaCricket = new BhartiyaCricket() {
			public void shortDayMatch() {
				System.out.println("We play T20.");
			}
		};
		
		bhartiyaCricket.fiveDayMatch();
		bhartiyaCricket.oneDayMatch();
		bhartiyaCricket.shortDayMatch();
		
		//Anonymous Class Implements Interface
		Cricket cricket = new Cricket() {
			public void fiveDayMatch() {
				System.out.println("We play day-night Test.");
			}
			
			public void oneDayMatch() {
				System.out.println("We play day-night ODI.");
			}

			public void shortDayMatch() {
				System.out.println("We play T10.");
			}
		};
		cricket.fiveDayMatch();
		cricket.oneDayMatch();
		cricket.shortDayMatch();

		class DisplayCricketFormat{
			public void displayAllFormat(Cricket cricket) {
				cricket.fiveDayMatch();
				cricket.oneDayMatch();
				cricket.shortDayMatch();
	
			}
		}
		
		//Anonymous Class As A Argument
		DisplayCricketFormat displayCricketFormat = new DisplayCricketFormat();
		displayCricketFormat.displayAllFormat(new Cricket() {
			public void fiveDayMatch() {
				System.out.println("We play day-night Test.");
			}
			
			public void oneDayMatch() {
				System.out.println("We play day-night ODI.");
			}

			public void shortDayMatch() {
				System.out.println("We play T10.");
			}
		});
	}
	
	
}
