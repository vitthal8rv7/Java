package com.learn.java.interview;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Test;

import com.learn.java.interview.model.Employee;
import com.learn.java.interview.model.Employee2;
import com.learn.java.interview.model.Student;

import io.micrometer.common.util.StringUtils;
import lombok.Data;
import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

//@SpringBootTest
public class JavaInterviewApplicationTests implements Serializable  {
	@Test
	void test31() {
		Employee e = new Employee(1, "1", "A");
		System.out.println("Emp: "+e);
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(21, "21", "A"));
		empList.add(new Employee(2, "2", "B"));
		empList.add(new Employee(11, "11", "B"));
		empList.add(new Employee(13, "13", "C"));
		empList.add(new Employee(1, "1", "C"));
		empList.add(new Employee(31, "13", "D"));
		empList.add(new Employee(1, "1", "D"));
		empList.add(new Employee(31, "13", "E"));
		empList.add(new Employee(1, "1", "E"));
		empList.add(new Employee(31, "13", "A"));
		empList.add(new Employee(20, "1", "B"));
		empList.add(new Employee(21, "1", "B"));
		empList.add(new Employee(22, "1", "B"));
		empList.add(new Employee(31, "13", "C"));
		try {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 6, 7, 8, 9);
		Long l = list.stream().count();
		System.out.println("l: "+l);
		
		System.out.print("SKIP 3: ");
		list.stream().skip(3).forEach(System.out::print);
		System.out.println("");
		System.out.print("LIMIT 3: ");
		list.stream().limit(3).forEach(System.out::print);
		System.out.println("");
		//Q.) Create a map from a list where the map contains distinct values from the list as keys and their frequencies as values?
		 Map<Integer, Long> frequencyMap = list.stream()
												.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
	
		
		 String input1 = "ab_jandl-fnand,lanbk hfk$dkf";
		 
		// Convert the string to lower case and split by non-word characters to handle punctuation
		 Stream<String> wordSeperator = Arrays.stream(input1.toLowerCase().split("\\W+"));
		//Count the number of occurrences of words in given string using Streams? 
		Map<String, Long> wordFrequencyMap = wordSeperator.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    System.out.println("wordFrequencyMap: "+wordFrequencyMap);

	    // Convert the string to a stream of characters
	    Stream<Character> charStream = input1.chars().mapToObj(inputChar ->  (char)inputChar);
		//Count the number of occurrences of character in given string using Streams? 
		Map<Character, Long> charFrequencyMap = charStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    System.out.println("charFrequencyMap: "+charFrequencyMap);

	    //Count the number of occurrences of element in given list using Streams?
	    Map<Integer, Long> numberFrequencyMap = list.stream()
	    											.collect(
	    													Collectors.groupingBy(Function.identity(), 
	    													Collectors.counting()));
	    //Find duplicate elements from the frequency map
	    List<Integer> duplicateElements = numberFrequencyMap.entrySet()
	    					.stream()
	    					.filter(entry -> entry.getValue() > 1)
	    					.map(entry -> entry.getKey())
	    					.toList();
	    System.out.println("duplicateElements: "+ duplicateElements);
	    
		 //Convert Employee List to employee name list then get employee name frequency
		 Map<String, Long> empFrequencyMap = empList.stream()
				 									.map(object -> object.getName())
				 									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 System.out.println("empFrequencyMap: "+empFrequencyMap);
		 
