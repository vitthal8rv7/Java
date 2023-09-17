package com.example.demo.service;

import com.example.demo.service.MethodLocalInnerClassService.Cricket;

public class AnonymousInnerClassService {

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
