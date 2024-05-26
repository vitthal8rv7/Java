package com.learn.java.interview;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.Test;

//@SpringBootTest
public class JavaInterviewApplicationTests implements Serializable  {

	@Test
	void test14() {
		
		
	}
//	
//	@Test
//	void test13() {
//		
//		class BaseClass implements Serializable {
//		    private static final long serialVersionUID = 1L;
//		    int baseField;
//
//		    BaseClass() {
//		    	
//		    }
//
//		    BaseClass(int baseField) {
//		        this.baseField = baseField;
//		    }
//		}
//
//		class ChildClass extends BaseClass implements Externalizable {
//		    private static final long serialVersionUID = 1L;
//		    int childField;
//		    ChildClass() {
//		    	
//		    }
//		    ChildClass(int baseField, int childField) {
//		        super(baseField);
//		        this.childField = childField;
//		    }
//
//		    private void writeObject(ObjectOutputStream oos) throws IOException {
//		    	System.out.println("inside writeObject");
//		        oos.defaultWriteObject(); // Serialize base class fields
//		        // Custom logic: do not serialize child class fields
//		    }
//
//		    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//		    	System.out.println("inside readObject");
//		        ois.defaultReadObject(); // Deserialize base class fields
//		        // Custom logic: initialize child class fields manually if needed
//		        this.childField = 0; // or any default value or logic
//		    }
//
//			@Override
//			public void writeExternal(ObjectOutput out) throws IOException {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//				// TODO Auto-generated method stub
//				
//			}
//		}
//
//		        ChildClass child = new ChildClass(1, 2);
//
//		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"))) {
//		            oos.writeObject(child);
//		            System.out.println("inside oos");
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//
//		        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"))) {
//		        	System.out.println("inside ois");
//		        	ChildClass deserializedChild = (ChildClass) ois.readObject();
//		            
//		            System.out.println("BaseField: " + deserializedChild.baseField); // Will be 1
////		            System.out.println("ChildField: " + deserializedChild.childField); // Will be 0 (default value set in readObject)
//		        } catch (IOException | ClassNotFoundException e) {
//		            e.printStackTrace();
//		        }
//		
//	}

	
	
//	@Test
//	void test12() {
//		class A {
//			
//			 void aMethod() {
//				System.out.println("Insode A Class");
//			}
//		}
//
//		class B extends A {
//			
//			@Override
//			private void aMethod() {
//				System.out.println("Insode B Class");
//			}
//		}		
//		
//		
//	}
	
//	@Test
//	void test11() {
//		Student[] Arr = { new Student(1), new Student(2), new Student(3), new Student(5), new Student(0)};
//		Student[] tempArr = Arr.clone(); 
//		System.out.println("arr.0 == tempArr.0 "+ (Arrays.asList(Arr).get(0) == Arrays.asList(tempArr).get(0)));
//		System.out.println("Arr= "+ Arrays.asList(Arr));
//		System.out.println("tempArr= "+ Arrays.asList(tempArr));
//		
//		tempArr = new Student[Arr.length];
//		System.arraycopy(Arr, 0, tempArr, 0, Arr.length); 
//		System.out.println("arr.0 == tempArr.0 "+ (Arrays.asList(Arr).get(0) == Arrays.asList(tempArr).get(0)));
//		System.out.println("Arr= "+ Arrays.asList(Arr));
//		System.out.println("tempArr= "+ Arrays.asList(tempArr));
//		
//		tempArr = new Student[Arr.length];
//		Arrays.copyOf(Arr, Arr.length+1); 
//		System.out.println("arr.0 == tempArr.0 "+ (Arrays.asList(Arr).get(0) == Arrays.asList(tempArr).get(0)));
//		System.out.println("Arr= "+ Arrays.asList(Arr));
//		System.out.println("tempArr= "+ Arrays.asList(tempArr));
//
//		Integer[] original = {1, 2, 3};
//		Integer[] copy = Arrays.copyOf(original, 2); // [1, 2, 3, 0, 0]
//		System.out.println("original= "+ Arrays.asList(original));
//		System.out.println("copy= "+ Arrays.asList(copy));
//
//		tempArr = new Student[Arr.length];
//		Arrays.copyOfRange(Arr, 0, Arr.length+1); 
//		System.out.println("arr.0 == tempArr.0 "+ (Arrays.asList(Arr).get(0) == Arrays.asList(tempArr).get(0)));
//		System.out.println("Arr= "+ Arrays.asList(Arr));
//		System.out.println("tempArr= "+ Arrays.asList(tempArr));
//
////		original = {1, 2, 3};
//		copy = Arrays.copyOfRange(original, 0, 2); // [1, 2, 3, 0, 0]
//		System.out.println("original= "+ Arrays.asList(original));
//		System.out.println("copy= "+ Arrays.asList(copy));
//
//	}
	
//	@Test
//	void test10() {
//		String string1 = "Tiger Runs @ The Speed Of 100 km/hour.";
//		String string2 = "JavaConceptOfTheDay";
//		System.out.println("string1: "+ string1);
//		System.out.println("string2: "+ string2);
//		string1 = string1 + string2;
//		string2 = string1.substring(0, string1.length() - string2.length());
//		string1 = string1.substring(string2.length(), string1.length());
//		System.out.println("string1: "+ string1);
//		System.out.println("string2: "+ string2);
//	}
	
//	@Test
//	void test9() {
//		String givenString = "Tiger Runs @ The Speed Of 100 km/hour.";
//		Short upperCaseCount = 0;
//		Short lowerCaseCount = 0;
//		Short digitCount = 0;
//		Short specialCharCount = 0;
//		for (char ch : givenString.toCharArray()) {
//			if(Character.isDigit(ch)) {
//				upperCaseCount++;
//			} else if(Character.isLowerCase(ch)) {
//				lowerCaseCount++;
//			} else if(Character.isUpperCase(ch)) {
//				digitCount++;
//			} else {
//				specialCharCount++;
//			}
//		}
//		System.out.println("UpperCase: count: "+upperCaseCount+ " and % : "+((upperCaseCount*100)/(double)givenString.length()));
//		System.out.println("lowerCaseCount: count: "+lowerCaseCount+ " and % : "+((lowerCaseCount*100)/(double)givenString.length()));
//		System.out.println("digitCount: count: "+digitCount+ " and % : "+((digitCount*100)/(double)givenString.length()));
//		System.out.println("specialCharCount: count: "+specialCharCount+ " and % : "+((specialCharCount*100)/(double)givenString.length()));
//	}

