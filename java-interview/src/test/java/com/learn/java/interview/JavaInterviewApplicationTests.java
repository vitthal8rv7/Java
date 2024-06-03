package com.learn.java.interview;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

import org.junit.jupiter.api.Test;

import com.learn.java.interview.model.Student;

import io.micrometer.common.util.StringUtils;
import lombok.Data;

//@SpringBootTest
public class JavaInterviewApplicationTests implements Serializable  {

	@Test
	void test25() {
	}
	
//	enum Day {
//	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
//	}
//	@Test
//	void test24() {
//		LinkedList<String> list;
//		Stack sl;
//		EnumSet<Day> allDays = EnumSet.allOf(Day.class);
//		allDays.remove(Day.FRIDAY);
//		for(Day d : allDays) {
//			System.out.println(""+d);
//		} //use Iterator to traverse EnumSet.
//	}
//
//	@Test
//	void test23() {
//		
//		Integer[] intArray = {1, 2, 3, 4, 5};//new Integer[10];
//		List<Integer> list = Arrays.asList(intArray);
//		System.out.println("intArray: "+ list);
//		intArray[0] = 2;
//		System.out.println("intArray: "+ list);
//		try {
//			list.add(1);
//			list.add(10);
//			list.add(100);
//		} catch(Exception e) {	
//			System.out.println("Exception: "+ e);
//		} finally {
//			System.out.println("intArray: "+ list);
//		}
////		OUTPUT
////		intArray: [1, 2, 3, 4, 5]
////		intArray: [2, 2, 3, 4, 5]		
////		Exception: [Ljava.lang.StackTraceElement;@139982de
////		intArray: [2, 2, 3, 4, 5]		
//	}
	
	
//	@Test
//	void test22() {
//		Lock lock;
//		ScheduledExecutorService s;
//		Runnable  RunnableTask = () -> {
//		    // Perform some computation or task
//		};
////		BlockingQueue<E> e;
//		Semaphore d;
//	}
//	
//	@Test
//	void test21() {
//		Thread t2 = new Thread(){
//			@Override
//			public void run() {
////				System.out.println("Run2");
////				System.out.println("t2.isAlive(): "+this.isAlive());
//				try {
//					Thread.sleep(7000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
////				System.out.println("Run2");
//
//			}	
//		};
//		Thread t1 = new Thread() {
//			@Override
//			public void run() {
////				System.out.println("Run1");
//				t2.start();
////				System.out.println("this.isAlive(): "+this.isAlive());
//				
//
//			}
//			
//			
//		};
//		t1.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println("t1.isAlive(): "+t1.isAlive());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("t2.isAlive(): "+t2.isAlive());
//	}

//	public <T> void print(List<T> numbers) {
//		
//	}
//	
//	public <T extends Number> void print1(List<T> numbers) {
//		
//	}
//	public <T extends Number & Comparable<T>> void print2(List<T> numbers) {
//		
//	}
//
////	public <T> void print3(List<> numbers) {
////		
////	}
//
//	public void show(List<?> numbers) {
//		
//	}
//
//	public void show1(List<? extends Number> numbers) {
//		
//	}
//
//	public void show2(List<? super Number> numbers) {
//		
//	}
//
//	@Test
//	void test20() {
//		Optional<String> os;
//
//	}
	
//	interface A {
//		String AB();
//	}
//	enum Weekdays implements A {
////		MONDAY {
////			@Override
////			public void a() {
////				// TODO Auto-generated method stub
////			}
////		};
//		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDDAY, MONDAY2("text");
////		public abstract void a();
//		
//		private String message;
//		Weekdays(){
//			if(this.toString() == "FRIDAY") {
//				message = "Today is friday.";
//			}
//			System.out.println("Inside constructor: "+this.toString());
//		}
//		Weekdays(String message) {
//			this.message = message;
//			System.out.println("Inside constructor: "+this.toString());
//		}
//		public String getMessage() {
//			return message;
//		}
//		
//		public void setMessage(String message) {
//			this.message = message;
//		}
//		@Override
//		public String AB() {
//			System.out.println("Ab");
//			return "Ab";
//			
//		}
//	}
	
//	@Test
//	void test19() {
//		System.out.println("Weekdays: " + Weekdays.class);
//		System.out.println("Weekdays: " + Weekdays.class.getName());
//		
////		System.out.println("Weekdays:MONDAY " + StringUtils.isBlank(Weekdays.MONDAY));
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY); 
//			//first time Enum used: all Enums get initialized by calling required constructors 
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY); 
//			//second time Enum used, not initialization. already done. just use Enums.
//		System.out.println("Weekdays:MONDAY " + Weekdays.valueOf("MONDAY")); 
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY.hashCode());
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY.ordinal());
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY.getDeclaringClass());
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY.getDeclaringClass().getName());
//		System.out.println("Weekdays:MONDAY:FRIDAY " + Weekdays.MONDAY.FRIDAY);
//		
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.MONDAY.hashCode()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.FRIDAY.hashCode()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.FRIDAY.hashCode() == Weekdays.FRIDAY.FRIDAY.hashCode()));
//	
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.ordinal()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.MONDAY.ordinal()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.FRIDAY.ordinal()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.valueOf("MONDAY").ordinal()));
//		System.out.println("Weekdays:MONDAY " + ("MONDAY".equals(Weekdays.MONDAY)));
//		System.out.println("Weekdays:MONDAY " + ("MONDAY".equals(Weekdays.MONDAY.toString())));
//		
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2));
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2.toString()));
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2.getMessage()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.MONDAY.getMessage()));
//		System.out.println("Weekdays:MONDAY " + (Weekdays.FRIDAY.getMessage()));
//		
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2.compareTo(Weekdays.MONDAY2)));
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2.compareTo(Weekdays.MONDAY)));
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2.ordinal() - Weekdays.MONDAY2.ordinal()));
//		System.out.println("Weekdays:MONDAY2 " + (Weekdays.MONDAY2.ordinal() - Weekdays.MONDAY.ordinal()));
//
//		Weekdays w = Weekdays.FRIDAY;
//		switch(w) {
//		case FRIDAY: System.out.println("FRIDAY");break;
//		case MONDAY: System.out.println("MONDAY");break;
//		case MONDAY2: System.out.println("MONDAY2");break;
//		default: System.out.println("default");break;
//		}
//
//		String week = Weekdays.FRIDAY.toString();
//		switch(week) {
//		case "FRIDAY": System.out.println("FRIDAY");break;
//		case "MONDAY": System.out.println("MONDAY");break;
//		case "MONDAY2": System.out.println("MONDAY2");break;
//		default: System.out.println("default");break;
//		}
//
//		System.out.println("Weekdays:MONDAY " + Weekdays.MONDAY.AB());
//	}
	
