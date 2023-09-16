package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnumDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnumDemoApplication.class, args);
		
		
		enum Week {
			SUN("Sunday"),
			MON("Monday"),
			SUN2("Sunday");
			
			
			public String day;
			Week(String day) {
				this.day = day;
			}	
		}

		System.out.println(Week.SUN);
		System.out.println(Week.MON.day);
		System.out.println(Week.SUN.describeConstable());
		System.out.println(Week.SUN.equals(Week.SUN2));
		System.out.println(Week.SUN.day.equals(Week.SUN2.day));
		System.out.println(Week.SUN.name());
		System.out.println(Week.valueOf("MON"));
		System.out.println(Week.valueOf("SUN"));
		
		System.out.println(Week.MON.values().length); // its array
		System.out.println(Week.SUN.values()[0]); // its array
		System.out.println(Week.values()); // its array reference
		
	}

}

/*
 * OUTPUT
SUN
Monday
Optional[EnumDesc[EnumDemoApplication$1Week.SUN]]
false
true
SUN
MON
SUN
3
SUN
[Lcom.example.demo.EnumDemoApplication$1Week;@7f4d9395

*/
