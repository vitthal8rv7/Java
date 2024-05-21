package com.learn.java.interview;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

//@SpringBootTest
class JavaInterviewApplicationTests {

	@Test 
	void test2() {
		
		String str = "Java Concept Of The Day";
		
		// Convert the string to lower case and filter out spaces
        str = str.toLowerCase().replaceAll("\\s", "");

        // Use streams to create a frequency map
        Map<Character, Long> frequencyMap = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Find the character with the maximum frequency
        Map.Entry<Character, Long> entry = frequencyMap.entrySet().stream()
            .max(Map.Entry.comparingByValue())
//            .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//            .map(Map.Entry::getValue)
            .orElseThrow(() -> new IllegalArgumentException("String is empty or only contains whitespace")); 
        System.out.println("m.getKey(): "+ entry.getKey());
        System.out.println("m.getValue(): "+ entry.getValue());

//entrym.getKey();
//entry.getValue();
  
	}
	
//	@Test 
//	void test1() {
//		final String space = " ";
//		final String blank = "";
//		String firstString = "thin sticks";
//		String secondString = "thick bricks";
//		Set<Character> firstStringSet = new TreeSet<>(firstString.replace(space, blank).chars().mapToObj(c -> (char) c)
//				.collect(Collectors.toSet()));
//		Set<Character> secondStringSet = new TreeSet<>(secondString.replace(space, blank).chars().mapToObj(c -> (char) c)
//				.collect(Collectors.toSet()));
//		firstStringSet.retainAll(secondStringSet); 
//		System.out.println("Common characters in alphabetical order : " + firstStringSet);
//		System.out.println("Count : " + firstStringSet.size());	
//		
////		Set<Character> hashSet1 = firstString.replace(space, blank).chars().mapToObj(c -> (char) c)
////				.collect(Collectors.toSet());
////		Set<Character> hashSet2 = secondString.replace(space, blank).chars().mapToObj(c -> (char) c)
////				.collect(Collectors.toSet());
//		// (TreeSet<Character>)
////				(TreeSet<Character>) firstString.replace(" ", "").chars()
////					.mapToObj(c -> (char) c)
////					.collect(Collectors.toSet());
//
//
//	}

	
	//	@Test
//	void contextLoads() {
//		List<String> allSubStrings0 = new ArrayList<>();//AllSubStringWithDuplicates
//		Set<String> allSubStrings02 = new HashSet<>(); //uniqueAllSubString
//
//		String str = "Java";
//		int length = str.length();
//
//		// Use IntStream to generate the starting indices
//		IntStream.range(0, length)
//				// FlatMap to handle the ending indices
//				.forEach(i -> {
//					IntStream.range(i + 1, length + 1).forEach(j -> {
//						System.out.println("(i,j) -> (" + i + ", " + j + ")");
//						allSubStrings0.add(str.substring(i, j));
//						allSubStrings02.add(str.substring(i, j));
//					});
//				});
//		// Print each substring
//		System.out.println("AllSubStringWithDuplicates ==> " + allSubStrings0);
//		System.out.println("       AllUniqueSubStrings ==> " + allSubStrings02);
//	        
//		String inputString = "Java";
//		List<String> allSubStrings = new ArrayList<>();//AllSubStringWithDuplicates
//		Set<String> allSubStrings2 = new HashSet<>(); //uniqueAllSubString
//		for (int i = 0; i < inputString.length(); i++)
//            for (int j = i+1; j <=inputString.length();j++) {
//            		allSubStrings.add(inputString.substring(i, j));
//            		allSubStrings2.add(inputString.substring(i, j));
//            	}
//         System.out.println("AllSubStringWithDuplicates ==> "+allSubStrings);
//         System.out.println("       AllUniqueSubStrings ==> "+allSubStrings2);
//		
//		String str1 = "Hello"; 
//		String str11 = "Hello";
//		System.out.println("str1 is literal?: "+(str1==str11));
//		
//		String str2 = " World"; 
//		String str33 = " World";
//		System.out.println("str2 is literal?: "+(str2==str33));
//		
//		String str3 = str2; 
//		System.out.println("str3 is literal?: "+(str3==str33));
////		System.out.println("str3 is literal?: "+(str3==str3.intern()));
//		
//		String result1 = "Hello" + " World";
////		System.out.println("result1 is literal?: "+(result1==result1.intern()));
//		System.out.println("result1 is literal?: "+(result1=="Hello World"));
//		String result11 = "Hello World";
//		System.out.println("result1 is literal?: "+(result1==result11));
////		System.out.println("result1 is literal?: "+(result1==result1.intern()));
//		
//		System.out.println("");
//		System.out.println("");
//		String result2 = str1 + str2;
////		System.out.println("result2 is literal?: "+(result2==result2.intern()));
//		System.out.println("result2 is literal?: "+(result2=="Hello World"));
//		System.out.println("result2 is literal?: "+(result2==result11));
//		
//		String result3 = "Hello" + str2;
////		System.out.println("result3 is literal?: "+(result3==result3.intern()));
//		System.out.println("result3 is literal?: "+(result3=="Hello World"));
//		System.out.println("result3 is literal?: "+(result3==result11));
//		
//		String result4 = str1 + " World"; 
////		System.out.println("result4 is literal?: "+(result4==result4.intern()));
//		System.out.println("result4 is literal?: "+(result4=="Hello World"));
//		System.out.println("result4 is literal?: "+(result4==result11));
//		
//		String result5 = str1.concat(str2);
////		System.out.println("result5 is literal?: "+(result5==result5.intern()));
//		System.out.println("result5 is literal?: "+(result5=="Hello World"));
//		System.out.println("result5 is literal?: "+(result5==result11));
//		
//		String str4 = new String(" World");
////		System.out.println("str4 is literal?: "+(str4==str4.intern()));
//		System.out.println("str4 is literal?: "+(str4==" World"));
//		System.out.println("result3 is literal?: "+(str4==str2));
//
//		String result6 = "Hello" + str4;  
////		System.out.println("result6 is literal?: "+result6+" "+(result6==result6.intern()));
//		System.out.println("result6 is literal?: "+(result6=="Hello World"));
//		System.out.println("result6 is literal?: "+(result6==result11));
//
//		str4 = new String("Hello");
//		String result7 = str4 + " World"; 
////		System.out.println("result7 is literal?: "+(result7==result7.intern()));
//		System.out.println("result7 is literal?: "+(result7=="Hello World"));
//		System.out.println("result7 is literal?: "+(result7==result11));
//
//	}

}
