package com.interview.learn.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class InterviewServerApplication {

	public static void main(String[] args) {
		Integer[] arr = {5, 3, 2, 8, 1, 4};
		// Sort array by even first and odd later, and sort both individually
//		int[] sortedArray = Arrays.stream(arr)
//				.sorted((a, b) -> {
//					// Check if both are even or both are odd
//					if (a % 2 == b % 2) {
//						return a - b; // Sort in ascending order
//					}
//					// Even numbers should come first
//					return (a % 2 == 0) ? -1 : 1;
//				})
//				.mapToInt(i -> i) // Convert Integer back to int
//				.toArray();

		System.out.println(Arrays.asList(arr));
		List<Integer> rearranged = Arrays.stream(arr)
				.peek(System.out::println)
				.sorted((a, b) -> Integer.compare(a % 2, b % 2))
				.toList()
				.stream()
				.peek(System.out::println)
				.sorted((a, b) -> {
					return (a % 2 == b % 2)?a-b:0;
				})
				.toList();
		System.out.println(rearranged);
//		System.out.println(Arrays.asList(arr));


//		int[] array = {3, 8, 12, 5, 7, 6, 2, 11};
//
//		int[] sortedArray = Arrays.stream(array)
//				.boxed()
//				.sorted((a, b) -> Integer.compare(a % 2, b % 2))
//				.mapToInt(i -> i)
//				.toArray();
//
//		System.out.println(Arrays.toString(sortedArray));

		SpringApplication.run(InterviewServerApplication.class, args);

	}

//	public static void evenoOddSeparator() {
//		// input--->int myarray[] = {4,1,6,3,2,9,7,5}
//		//Output--->myarray[] ={2,4,6,1,3,5,7,9}
//
//		List<Integer>	arrayList = List.of(4,1,6,3,2,9,7,5);
//		arrayList.stream()
//				 .forEach(value -> {
//					 if(value % 2 == 0) {
//
//					 } else {
//
//					 }
//				 });
//
//		int evenIndex = 0;
//		int oddIndex = 0;
//		IntStream.range(0,arrayList.size())
//				.forEach(value -> {
//					if(value % 2 == 0) {
//						arrayList.add(evenIndex, value);
//					} else {
//						//swap logic
//						arrayList.add(
//						arrayList.add((arrayList.size()-1) - index, value);
//					}
//				});
//	}
}

