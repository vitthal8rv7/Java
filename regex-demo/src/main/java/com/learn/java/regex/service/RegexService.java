package com.learn.java.regex.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class RegexService {

	public Integer testRegex(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(textData);
		Integer occurrences = 0;
		while (matcher.find()) {
			occurrences++;
		}
		return occurrences;
	}

	public Integer testRegex2(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(textData);
		Integer occurrences = 0;
		while (matcher.find()) {
			occurrences++;
		}
		return occurrences;
	}

	public Integer testRegex3(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern, Pattern.COMMENTS);
		Matcher matcher = pattern.matcher(textData);
		Integer occurrences = 0;
		while (matcher.find()) {
			occurrences++;
		}
		return occurrences;
	}

	public Integer testRegex4(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(textData);
		Integer occurrences = 0;
		while (matcher.find()) {
			System.out.println("Start Index: "+matcher.start());
			System.out.println("End Index: "+matcher.end());
			System.out.println("End Index: "+matcher.matches());
			System.out.println("End Index: "+matcher.lookingAt());
			occurrences++;
		}
		return occurrences;
	}

	public Integer testRegex5(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(textData);
		System.out.println("Match: "+matcher.matches());
		return 0;
	}

	public Integer testRegex6(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(textData);
		System.out.println("Match: "+matcher.lookingAt());
		return 0;
	}

	public Integer testRegex7(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(textData);
		System.out.println("Match: "+matcher.replaceFirst("cat"));
		return 0;
	}

	public Integer testRegex8(String regexPattern, String textData) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(textData);
		System.out.println("Match: "+matcher.replaceAll("cat"));
		return 0;
	}


	
}
