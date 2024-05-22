package com.learn.java.interview.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@GetMapping("/test")
	public String test() {
		String firstString = "thin sticks";
		String secondString = "thick bricks";
		TreeSet<Character> firstStringSet = (TreeSet<Character>) firstString.replace(" ", "").chars()
					.mapToObj(c -> (char) c)
					.collect(Collectors.toSet());
		TreeSet<Character> secondStringSet = (TreeSet<Character>) secondString.replace(" ", "").chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toSet());
		firstStringSet.retainAll(secondStringSet);
		System.out.println("Common characters in alphabetical order : " + firstStringSet);
		System.out.println("Count : " + firstStringSet.size());

//		char[] firstStringToCharArray = firstString.replaceAll("\\s+", "").toCharArray();
//		char[] secondStringToCharArray = secondString.replaceAll("\\s+", "").toCharArray();
//		Set<Character> firstStringSet = new TreeSet<>();
//		Set<Character> secondStringSet = new TreeSet<>();
//		for (char c : firstStringToCharArray) {
//			firstStringSet.add(c);
//		}
//
//		for (char c : secondStringToCharArray) {
//			secondStringSet.add(c);
//		}

		return "";
	}
}