	// if “JavaConceptOfTheDay” is the given string, then ‘J’ is a first
	// non-repeated character and ‘a’ is a first repeated character.
	// a => a, "" // aa => "", a // abb => a, b // aab => b, a
//	@Test
//	void test8() {
//		String givenString = "aab";//"abb";//"aa";//"a";//"JavaConceptOfTheDay";
//		givenString = givenString.toLowerCase();
//		// find 1st non-repeated char
//		Boolean isRepeatedCharFound = false;
//		Character repeatedChar = null;
//		Boolean isNonRepeatedCharFound = false;
//		Character nonRepeatedChar = null;
//		Map<Character, Integer> map = new HashMap<>();
//		for (char ch : givenString.toCharArray()) {
//			if (map.containsKey(ch)) {
//				map.put(ch, map.get(ch) + 1);
//			} else {
//				map.put(ch, 1);
//			}
//		}
//		for (char ch : givenString.toCharArray()) {
//			if((map.get(ch) == 1) && (isNonRepeatedCharFound == false)) {
//				nonRepeatedChar = ch;
//				isNonRepeatedCharFound = true;
//			} else if((map.get(ch) > 1) && (isRepeatedCharFound == false)) {
//				repeatedChar = ch;
//				isRepeatedCharFound = true;
//			}
//			if(isRepeatedCharFound && isNonRepeatedCharFound) {
//				break;
//			}
//		}
//		System.out.println("repeatedChar: " + repeatedChar);
//		System.out.println("nonRepeatedChar: " + nonRepeatedChar);
//		System.out.println("map: " + map);
//	}

//	@Test
//	void test7() {
//		Boolean isPalindrome = true;
//		String givenString = "abbbba";
//		for(int i = 0, j = givenString.length()-1; j > i; i++, j--) {
//			if(givenString.charAt(i) != givenString.charAt(j)) {
//				isPalindrome = false;
//				break;
//			}
//		}
//		System.out.println("isPalindrome: "+isPalindrome);
//	}

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

	// @Test
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
