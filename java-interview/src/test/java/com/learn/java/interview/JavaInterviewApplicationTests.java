package com.learn.java.interview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;

//@SpringBootTest
class JavaInterviewApplicationTests {
	@Test
	void test7() {
	}

//	@Test
//	void test6() {
//		 
//		
//		FileWriter fw = null;
//		File file = new File("./file1.txt");
//		BufferedReader br = null;
//		String line = null;
//		String newData = "";
//		String oldReplacementString = "85";
//		String newReplacementString = "95";	
//		try {
//			// Read File
//			br = new BufferedReader(new FileReader(file));
//			do {
//				line = br.readLine();
//				if(line == null) {
//					break;
//				}
//				newData = newData + line + System.lineSeparator();
//			}while(line!=null);
//			newData = newData.substring(0, newData.length()-1);
//			
//			// Replace specific string from the data 
//			System.out.println("oldData: "+ newData);
//			newData = newData.replaceAll(oldReplacementString, newReplacementString);
//			
//			// Write data to the File
//			fw = new FileWriter(file);
//			fw.write(newData);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				br.close();
//				fw.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("newData: "+ newData);
//
//	}
	
	
//	@Test
//	void test6()
//	{
//		String input = "Hello World, this is a Java program!";
//		System.out.println(input.replaceAll("[aeiouAEIOU]", ""));
//	}

//	@Test
//	void test5() {
//		String givenString = "Java Concept Of The Day";
//		StringBuffer sb = new StringBuffer();
//		List<Object> list = Arrays.asList(givenString.split(" "));
//		Collections.reverse(list);
//		list.stream().forEach(word -> sb.append(word+" "));
//		sb.deleteCharAt(sb.length()-1);
//		System.out.println(""+sb);
//		String[] array = givenString.split(" ");
//		for(int i = array.length-1; i>=0; i--) {
//			sb.append(array[i]+" ");
//		}
//		sb.deleteCharAt(sb.length()-1);
//		System.out.println(""+givenString);
//		System.out.println(""+sb);
//	}
	
//	@Test
//	void test4() {
//		String givenString = "javaconceptoftheday";
//		char[] charArray = givenString.toCharArray();
//		Map<Character, Integer> subString = new LinkedHashMap<>();
//		Map<Character, Integer> logestSubString = new LinkedHashMap<>();
//		for(Integer i = 0; i < givenString.length(); i++) {
//			System.out.println("");
//			if(subString.containsKey(charArray[i])) {
//				i = subString.get(charArray[i]);
//				if(logestSubString.size() < subString.size()) {
//					logestSubString = subString;
//				}
//				subString = new HashMap<>();
//			} else {
//				System.out.print(" "+charArray[i]);
//				subString.put(charArray[i], i);
//				
//			}
//		}
//		if(logestSubString.size() < subString.size()) {
//			logestSubString = subString;
//		}
//		System.out.println("logestSubString: "+logestSubString);
//		logestSubString.keySet().stream().forEach(System.out::print);
//		
//	}
//	
//	@Test
//	void test3() {
//		class Abc {
//			private static void StringPermutation(String permutation, String input) {
//				if (input.length() == 0) {
//					System.out.println(permutation);
//				} else {
//					for (int i = 0; i < input.length(); i++) {
//						StringPermutation(permutation + input.charAt(i),
//								input.substring(0, i) + input.substring(i + 1, input.length()));
//					}
//				}
//			}
//		}
//		Abc.StringPermutation("", "JSPA");
//	}
	
//	@Test 
//	void test2() {
//		
//		String str = "Java Concept Of The Day";
//		
//		// Convert the string to lower case and filter out spaces
//        str = str.toLowerCase().replaceAll("\\s", "");
//
//        // Use streams to create a frequency map
//        Map<Character, Long> frequencyMap = str.chars()
//            .mapToObj(c -> (char) c)
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        // Find the character with the maximum frequency
//        Map.Entry<Character, Long> entry = frequencyMap.entrySet().stream()
//            .max(Map.Entry.comparingByValue())
////            .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
////            .map(Map.Entry::getValue)
//            .orElseThrow(() -> new IllegalArgumentException("String is empty or only contains whitespace")); 
//        System.out.println("m.getKey(): "+ entry.getKey());
//        System.out.println("m.getValue(): "+ entry.getValue());
//
////entrym.getKey();
////entry.getValue();
//  
//	}
	
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