		String s = list.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.toString();
			//.forEach(System.out::print);		
			System.out.println("s: "+s);
			
//			list.stream()
//				.map(x -> Collectors.counting());
			
		
		} catch(Exception ex ) {
			System.out.println("e: "+ ex.getMessage());
		}
		
		
		Random random = new Random();
		random.ints(5).forEach(System.out::println);
		random.ints(40, 50).limit(5).forEach(System.out::println);
		random.ints(5, 0, 10).forEach(System.out::println);

	
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Lowest number in List : " + stats);
		System.out.println("Lowest number in List : " + stats.getMin());
		//Lowest number in List : IntSummaryStatistics{count=7, sum=25, min=2, average=3.571429, max=7}
		//Lowest number in List : 2Lowest number in List : 2
		
		Integer number = 7;
		Boolean isPrime = IntStream	.range(2, number)
									.filter(i -> (number%i==0))
									.findAny()
									.isEmpty();
		System.out.println("isPrime: "+ (number>1 && isPrime));
		
		Boolean isPrime2 = IntStream.range(2, number)
									.noneMatch(i -> (number%i==0));
		System.out.println("isPrime2: "+ (number>1 && isPrime2));
		
		Predicate<Integer> isPrimeNumber = (element) -> (element>1 && IntStream	.range(2, element)
															.noneMatch(i -> (element%i==0)));
		System.out.println("isPrimeNumber: "+ isPrimeNumber.test(2));
		List<Double> sqrtOfNPrime = Stream	.iterate(1, i -> i+1)
											.filter(i -> isPrimeNumber.test(i))
											.peek(System.out::println)
											.limit(10)
											.map(Math::sqrt)
											.toList();
		System.out.println("sqrtOfNPrime: "+ sqrtOfNPrime);
		
		List<Integer> list1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		Set<Integer> set1 = new HashSet<>();
		List<Integer> duplicateList1 = list1.stream().filter(a -> !set1.add(a)).distinct().toList();
		Set<Integer> set2 = new HashSet<>();
		Set<Integer> duplicateSet2 = list1.stream().filter(a -> !set2.add(a)).collect(Collectors.toSet());
		System.out.println("duplicateList1: "+duplicateList1);
		System.out.println("duplicateSet2: "+duplicateSet2);
		
		Set<String> employeeSet = new HashSet<>();
		Set<String> duplicateSet3 = empList	.stream()
											.filter(employee -> !employeeSet.add(employee.getName()))
											.map(employee -> employee.getName())
											.collect(Collectors.toSet());//.distinct().toList(); 
		System.out.println("duplicateSet3: "+duplicateSet3);
		
		Set<String> duplicateSet4 = empList .stream()
				.filter(emp -> Collections.frequency(empList, emp.getName()) > 1)
				.map(emp -> emp.getName())
				.collect(Collectors.toSet());
		System.out.println("duplicateSet4: "+duplicateSet4);
		
//		Ascending Order
		List<Employee> sortedEmpList = empList	.stream()
												.sorted(Comparator.comparing(Employee::getName))
												.toList();
		System.out.println("Sorted: Ascending Order: "+ sortedEmpList);
	
