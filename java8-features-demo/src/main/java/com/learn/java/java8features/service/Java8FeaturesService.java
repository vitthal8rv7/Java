package com.learn.java.java8features.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class Java8FeaturesService {

	public void lambdaExpressionMultithreadingDemo1() {
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public void lambdaExpressionCollectionDemo1() {
		ArrayList<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(22);
		integerList.add(21);
		integerList.add(4);
		integerList.add(6);
		integerList.add(100);
		System.out.println("Insertion Order: " + integerList);
		Collections.sort(integerList, (a, b) -> a - b); // ascending a-b
		System.out.println("Ascending  Order : " + integerList);
		Collections.sort(integerList, (a, b) -> b - a); // descending b-a
		System.out.println("Descending Order : " + integerList);

		class Employee {
			Integer eno;
			String name;

			Employee(Integer eno, String name) {
				this.eno = eno;
				this.name = name;
			}

			public String toString() {
				return "eno:" + eno + " name:" + name;
			}
		}

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "name1"));
		employeeList.add(new Employee(22, "name22"));
		employeeList.add(new Employee(4, "name4"));
		employeeList.add(new Employee(99, "name99"));
		employeeList.add(new Employee(101, "name101"));
		System.out.println("Insertion Order: " + employeeList);
		Collections.sort(employeeList, (a, b) -> a.eno - b.eno); // ascending a-b
		System.out.println("Ascending  Order By Eno : " + employeeList);
		Collections.sort(employeeList, (a, b) -> -(a.eno - b.eno)); // descending b-a
		System.out.println("Descending Order By Eno" + employeeList);

		Collections.sort(employeeList, (a, b) -> a.name.compareTo(b.name)); // ascending a-b
		System.out.println("Ascending  Order By Eno : " + employeeList);
		Collections.sort(employeeList, (a, b) -> -(a.name.compareTo(b.name))); // descending b-a
		System.out.println("Descending Order By Eno" + employeeList);

	}

	public void defaultMethodDemo1() {
		interface TestInterface {
			default void testMethod() {
				System.out.println("This is test default method of TestInterface");
			}
		}

		interface TestInterface2 {
			default void testMethod() {
				System.out.println("This is test default method of TestInterface2");
			}
		}

//		Duplicate default methods named testMethod with the parameters () and () are inherited from the types TestInterface2 and TestInterface
//		class TestClass implements TestInterface, TestInterface2 {
		class TestClass implements TestInterface {
			public void defaultMethodCaller() {
				testMethod(); // HAS-A Relationship with TestInterface [ Inheritance ]

			}

//			Default methods are allowed only in interfaces.
//			default void testMethod2() { 
//				System.out.println("This is test default method.");
//			}

		}

//		Java allowed multiple inheritance for interfaces if and only if implementing class should override default methods(if found).
		class TestClass2 implements TestInterface, TestInterface2 {
			public void defaultMethodCaller() {
				testMethod(); // HAS-A Relationship with TestInterface [ Inheritance ]

			}

			public void testMethod() {
				System.out.println("This is test default method of TestClass2");
				TestInterface2.super.testMethod();
			}
		}

		TestClass testClass = new TestClass();
		testClass.defaultMethodCaller();
		TestClass2 testClass2 = new TestClass2();
		testClass2.defaultMethodCaller();

	}

	public void staticMethodDemo1() {
		interface TestInterface {
			static void testMethod() {
				System.out.println("This is test default method of TestInterface");
			}
		}
		interface TestInterface2 {
			static void testMethod() {
				System.out.println("This is test default method of TestInterface2");
			}
		}

		class TestClass implements TestInterface {
			public void defaultMethodCaller() {
				// testMethod(); //Invalid
				TestInterface.testMethod(); // Valid
				TestInterface2.testMethod(); // Valid

			}
		}

		class TestClass2 implements TestInterface, TestInterface2 {
			public void defaultMethodCaller() {
				testMethod(); // Valid //TestClass2 Class Method // No Over Hiding Concept
				TestInterface.testMethod(); // Valid
				TestInterface2.testMethod(); // Valid

			}

			public void testMethod() {
				System.out.println("This is test default method of TestClass2");
				TestInterface2.testMethod();
			}
		}
		TestClass testClass = new TestClass();
		testClass.defaultMethodCaller();
		TestClass2 testClass2 = new TestClass2();
		testClass2.defaultMethodCaller();

		// testClass.testMethod();
		// Invalid can`t call static method without TestInterface name(No Inheritance)
		testClass2.testMethod(); // Valid called TestClass2 method

	}

	public void predicateDemo1() {
		class Employee {
			Integer salary;
			String name;
			Integer age;

			public Employee(Integer salary, String name, Integer age) {
				super();
				this.salary = salary;
				this.name = name;
				this.age = age;
			}

			public Integer getSalary() {
				return salary;
			}

			public String getName() {
				return name;
			}

			public Integer getAge() {
				return age;
			}
		} // Employee

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(10000, "ABC", 22));
		employeeList.add(new Employee(20000, "XYZ", 32));
		employeeList.add(new Employee(12000, "AOP", 23));
		employeeList.add(new Employee(11111, "ABC2", 19));
		employeeList.add(new Employee(31000, "ABC3", 32));
		Predicate<Employee> ageUnder25 = employee -> employee.getAge() < 25;
		Predicate<Employee> senior = employee -> employee.getAge() > 25;
		Predicate<Employee> ageGreaterThan18 = employee -> employee.getAge() > 18;
		Predicate<Employee> ageLessThan21 = employee -> employee.getAge() < 21;
		BiPredicate<Integer, Integer> seniorMember = (salary, age) -> (salary > 15000 && age > 25);
		for (Employee e : employeeList) {
			if (ageUnder25.test(e))
				System.out.println("Age of " + e.getName() + " is under 25.");
		}

		for (Employee e : employeeList) {
			if (seniorMember.test(e.getSalary(), e.age))
				System.out.println(e.getName() + " is senior member of company");
		}

		for (Employee e : employeeList) {
			if (ageGreaterThan18.and(ageLessThan21).test(e))
				System.out.println(e.getName() + " is new Employee.");
		}

		for (Employee e : employeeList) {
			if (ageLessThan21.or(senior).test(e))
				System.out.println(e.getName() + " is new Employee Or Senior.");
		}

		for (Employee e : employeeList) {
			if (ageUnder25.negate().test(e))
				System.out.println(e.getName() + " is Senior Employee.");
		}
	}

	public void functionDemo1() {
		class Employee {
			private Integer salary;
			private String name;
			private Integer age;

			public Employee(Integer salary, String name, Integer age) {
				super();
				this.salary = salary;
				this.name = name;
				this.age = age;
			}

			public Integer getSalary() {
				return salary;
			}

			public String getName() {
				return name;
			}

			public Integer getAge() {
				return age;
			}

			public void setSalary(Integer salary) {
				this.salary = salary;
			}
		} // Employee

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(10000, "ABC", 22));
		employeeList.add(new Employee(20000, "XYZ", 32));
		employeeList.add(new Employee(12000, "AOP", 23));
		employeeList.add(new Employee(11111, "ABC2", 19));
		employeeList.add(new Employee(31000, "ABC3", 32));
		Function<Employee, Boolean> ageUnder25 = employee -> employee.getAge() < 25;
		BiFunction<Integer, Integer, Boolean> seniorMember = (salary, age) -> (salary > 15000 && age > 25);

		Function<Employee, Employee> updateAgeByTen = employee -> {
			employee.age = employee.getAge() + 10;
			return employee;
		};
		Function<Employee, Employee> updateSalaryBy10Percentage = employee -> {
			employee.setSalary(employee.getSalary() + (employee.getSalary() / 10));
			return employee;
		};
		Function<Employee, Boolean> isPramoted = employee -> employee.getAge() > 30;

		for (Employee e : employeeList) {
			if (ageUnder25.apply(e))
				System.out.println("Age of " + e.getName() + " is under 25.");
		}

		for (Employee e : employeeList) {
			if (seniorMember.apply(e.getSalary(), e.age))
				System.out.println(e.getName() + " is senior member of company");
		}

		for (Employee e : employeeList) {
			if (updateAgeByTen.andThen(updateSalaryBy10Percentage).andThen(isPramoted).apply(e))
				System.out.println(e.getName() + " is pramoted..");
			else
				System.out.println(e.getName() + " is not pramoted..");
		}
		Function<Integer, Boolean> areBothSenior = employeeAge -> employeeAge > 60;
		BiFunction<Employee, Employee, Integer> combineAge = (employee1, employee2) -> employee1.getAge()
				+ employee2.getAge();
		if (combineAge.andThen(areBothSenior).apply(employeeList.get(0), employeeList.get(1)))
			System.out.println("Both are seniors...");

	}

	public void consumerDemo1() {
		class Employee {
			private Integer salary;
			private String name;
			private Integer age;

			public Employee(Integer salary, String name, Integer age) {
				super();
				this.salary = salary;
				this.name = name;
				this.age = age;
			}

			public Integer getSalary() {
				return salary;
			}

			public String getName() {
				return name;
			}

			public Integer getAge() {
				return age;
			}

			public void setSalary(Integer salary) {
				this.salary = salary;
			}
		} // Employee

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(10000, "ABC", 22));
		employeeList.add(new Employee(20000, "XYZ", 32));
		employeeList.add(new Employee(12000, "AOP", 23));
		employeeList.add(new Employee(11111, "ABC2", 19));
		employeeList.add(new Employee(31000, "ABC3", 32));
		Consumer<Employee> ageUnder25 = employee -> {
			if (employee.getAge() < 25)
				System.out.println("Age of " + employee.getName() + " is under 25.");

		};

		BiConsumer<Integer, Integer> seniorMember = (salary, age) -> {
			if (salary > 15000 && age > 25) {
				System.out.println("Senior member of company");
			}
		};

		for (Employee e : employeeList) {
			ageUnder25.accept(e);
		}

		for (Employee e : employeeList) {
			seniorMember.accept(e.getSalary(), e.age);
		}

		Consumer<Employee> updateSalaryBy10Percentage = employee -> {
			employee.setSalary(employee.getSalary() + (employee.getSalary() / 10));
			System.out.println("Salary Update By 10%");
		};
		employeeList.stream().forEach(updateSalaryBy10Percentage::accept);

		Predicate<Employee> isAgeUnder25 = employee -> (employee.getAge() < 25);
		employeeList.stream().filter(isAgeUnder25::test)
				.forEach(e -> ageUnder25.andThen(updateSalaryBy10Percentage).accept(e));
	}

	public void supplierDemo1() {
		Supplier<LocalTime> timeSupplier = () -> LocalTime.now();
		System.out.println("LocalTime is: " + timeSupplier.get());

		// we can supply singleton object and many more other object like threads, db
		// object ...

	}

	public void primitiveFunctionsDemo1() {
		class Employee {
			private String name;
			private Integer age;

			public Employee(Integer salary, String name, Integer age) {
				super();
				this.name = name;
				this.age = age;
			}

			public String getName() {
				return name;
			}
		} // Employee
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(10000, "ABC", 22));
		employeeList.add(new Employee(20000, "XYZ", 32));
		employeeList.add(new Employee(12000, "AOP", 23));
		employeeList.add(new Employee(11111, "ABC2", 19));
		employeeList.add(new Employee(31000, "ABC3", 32));

		IntPredicate ageUnder25 = age -> age < 25;
		IntFunction<String> seniorMember = age -> "" + (age + 1); // age+1 in String
		IntToDoubleFunction seniorMember2 = age -> (1.0d + age); // age+1 in String

		for (Employee e : employeeList) {
			if (ageUnder25.test(e.age))
				System.out.println("Age of " + e.getName() + " is under 25.");
		}

		for (Employee e : employeeList) {
			if (Integer.valueOf(seniorMember.apply(e.age)) > 30)
				System.out.println(e.getName() + " is senior member of company");
		}

		for (Employee e : employeeList) {
			if (seniorMember2.applyAsDouble(e.age) > 30.0)
				System.out.println(e.getName() + " is senior member of company");
		}

	}

	public void referenceDemo1() {
		class Employee {
			private Integer salary;
			private String name;
			private Integer age;

			public Employee(Integer salary, Integer age) {
				super();
				this.salary = salary;
				this.name = "" + salary + age + RandomGenerator.getDefault().nextInt();
				this.age = age;
			}

			public Integer getSalary() {
				return salary;
			}

			public String getName() {
				return name;
			}

			public Integer getAge() {
				return age;
			}

			@Override
			public String toString() {
				return "Employee [salary=" + salary + ", name=" + name + ", age=" + age + "]";
			}
		} // Employee

		BiFunction<Integer, Integer, Employee> employeeSupplier = Employee::new;

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(employeeSupplier.apply(10000, 22));
		employeeList.add(employeeSupplier.apply(20000, 32));
		employeeList.add(employeeSupplier.apply(12000, 23));
		employeeList.add(employeeSupplier.apply(11111, 19));
		employeeList.add(employeeSupplier.apply(31000, 32));

		class EmployeeUtil {
			public boolean ageUnder25(Employee e) {
				return e.getAge() < 25;
			}

			public boolean goodSalary(Employee e) {
				return e.getSalary() > 25000;
			}

			public static boolean seniorMember(Employee e) {
				return e.getAge() > 30;
			}

		}
		EmployeeUtil employeeUtil = new EmployeeUtil();
		employeeList.stream().filter(employeeUtil::ageUnder25)
				.forEach(e -> System.out.println("Age of " + e.getName() + " is under 25."));
		employeeList.stream().filter(EmployeeUtil::seniorMember)
				.forEach(e -> System.out.println(e.getName() + " is senior member of company"));
		employeeList.stream().filter(employeeUtil::goodSalary).forEach(System.out::println);
	}

	public void dateTimeDemo1() {
		System.out.println("Current Time: " + LocalTime.now());
		System.out.println("Current Hours: " + LocalTime.now().getHour());
		System.out.println("Current Minutes: " + LocalTime.now().getMinute());
		System.out.println("Current Seconds: " + LocalTime.now().getSecond());
		System.out.println("Current Time(TimeZoned): "
				+ LocalTime.now(ZoneId.of(ZoneId.getAvailableZoneIds().stream().findFirst().get())));

		System.out.println("Current Time: " + LocalDate.now());
		System.out.println("Current Day Of Month: " + LocalDate.now().getDayOfMonth());
		System.out.println("Current Day Of Year: " + LocalDate.now().getDayOfYear());
		System.out.println("Current Month: " + LocalDate.now().getMonthValue());
		System.out.println("Current Year: " + LocalDate.now().getYear());
		System.out.println("Current Date(TimeZoned): "
				+ LocalDate.now(ZoneId.of(ZoneId.getAvailableZoneIds().stream().findFirst().get())));

		System.out.println("Current Time: " + LocalDateTime.now());
		System.out.println("Current Hours: " + LocalDateTime.now().getHour());
		System.out.println("Current Minutes: " + LocalDateTime.now().getMinute());
		System.out.println("Current Seconds: " + LocalDateTime.now().getSecond());
		System.out.println("Current Day Of Month: " + LocalDateTime.now().getDayOfMonth());
		System.out.println("Current Day Of Year: " + LocalDateTime.now().getDayOfYear());
		System.out.println("Current Month: " + LocalDateTime.now().getMonthValue());
		System.out.println("Current Year: " + LocalDateTime.now().getYear());
		System.out.println("Current Date(TimeZoned): "
				+ LocalDateTime.now(ZoneId.of(ZoneId.getAvailableZoneIds().stream().findFirst().get())));

		System.out.println(
				"Date after 4 month, 4minute from current date: " + LocalDateTime.now().plusMonths(4).plusMinutes(4));
		System.out.println("Date before 2 month, 12 minute from current date: "
				+ LocalDateTime.now().minusMonths(2).minusMinutes(12));

		LocalDate birthday = LocalDate.of(1991, 9, 22);
		System.out.println("birthday: " + birthday);

		LocalDate deathDay = LocalDate.of(1991 + 60, 9, 22);
		System.out.println("deathDay: " + deathDay);

		LocalDate today = LocalDate.now();
		System.out.println("today: " + today);

		Period livedLife = Period.between(birthday, today);
		System.out.println(String.format("Lived life is %d years, %d months, %d days", livedLife.getYears(),
				livedLife.getMonths(), livedLife.getDays()));
		Period remainingLife = Period.between(today, deathDay);
		System.out.println(String.format("Remaining life is %d years, %d months, %d days", remainingLife.getYears(),
				remainingLife.getMonths(), remainingLife.getDays()));

		System.out.println("ZoneId.systemDefault() : " + ZoneId.systemDefault());

		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		ZoneId zone = ZoneId.of("America/Los_Angeles"); // Get particular zone details
		System.out.println("zoneId : " + zone);
		ZonedDateTime zonedDateTime = ZonedDateTime.now(zone); // Current time of particular zone
		System.out.println("zonedDateTime : " + zonedDateTime);

	}

	public void unaryBinaryOperatorDemo1() {
		UnaryOperator<Integer> unary = number -> number * number;
		BinaryOperator<Integer> binary = (number1, number2) -> number1 + number2;
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		numbers.stream().map(unary::apply).forEach(System.out::println);
		numbers.stream().map(e1 -> binary.apply(e1, e1)).forEach(System.out::println);
		;
	}

	public void streamDemo1() {
		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).forEach(System.out::println);

		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).filter(even -> even % 2 == 0).forEach(System.out::println);

		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).map(sequare -> sequare * sequare).forEach(System.out::println);

		Stream.of(Stream.of(1, 2, 3), Stream.of(4, 5, 6, 6, 7, 8, 9, 10)).collect(Collectors.toList());

		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8));
		System.out.println("FlatMap: " + listOfLists.stream().flatMap(List::stream).collect(Collectors.toList()));

		System.out.println("Reduce: " + Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).filter(even -> even % 2 == 0)
				.reduce((even1, even2) -> (even1 + even2)).toString());

		BinaryOperator<Integer> binary = (number1, number2) -> number1 + number2;
		System.out.println("Reduce: " + Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).filter(even -> even % 2 == 0)
				.reduce((even1, even2) -> binary.apply(even1, even2)));

		System.out.println("min: " + Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).min((a, b) -> (a - b)).toString());
		System.out.println("max: " + Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).max((a, b) -> (a - b)).toString());

		System.out.println("min: " + Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).min((a, b) -> -(a - b)).toString());
		System.out.println("max: " + Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10).max((a, b) -> -(a - b)).toString());

		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).forEach(System.out::println);
		System.out.print("distinct: ");
		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).distinct().forEach(System.out::println);

		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).sorted().forEach(System.out::println);

		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).skip(6).forEach(System.out::println);

		Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).limit(6).forEach(System.out::println);

		System.out.print("anyMatch to 3: "
				+ Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).anyMatch(e -> e == 3));
		System.out.print("allMatch to 3: "
				+ Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).allMatch(e -> e == 3));

		System.out.print("findFirst to 3: "
				+ Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).filter((e -> e == 3)).findFirst());

		System.out.print("findAny to 3: "
				+ Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).filter((e -> e == 3)).findAny());

		System.out.print("count to 3: "
				+ Stream.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 2, 4, 5, 6, 8, 10).filter((e -> e == 3)).count());

	}

}
