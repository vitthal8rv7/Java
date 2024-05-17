package com.learn.java.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class JavaInterviewApplicationTests {

	@Test
	void contextLoads() {
		
		String str1 = "Hello"; 
		String str11 = "Hello";
		System.out.println("str1 is literal?: "+(str1==str11));
		
		String str2 = " World"; 
		String str33 = " World";
		System.out.println("str2 is literal?: "+(str2==str33));
		
		String str3 = str2; 
		System.out.println("str3 is literal?: "+(str3==str33));
//		System.out.println("str3 is literal?: "+(str3==str3.intern()));
		
		String result1 = "Hello" + " World";
//		System.out.println("result1 is literal?: "+(result1==result1.intern()));
		System.out.println("result1 is literal?: "+(result1=="Hello World"));
		String result11 = "Hello World";
		System.out.println("result1 is literal?: "+(result1==result11));
//		System.out.println("result1 is literal?: "+(result1==result1.intern()));
		
		System.out.println("");
		System.out.println("");
		String result2 = str1 + str2;
//		System.out.println("result2 is literal?: "+(result2==result2.intern()));
		System.out.println("result2 is literal?: "+(result2=="Hello World"));
		System.out.println("result2 is literal?: "+(result2==result11));
		
		String result3 = "Hello" + str2;
//		System.out.println("result3 is literal?: "+(result3==result3.intern()));
		System.out.println("result3 is literal?: "+(result3=="Hello World"));
		System.out.println("result3 is literal?: "+(result3==result11));
		
		String result4 = str1 + " World"; 
//		System.out.println("result4 is literal?: "+(result4==result4.intern()));
		System.out.println("result4 is literal?: "+(result4=="Hello World"));
		System.out.println("result4 is literal?: "+(result4==result11));
		
		String result5 = str1.concat(str2);
//		System.out.println("result5 is literal?: "+(result5==result5.intern()));
		System.out.println("result5 is literal?: "+(result5=="Hello World"));
		System.out.println("result5 is literal?: "+(result5==result11));
		
		String str4 = new String(" World");
//		System.out.println("str4 is literal?: "+(str4==str4.intern()));
		System.out.println("str4 is literal?: "+(str4==" World"));
		System.out.println("result3 is literal?: "+(str4==str2));

		String result6 = "Hello" + str4;  
//		System.out.println("result6 is literal?: "+result6+" "+(result6==result6.intern()));
		System.out.println("result6 is literal?: "+(result6=="Hello World"));
		System.out.println("result6 is literal?: "+(result6==result11));

		str4 = new String("Hello");
		String result7 = str4 + " World"; 
//		System.out.println("result7 is literal?: "+(result7==result7.intern()));
		System.out.println("result7 is literal?: "+(result7=="Hello World"));
		System.out.println("result7 is literal?: "+(result7==result11));

	}

}