//		Descending Order
		List<Employee> sortedEmpList2 = empList	.stream()
												.sorted((e1, e2) -> (- e1.getName().compareTo(e2.getName()) ) )
												.toList();
		System.out.println("Sorted: Descending Order: "+ sortedEmpList2);
		
		//Sort and save in existing list
		System.out.println("");
		empList.sort((e1, e2) -> ( e1.getName().compareTo(e2.getName()) ));
		System.out.println("Sorted: Ascending Order: "+ empList);

		System.out.println("");
		empList.sort((e1, e2) -> (- e1.getName().compareTo(e2.getName()) ));
		System.out.println("Sorted: Descending Order: "+ empList);
		
		System.out.println("");
		//Sorted in Descending Order and fetch 1st 3
		List<Employee> sortedEmpList11 = empList	.stream()
				.sorted((e1, e2) -> (- e1.getName().compareTo(e2.getName())))
				.limit(3)
				.toList();
		System.out.println("Sorted: Descending Order: 1st 3: "+ sortedEmpList11);
		
		System.out.println("");
		//Sorted in Descending Order and fetch last 3
		List<Employee> sortedEmpList12 = empList	.stream()
				.sorted((e1, e2) -> (- e1.getName().compareTo(e2.getName())))
				.skip(empList.size() - 3)
				.toList();

		System.out.println("Sorted: Descending Order: last 3: "+ sortedEmpList12);
		
		
		IntSummaryStatistics intSummaryStatistics = empList	.stream()
															.mapToInt(emp -> emp.getId())
															.summaryStatistics();
		System.out.println("Min: "+intSummaryStatistics.getMin());
		System.out.println("Max: "+intSummaryStatistics.getMax());
		System.out.println("Average: "+intSummaryStatistics.getAverage());
		System.out.println("Sum: "+intSummaryStatistics.getSum());
		System.out.println("Count: "+intSummaryStatistics.getCount());
		
		String joinedString = empList.stream().map(emp -> emp.getName()).collect(Collectors.joining());
		System.out.println("joinedString: "+joinedString);
		
		String joinedStringWithDelimiter = empList.stream().map(emp -> emp.getName()).collect(Collectors.joining(", "));
		System.out.println("joinedStringWithDelimiter: "+joinedStringWithDelimiter);
		
		
		Map<Object, List<Employee>> groupByEmpName = empList.stream().collect(Collectors.groupingBy(emp -> emp.getName()));
		System.out.println("\n\ngroupByEmpName: "+ groupByEmpName);
		
		//Override equals and hascode  method to check equality by user name or user id.
		Map<String, Set<String>> groupByEmpName2 = empList	.stream()
															.collect(Collectors.groupingBy(Employee::getName,  
																	Collectors.mapping(Employee::getDesignation, Collectors.toSet()) ));
		System.out.println("\n\ngroupByEmpName: "+ groupByEmpName);
		
		List<Employee2> emp2list = new ArrayList<>();


		emp2list.add(new Employee2(4, "Name2", "Pune"));
		emp2list.add(new Employee2(5, "Name2", "Nagpur"));
		emp2list.add(new Employee2(6, "Name2", "Nagpur"));
		
		emp2list.add(new Employee2(4, "Name3", "Pune"));
		emp2list.add(new Employee2(5, "Name3", "Pune"));
		emp2list.add(new Employee2(6, "Name4", "Nagpur"));

		emp2list.add(new Employee2(1, "Name1", "Pune"));
		emp2list.add(new Employee2(2, "Name1", "Pune"));
		emp2list.add(new Employee2(3, "Name1", "Mumbai"));

		Map<String, Set<String>> emp2GroupByNameNoDplicateCity = emp2list.stream()
				.collect(Collectors.groupingBy(Employee2::getName, 
						Collectors.mapping(Employee2::getVisitedCity, Collectors.toSet())));
		System.out.println("\n\n emp2GroupByNameNoDplicateCity: "+ emp2GroupByNameNoDplicateCity);
		
		Map<String, Set<String>> sortedGroupByNameNoDplicateCity = emp2list.stream()
				.collect(Collectors.groupingBy(Employee2::getName, 
						TreeMap::new,
						Collectors.mapping(Employee2::getVisitedCity, Collectors.toSet())));
		System.out.println("\n\n sortedGroupByNameNoDplicateCity: "+ sortedGroupByNameNoDplicateCity);
		
		
		JavaInterviewApplicationTests repo = new JavaInterviewApplicationTests();
		Optional<Employee2> emp = repo.findById();
		try {
			Employee2 e2 = emp.orElseThrow(() -> new AccountNotFoundException());
			String ename = Optional.ofNullable(e2.getName()).orElse("Anonymous User");
			System.out.println("ename: "+ ename);
		} catch (AccountNotFoundException e3) {
			e3.printStackTrace();
		}
		
	}
	
	Optional<Employee2> findById() {
//		return null;
//		return Optional.of(new Employee2(3, "Name1", "Mumbai"));
		return Optional.of(new Employee2(3, null, "Mumbai"));
	}
	