//	@Test
//	void test18() {
//		enum E2 {
			
//			A(""){
//				System.out.println("");
//			}, B("", ""){
//				System.out.println("");
//			}, C(){
//				System.out.println("");
//			}, D(6){
//				System.out.println("");
//			};
//		}
//		  enum PizzaStatus {
//			  
//		        ORDERED (5){
//		            @Override
//		            public boolean isOrdered() {
//		                return true;
//		            }
//		        },
//		        READY (2){
//		            @Override
//		            public boolean isReady() {
//		                return true;
//		            }
//		        },
//		        DELIVERED (0){
//		            @Override
//		            public boolean isDelivered() {
//		                return true;
//		            }
//		        };
//
//		        private int timeToDelivery;
//
//		        public boolean isOrdered() {return false;}
//
//		        public boolean isReady() {return false;}
//
//		        public boolean isDelivered(){return false;}
//
//		        public int getTimeToDelivery() {
//		            return timeToDelivery;
//		        }
//
//		        PizzaStatus (int timeToDelivery) {
//		            this.timeToDelivery = timeToDelivery;
//		        }
//		    }
//		  
//		  class Demo {
//			  PizzaStatus status = PizzaStatus.DELIVERED;
//			    public boolean isDeliverable() {
//		        return this.status.isReady();
//		    }
//			  
//		  }
//		  Demo d = new Demo();
//		  d.isDeliverable();
		
//	}
	
//	@Test
//	void test17() {
//		
//		enum demo1 {
//			A(""), B;
//			private String name = "";
//			demo1(){
//				
//			}
//			demo1(String s) {
//				super(s, 1);
//			}
//		}
//		
//		//Enum demo2 = new Enum();//{A, B, C, D}
//	}
	
//	@Test
//	void test16() {
//		class SortStudentByNameComparator implements Comparator<Student>{
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				
//				//Ascending Logic on last digit of number
//				if((o1.getId()%10) > (o2.getId()%10))
//					return 1;
//				if((o1.getId()%10) < (o2.getId()%10))
//					return -1;
//				return 0;
//				
//				//using comparable which is implemented by Integer class.
//				//return o1.getId().compareTo(o2.getId());
//			}
//			
//		}
//	}

//	@Test
//	void test15() {
//		Comparator<Student> salaryComparator = new Comparator<Student>() {
//
//			@Override
//			public int compare(Student e1, Student e2) {
//				return (int) (e1.getId() - e2.getId());
//			}
//		};
//		System.out.println("is equal: "+ salaryComparator.compare(new Student(1), new Student(1)));
//		Comparable<Student> salaryComparable = new Comparable<Student>() {
//			Student e1 = new Student(2);
//			@Override
//			public int compareTo(Student e2) {
//				System.out.println("this.getClass().getName(): "+ this.getClass().getName());
//				return e1.getId()-e2.getId();
//			}
//		};
//		System.out.println("test: "+ salaryComparable.compareTo(new Student(1)));
////		salaryComparable.compareTo(new Student(1));
//	}
	
//	@Test
//	void test14() {
//		class A {
//			Integer classAField1 = 1;
//			void classAMethod() {
//				classAField1 = 123;
//				Integer classAMethodField = 2;
//				class B {
//					Integer classBField1 = 11;
//					void classBMethod() {
////						classAMethodField= 123;
//						Integer classBMethodField = 22;
//						System.out.println("classBMethodField: "+ classBMethodField);
//						System.out.println("classBField1: "+ classBField1);
//						System.out.println("classAMethodField: "+ classAMethodField);
//						System.out.println("classAField1: "+ classAField1);
//					}
//				}
//				B b = new B();
//				b.classBMethod();
//			}
//		}
//		A a = new A();
//		a.classAMethod();
//	}
//	
	
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