//	@Test
//	void test30() {
//		Function f;
//		interface A {
//			static void bMethod() {
//				System.out.println("A interface Static Method");
//			}
//			void aMethod();
//		}
//		interface B extends A {
//			default void aMethod() {
//				System.out.println("In Overrided Default Method");
//			}
//		}
//		new B() {}.aMethod();
//		class C implements A {
//			static void cMethod() {
//				System.out.println("C class Static Method");
//			}
//			@Override
//			public void aMethod() {
//				// TODO Auto-generated method stub
//				
//			}}
//		class D extends C {}
//		new D().cMethod();
//	}
//	@Test
//	void test29() {
//		Employee e = new Employee(1, "1");
//		System.out.println("Emp: "+e);
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(21, "21"));
//		empList.add(new Employee(2, "2"));
//		empList.add(new Employee(11, "11"));
//		empList.add(new Employee(13, "13"));
//		empList.add(new Employee(1, "1"));
//		empList.add(new Employee(31, "31"));
//		
//		//If the elements of this stream are not Comparable,
//		//List<Employee> toList = empList.stream().sorted().toList(); // java.lang.ClassCastException
//		List<Employee> toList = empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();
//		//Sorted method of stream does not modify existing list it return new if asked.
//		System.out.println("empList: "+empList);
//		System.out.println("toList: "+toList);
//		
//		List<Employee> toList2 = empList.stream().sorted(Comparator.comparing(Employee::getName)).toList();
//		//Sorted method of stream does not modify existing list it return new if asked.
//		System.out.println("empList: "+empList);
//		System.out.println("toList2: "+toList2);
//		
//		//List sort method will update existing list only
//		empList.sort(Comparator.comparing(Employee::getName));
//		System.out.println("empList: "+empList);
//	}
//	
//	@Test
//	void test28() {
//		
//		// Define the event time in the event's local time zone
//		ZonedDateTime eventZonedDateTime = ZonedDateTime.now();
//		        
//		// Define the user's local time zone
//		ZoneId userTimeZone = ZoneId.of("Asia/Tokyo"); // User's time zone
//		ZoneId userTimeZone2 = ZoneId.of("America/New_York"); // Event time zone;
//		ZonedDateTime eventInUserTimeZone = eventZonedDateTime.withZoneSameInstant(userTimeZone);
//		ZonedDateTime eventInUserTimeZone2 = eventZonedDateTime.withZoneSameInstant(userTimeZone2); 
//		System.out.println("eventZonedDateTime: "+eventZonedDateTime);
//		System.out.println("eventInUserTimeZone: "+eventInUserTimeZone);
//		System.out.println("eventInUserTimeZone2: "+eventInUserTimeZone2);
//		
//		
//
//	}
//
//	@Test
//	void test28() {
//		Year y;
//		DayOfWeek d;
//		ZoneId z; 
//		
//		Predicate<Long> s;
//		BiFunction<String, String, Integer> lengthFunction = (s1, s2) -> {  (s1.length() + s2.length()) };
//		Supplier<String> sss;
//	}
//	interface Employee {
//		public String getSalary();
//	}
//
//	@Test
//	void test27() {
//		class Main {
//
//			int x = 10;
//
//			private void doSomething() {
//				Employee employee = () -> { //LambdaExpression do not create new class, when it invoke
//					System.out.println(this.x); // In LambdaExpression this represent current class which is Main.
//					System.out.println(this.toString());
//					return "100";
//				};
//				employee.getSalary();
//				Employee employee1 = new Employee() {//AnonymousClass create new class, when it invoke
//					@Override
//					public String getSalary() {
//						System.out.println(this.toString()); // In LambdaExpression this represent current class which is new Employee().
//						return "100";
//					}
//				};
//				employee1.getSalary();
//			}
//		}
//		new Main().doSomething();
//	}
//	@Test
//	void test26() {
//		Integer number = 20;
//		int limit = (int) logn(number);
//		int k = number;
//		Integer[] array = new Integer[k];
//		boolean isSwapped = false;
//		boolean isSwapped2 = false;
//		int count = 0;
//		for (int i = 0; k > 0; k--) {
//			array[i++] = new Random().nextInt(100);
//		}
//		Arrays.asList(array).stream().forEach(value -> System.out.print(" "+value));
//		System.out.println("");
//		for (int a = 0; a < number; a++) {
//			isSwapped = false;
//			for (int i = 0; i < number - 1; i++, i++) {
////				System.out.println("" + array[i]);
//				if (array[i] > array[i + 1]){
//					isSwapped = true;
//					count = 0;
//					array[i] = array[i] + array[i + 1];
//					array[i + 1] = array[i] - array[i + 1];
//					array[i] = array[i] - array[i + 1];
//				}
//			}
//			if(isSwapped != true ) {
//				
//				count ++;
//				if(count == 2) {
//					System.out.println("IN - IN");
//				for (int i = 0; i < number - 1; i++) {
////					System.out.println("" + array[i]);
//					if (array[i] > array[i + 1]){
//						isSwapped = true;
//						array[i] = array[i] + array[i + 1];
//						array[i + 1] = array[i] - array[i + 1];
//						array[i] = array[i] - array[i + 1];
//					}
//				}
//				count = 0;
//				}
////				for(int i = 1; i < number/2; i++, i++) {
////					array[i] = array[i] + array[(number-1) - i];
////					array[(number-1) - i] = array[i] - array[(number-1) - i];
////					array[i] = array[i] - array[(number-1) - i];
////				}			
//			}
//			if(isSorted(array)) {
//				System.out.println("BREAK");
//				break;
//			}
//			System.out.println("a: "+a);
//			Arrays.asList(array).stream().forEach(value -> System.out.print(" "+value));
//			System.out.println("");
//			for(int i = 1; i < number/2; i++, i++) {
//				array[i] = array[i] + array[(number-1) - i];
//				array[(number-1) - i] = array[i] - array[(number-1) - i];
//				array[i] = array[i] - array[(number-1) - i];
//			}
//			Arrays.asList(array).stream().forEach(value -> System.out.print(" "+value));
//			System.out.println("");			
//		}
//		System.out.println("Exit");
//		Arrays.asList(array).stream().forEach(value -> System.out.print(" "+value));
////		System.out.println("array:"+ );
//	}
//
//	private boolean isSorted(Integer[] array) {
//		for(int i = 0; i<array.length-1; i++) {
//			if(array[i]>array[i+1]) {
//				return false;
//			}
//		}
//		return true;
//		
//	}
//
//	private double logn(double i) {
//		System.out.println("Math.log10(i): "+ Math.log(i));
//		return Math.log10(i);
//	}	
//	
//	@Test
//	void test25() {
//		Queue<String> queue = new PriorityQueue<>();
////		Queue queue = new PriorityQueue();
//		queue.add("VI");
//		queue.offer("1");
//		queue.offer("12");
//		queue.offer("11");
//		queue.offer("331");
//		queue.offer("13");
//		queue.offer("1");
////		queue.offer(1);
//		System.out.println("queue: "+queue);
//		
//		Queue<Integer> queue2 = new PriorityQueue<>();
////		Queue queue = new PriorityQueue();
//		queue2.add(1);
//		queue2.offer(23);
//		queue2.offer(23);
//		queue2.offer(23);
//		queue2.offer(23);
//		queue2.offer(200);
//		queue2.offer(-200);
//		queue2.offer(2);
//		queue2.offer(2);
//		queue2.offer(3);
//		queue2.offer(23);
//		queue2.offer(23);
//		queue2.offer(2);
//		queue2.offer(2);
//		queue2.offer(0);
//		queue2.offer(23);
//		queue2.offer(23);
//		queue2.offer(2);
////		queue.offer(1);
//		System.out.println("queue2: "+queue2);
//
//		Queue<Integer> queue3 = new PriorityQueue<>();
////		Queue queue = new PriorityQueue();
//		queue3.add(1);
//		queue3.add(823422);
//		queue3.add(3333333);
//		queue3.add(222);
//		queue3.add(2);
//		queue3.add(911);
//		queue3.add(913);
//		
//		
//		System.out.println("queue3: "+queue3);
//		System.out.println("queue3: "+queue3.poll());
//		System.out.println("queue3: "+queue3.poll());
//		System.out.println("queue3: "+queue3.poll());
//		System.out.println("queue3: "+queue3.poll());
//		System.out.println("queue3: "+queue3.poll());
//		System.out.println("queue3: "+queue3.poll());
//		System.out.println("queue3: "+queue3.peek());
//
//	}
	
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
