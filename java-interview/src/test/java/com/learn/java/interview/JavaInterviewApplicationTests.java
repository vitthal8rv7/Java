package com.learn.java.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.java.interview.model.test.Student;



@SpringBootTest
public class JavaInterviewApplicationTests {

	@Test
	void test70() {
		Predicate<Integer> isOdd = number -> number%2!=0;
		Predicate<Integer> isPrime = number -> IntStream.range(2, number>5?(int) Math.sqrt(number):number)
														.filter(i -> (number%i==0))
														.findAny()
														.isEmpty();
		Predicate<String> isPalindrome = palStr ->  IntStream.range(0, palStr.length()/2)
															.filter(i -> palStr.charAt(i) != palStr.charAt(palStr.length()-(i+1)))
															.findAny()
															.isEmpty();
		int a =2;
		String.valueOf(a);
	}
//    private boolean canWin(int leap, int[] game, int i) {
//        if (i < 0 || game[i] == 1) {
//            return false;
//        }
//        if (i + 1 >= game.length || i + leap >= game.length) {
//            return true;
//        }
//        game[i] = 1;
//
//        return canWin(leap, game, i + leap) || 
//               canWin(leap, game, i + 1) ||
//               canWin(leap, game, i - 1);
//    }
//   
//	@Test
//	void test68() {
//		//String s1[] = {"YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","YES ","YES ","YES ","NO ","YES ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","YES ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","YES ","NO ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","NO ","YES ","YES ","NO ","YES ","NO ","NO ","NO ","YES ","YES ","NO ","NO ","YES ","NO ","YES ","YES"};
//		Integer index = 0;
//		Scanner scan = new Scanner(System.in);
//        int q = scan.nextInt();
//        while (q-- > 0) {
//            Integer n = scan.nextInt();
//            int leap = scan.nextInt();
//            
//            int[] game = new int[n];
//            for (int i = 0; i < n; i++) {
//                game[i] = scan.nextInt();
//            }
//            String s2 = (canWin(leap, game, 0)) ? "YES" : "NO";
////            try {
////            	
////            if(!(s1[index++].trim().equalsIgnoreCase(s2.trim()))) {
////            	System.out.println("S1: "+ s1[index-1]);
////            	System.out.println("S2: "+ s2);
////            	System.out.println("Failed for leap: "+ leap);
////            	System.out.println("Failed for array length: "+ game.length);
////            	System.out.println("Failed for array: "+ Arrays.asList(game));
////            	break;
////            }
////            } catch(Exception e) {
////            	System.out.println(e);
////            }
//
//            System.out.println(s2);
//        }
//        scan.close();
//	}
//	1
//	58 27
//	0 0 0 1 1 0 1 0 1 0 0 0 1 1 1 0 0 0 1 1 1 0 1 1 0 1 1 0 1 0 0 0 0 1 0 0 1 1 1 1 0 1 0 0 1 1 0 1 1 1 1 1 1 1 1 0 1 0
	
//	@Test
//	void test68() {
//		Integer game[] = {0, 0, 1, 1, 1, 0, 1, 0};
//		Integer leap = 3;
//		int index = 0;
//		Integer count = 0;
//		while(index < game.length) {
//			System.out.println("index = "+index);
//			if(count++ > 100) break;
//			
//			if(index < 0) {
//				System.out.println("false");
//				break;
//			} 
//			if(game[index] > 0) {
//				System.out.println("false");break;
//			}
//			game[index] = 1;
//			System.out.println("game of index is "+ game[index]);
//			
//			if(((index + leap) >= game.length) || (index+1 >= game.length )) {
//				System.out.println("true");
//				break;
//			}
//			
//			if(game[index + leap] == 0) {
//				index = index + leap;
//			} else if(game[index + 1] == 0) {
//				index = index + 1;
//			} else if(game[index - 1] == 0) {
//				index = index - 1;
//			}
//		}
//	}
//	@Test
//	void test67() {
//		class Prime {
//		    Boolean isPrime = false;
//		    public void checkPrime(Integer... values ) {
//		        for(Integer value: values) {
//		            if(value < 2) continue;
//		            isPrime = true;
//		            for(int i = 2; i < value; i++) {
//		                if(value % i == 0) {
//		                    isPrime = false;
//		                }
//		            }
//		            if(isPrime) {
//		                System.out.print(""+value+" "); 
//		            }
//		        }
//		        System.out.println("");
//		    }
//		}
//	}
//	
//	@Test
//	void test66() {
//		class Player{
//		    String name;
//		    int score;
//		    
//		    Player(String name, int score){
//		        this.name = name;
//		        this.score = score;
//		    }
//		}
//		class Checker implements Comparator<Player> {
//	        @Override
//	        public int compare(Player a, Player b) {
//	            if(a.score == b.score) {
//	                return a.name.compareTo(b.name); 
//	            } else {
//	                return Integer.valueOf(a.score).compareTo(Integer.valueOf(b.score)); 
//	            }
//	        }
//		}
//	}
//	@Test
//	void test65() throws ClassNotFoundException {
//        Class student = Class.forName("Student");
//        Method[] methods = student.getDeclaredMethods();
//
//        ArrayList<String> methodList = new ArrayList<>();
//        for(Method method: methods){
//            methodList.add(method.getName());
//        }
//        Collections.sort(methodList);
//        for(String name: methodList){
//            System.out.println(name);
//        }
//	}
//	@Test
//	void test64() {
//		try{
//			Scanner scanner = new Scanner(System.in);
//			Integer x = Integer.parseInt(scanner.nextLine());
//			Integer y = Integer.parseInt(scanner.nextLine());
//			System.out.println("test: "+ x/y);;
//			scanner.close();
//		} catch(Exception e) {
//			if(e.getClass().getName() == "java.lang.NumberFormatException") {
//				System.out.println("java.util.InputMismatchException");
//			} else {
//				System.out.println(""+e);
//			}
//		}
//	}
//	@Test
//	void test64() {
//		Scanner scanner = new Scanner(System.in);
//		String val[] =scanner.nextLine().split("\\s+");
//		int N = Integer.parseInt(val[0]);
//		int M = Integer.parseInt(val[1]);
//		BitSet bs1 = new BitSet(N);
//		BitSet bs2 = new BitSet(N);
//		
////		System.out.println("bs1: "+ bs1);
////		System.out.println("bs2: "+ bs2);
//		//System.out.println("arr: "+Arrays.asList(val));
//		for(int i = 0; i < M; i++) {
//			String arr[] = scanner.nextLine().split("\\s+");
//			if(arr[0].equalsIgnoreCase("and")) {
//				if(arr[1].equalsIgnoreCase("1")) {
//					bs1.and(bs2);
//				} else {
//					bs2.and(bs1);
//				}
//			} else if(arr[0].equalsIgnoreCase("set")) {
//				if(arr[1].equalsIgnoreCase("1")) {
//					bs1.set(Integer.parseInt(arr[2]), true);
//				} else {
//					bs2.set(Integer.parseInt(arr[2]), true);
//				}				
//			} else if(arr[0].equalsIgnoreCase("flip")) {
//				if(arr[1].equalsIgnoreCase("1")) {
//					bs1.flip(Integer.parseInt(arr[2]));
//				} else {
//					bs2.flip(Integer.parseInt(arr[2]));
//				}				
//			} else if(arr[0].equalsIgnoreCase("or")) {
//				if(arr[1].equalsIgnoreCase("1")) {
//					bs1.or(bs2);
//				} else {
//					bs2.or(bs1);
//				}				
//			} else if(arr[0].equalsIgnoreCase("xor")) {
//				if(arr[1].equalsIgnoreCase("1")) {
//					bs1.xor(bs2);
//				} else {
//					bs2.xor(bs1);
//				}				
//			} else {
//				System.out.println("Incorrect Operation.");
//			}
//			System.out.println(""+ bs1.cardinality()+ " " + bs2.cardinality());
//			//System.out.println("arr: "+Arrays.asList(arr));
//		}
//		scanner.close();
//	}
//	@Test
//	void test63() {
//		Scanner in = new Scanner(System.in);
//		int testCases = Integer.parseInt(in.nextLine());
//		
//		List<Student> studentList = new ArrayList<Student>();
//		while(testCases>0){
//			int id = in.nextInt();
//			String fname = in.next();
//			double cgpa = in.nextDouble();
//			
//			Student st = new Student(id, fname, cgpa);
//			studentList.add(st);
//			
//			testCases--;
//		}
//	//	studentList.stream().sorted(Comparator.comparing(Student::getCgpa));
//	//	studentList = studentList.stream().sorted((studentObj1, studentObj2) -> studentObj2.getCgpa().compareTo(studentObj1.getCgpa())).toList();
//		Collections.sort(studentList, ((studentObj1, studentObj2) -> {			
//			if(studentObj1.getCgpa().equals(studentObj2.getCgpa())) {
//				if(studentObj1.getFname().equalsIgnoreCase(studentObj2.getFname())) {
//					return  studentObj1.getId().compareTo(studentObj2.getId());	
//				}
//				return  studentObj1.getFname().compareTo(studentObj2.getFname());
//			}
//			return studentObj2.getCgpa().compareTo(studentObj1.getCgpa());
//		}));
//      	for(Student st: studentList){
//			System.out.println(st.getFname());
//		}
//	}
//	@Test
//	void test62() {	
//		Scanner in = new Scanner(System.in);
//		int n = Integer.parseInt(in.nextLine());
//		Set<String> set = new HashSet<>();
//		for(int i=0;i<n;i++)
//		{
//			String name=in.nextLine();
//			set.add(name);
//			System.out.println(""+set.size());
//		}		
//		in.close();
//
///*        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        String [] pair_left = new String[t];
//        String [] pair_right = new String[t];
//        
//        for (int i = 0; i < t; i++) {
//            pair_left[i] = s.next();
//            pair_right[i] = s.next();
//        }
//
////Write your code here
//        Set<String> set = new HashSet<>();
//        for(int i=0;i<t;i++)
//        {
//            String name = pair_left[i].trim() + " " +pair_right[i].trim();
//            set.add(name);
//            System.out.println(""+set.size());
//        }       
//        */
//	}
//	@Test
//	void test61() {
//	Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//			String input=sc.next();
//            //Complete the code
//            Stack<Character> stack = new Stack<>();
//            char[] chars = input.toCharArray();
//            for(char ch: chars)
//            {
//                if(stack.isEmpty()) {
//                    stack.push(ch);
//                } else if((ch == '{') || (ch == '[') || (ch == '(')) {
//                    stack.push(ch);
//                } else if((ch == '}') || (ch == ']') || (ch == ')')) {
//                    char ch2 = stack.peek();
//                    if( (ch2 == '{' && ch == '}') ||
//                        (ch2 == '[' && ch == ']') ||
//                        (ch2 == '(' && ch == ')') ) {
//                        stack.pop();
//                    } else {
//                        stack.push(ch);
//                    }
//                }
//            }
//            if(stack.isEmpty()) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//		}		
//	}
//	@Test
//	void test60() {
//		Scanner in = new Scanner(System.in);
//		int n = Integer.parseInt(in.nextLine());
//        Map<String, Integer> map = new HashMap<>();
//		for(int i=0;i<n;i++)
//		{
//			String name=in.nextLine();
//			int phone= Integer.parseInt(in.nextLine());
//			map.put(name, phone);
//		}
//        //System.out.println("Map: "+map);
//		while(in.hasNext())
//		{
//			String s=in.nextLine();
//			
//			//System.out.println("S: "+s);
//            if(Objects.isNull(map.get(s))) {
//                System.out.println("Not found");
//            } else {
//                System.out.println(s+"="+map.get(s));
//            }
//		}	
//	}
//	@Test
//	void test59() {
//		Map<String, Integer> map = new HashMap<>();
//		map.get(2);
//		try {
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		    int N = Integer.parseInt(bufferedReader.readLine());
//		    String[] arr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//		    List<Integer> input = Arrays.stream(arr)
//		          .map(Integer::parseInt)
//		          .collect(toList());
//		    System.out.println("N: "+N);
//		    System.out.println("input: "+input);
//		    int k = 0;
//		    for(int i = 0; i < N; i++) {
//		    	for(int j = i+1; j <= N; j++) {
//		    		List<Integer> subList = input.subList(i, j);
//		    		Integer sum = subList.stream().mapToInt(vl -> vl).sum();
//		    		System.out.println("SubList: "+subList);
//		    		if(sum < 0) k++;
//		    	}
//		    }
//		    System.out.println("K: "+k);
//		} catch (Exception e) {
//			System.out.println("Exception: "+e);
//		}
//
//	}
//	@Test
//	void test58() throws IOException {
//	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	
//	    List<List<Integer>> arr = new ArrayList<>();
//	    IntStream.range(0, 6).forEach(i -> {
//	        try {
//	            arr.add(
//	                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//	                    .map(Integer::parseInt)
//	                    .collect(toList())
//	            );
//	        } catch (IOException ex) {
//	            throw new RuntimeException(ex);
//	        }
//	    });
//	    bufferedReader.close();
//	    
//	    Integer maxSum = null;
//	    Integer sum = 0;
//        for(int i = 0; i < arr.size()-2; i++) {
//            for(int j = 0; j < arr.size()-2; j++) {
//            	sum = 0;
//            	sum = sum + arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
//            			+ arr.get(i+1).get(j+1) 
//            			+ arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
//            	System.out.println("sum: "+sum); 
//                if(Objects.isNull(maxSum)) maxSum = sum;
//            	if(maxSum < sum) {
//                	maxSum = sum;
//                }
//            }
//        }
//        System.out.println("MaxSum: "+ maxSum);
//        
//	}
//	@Test
//	void test57() {
//        //Input
//        Scanner sc= new Scanner(System.in);
//        int n=sc.nextInt();
//        String []s=new String[n+2];
//        for(int i=0;i<n;i++){
//            s[i]=sc.next();
//        }
//        sc.close();
//
//        //Write your code here
//        try {
//        	Arrays.sort(s, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));
//        } catch(Exception e) {
//        	System.out.println("Exception: "+e);
//        }
//        
//        //Output
//        for(int i=0;i<n;i++)
//        {
//            System.out.println(s[i]);
//        }		
//	}
//	@Test
//	void test57() {
//		Scanner scanner = new Scanner(System.in);
//		String n1 = scanner.nextLine();
//		BigInteger bn1 = new BigInteger(n1);
//		String n2 = scanner.nextLine();
//		BigInteger bn2 = new BigInteger(n2);
//		System.out.println(""+bn1.add(bn2));
//		System.out.println(""+bn1.multiply(bn2));
//		scanner.close();
//	}
//	@Test
//	void test56() {
//		
//		String as = null;
//        String regex = "\\b(\\w+)(\\s+\\1)+\\b";
//        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//
//        Scanner in = new Scanner(System.in);
//        int numSentences = Integer.parseInt(in.nextLine());
//        
//        while (numSentences-- > 0) {
//            String input = in.nextLine();
//            
//            Matcher m = p.matcher(input);
//            
//            // Check for subsequences of input that match the compiled pattern
//            while (m.find()) {
//            	String m1 = m.group();
//            	String m2 = m.group(1);
//                input = input.replaceAll(m1, m2);
//                as = null;
//            }
//            
//            // Prints the modified sentence.
//            System.out.println(input);
//        }
//        
//        in.close();		
//		
//	}
//	@Test
//	void test55() {
//        StringBuffer result = new StringBuffer();
//		Scanner scanner = new Scanner(System.in);
//		try {
//			String input = null;
//			Pattern pattern = Pattern.compile("\\b(\\w+)(\\s+\\1)+\\b", Pattern.CASE_INSENSITIVE);
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//				input = scanner.nextLine();
//				Matcher matcher = pattern.matcher(input);
//		        while (matcher.find()) {
//		            matcher.appendReplacement(result, matcher.group(1));
//		        }
//		        matcher.appendTail(result);
//		        System.out.println(""+result.toString());
//		        result = new StringBuffer();
//		        
//			}
//		} catch (Exception e2) {
//			
//		}
//		scanner.close();
//	}	
//	@Test
//	void test55() {
//		Scanner scanner = new Scanner(System.in);
//		try {
//			Boolean isFound = false;
//			String input = null;
//			Pattern pattern = Pattern.compile("[\\w.%+-]+@[\\w.-]+\\.\\w{2,}");
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//				isFound = true;
//				input = scanner.nextLine();
//				Matcher matcher = pattern.matcher(input);
//				while (matcher.find()) {
//				    System.out.println(matcher.group());
//				    isFound = false;
//				} 
//				if(isFound){
//					//System.out.println("None");
//				}
//			}
//		} catch (Exception e2) {
//			
//		}
//		scanner.close();
//	}		
//	@Test
//	void test54() {
//		Scanner scanner = new Scanner(System.in);
//		try {
//			Boolean isFound = false;
//			String input = null;
//			Pattern pattern = Pattern.compile("<([^<>]+)>([^<>]+)</\\1>");
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//				isFound = true;
//				input = scanner.nextLine();
//				Matcher matcher = pattern.matcher(input);
//				while (matcher.find()) {
//				    System.out.println(matcher.group());
//				    isFound = false;
//				} 
//				if(isFound){
//					//System.out.println("None");
//				}
//			}
//		} catch (Exception e2) {
//			
//		}
//		scanner.close();
//	}	
//	@Test
//	void test54() {
//		Scanner scanner = new Scanner(System.in);
//		try {
//			Boolean isFound = false;
//			String input = null;
//			Pattern pattern = Pattern.compile("<([^<>]+)>([^<>]+)</\\1>");
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//				isFound = true;
//				input = scanner.nextLine();
//				Matcher matcher = pattern.matcher(input);
//				while (matcher.find()) {
//				    System.out.println(matcher.group(2));
//				    isFound = false;
//				} 
//				if(isFound){
//					System.out.println("None");
//				}
//			}
//		} catch (Exception e2) {
//			
//		}
//		scanner.close();
//	}		
//	@Test
//	void test53() {
//		Scanner scanner = new Scanner(System.in);
//		try {
//			Boolean isFound = false;
//			String input = null;
//			Pattern pattern = Pattern.compile("<([\\w\\s]+)>([^<>]+)</\\1>");
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//				isFound = true;
//				input = scanner.nextLine();
//				Matcher matcher = pattern.matcher(input);
//				while (matcher.find()) {
//				    System.out.println(matcher.group(2));
//				    isFound = false;
//				} 
//				if(isFound){
//					System.out.println("None");
//				}
//			}
//		} catch (Exception e2) {
//			
//		}
//		scanner.close();
//	}	
//	@Test
//	void test52() {
//		Scanner scanner = new Scanner(System.in);
//		try {
//			Boolean isFound = false;
//			String input = null;
//			Pattern pattern = Pattern.compile("<([\\w\\s]+)>(.*?)</\\1>");
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//				isFound = true;
//				input = scanner.nextLine();
//				Matcher matcher = pattern.matcher(input);
//				while (matcher.find()) {
//				    System.out.println(matcher.group(2));
//				    isFound = false;
//				} 
//				if(isFound){
//					System.out.println("None");
//				}
//			}
//		} catch (Exception e2) {
//			
//		}
//		scanner.close();
//
//		
//
//	}	
//	@Test
//	void test51() {
//		Pattern pattern = Pattern.compile("[abc]");
//		Matcher matcher = pattern.matcher("apple banana cherry");
//		while (matcher.find()) {
//		    System.out.println("Found: " + matcher.group()); 
//		}
//	}
//	@Test
//	void test50() {
//		
//		Scanner scanner = new Scanner(System.in);
//		try {
//			String userName = null;
//			Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{7,29}$");
//			Integer N = Integer.parseInt(scanner.nextLine());
//			for (int i = 0; i < N; i++) {
//
//				userName = scanner.nextLine();
//				// check Validity
//				Matcher matcher = pattern.matcher(userName);
//				if (matcher.find()) {
//					System.out.println("Valid");
//				} else {
//					System.out.println("Invalid");
//				}
//
//			}
//		} catch (PatternSyntaxException e) {
//			System.out.println("Invalid Pattern");
//		} catch (Exception e2) {
//
//		}
//		scanner.close();
//
//	}	
//	@Test
//	void test50() {
//    Scanner scanner = new Scanner(System.in);
//String ipAddress = null;
//
//try {
//Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
///*
//* Regular Expression (IPADDRESS_PATTERN):
//^ and $ are anchors that match the start and end of the string, ensuring the entire string is matched.
//((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}:
//Matches the first three octets.
//Each octet can be:
//25[0-5]: Numbers from 250 to 255.
//2[0-4][0-9]: Numbers from 200 to 249.
//[01]?[0-9][0-9]?: Numbers from 0 to 199.
//(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?):
//Matches the fourth octet using the same logic as the first three octets.
//\. matches the literal dot . between octets.
//* 
//* */            
//
//
//    do {
//        ipAddress = scanner.nextLine();
//    // check Validity
//    Matcher matcher = pattern.matcher(ipAddress);
//    if (matcher.find()) {
//        System.out.println("true");
//    } else {
//        System.out.println("false");
//    }
//
//}while (ipAddress != null); 
//} catch (PatternSyntaxException e) {
//// System.out.println("Invalid");
//} catch (Exception e2) {
//
//}
//
//scanner.close();
//	}
//	
//	@Test
//	void test49() {
//        Scanner scanner = new Scanner(System.in);
//        Integer N = Integer.parseInt(scanner.nextLine());
//        String regex = null;
//        Pattern pattern = null;
//        for(int i = 0; i < N; i++){
//            
//            try {
//            	while(regex == null) {
//            		regex = scanner.nextLine();
//            	}
//            	pattern = Pattern.compile(regex);
//            	pattern.flags();
//            	System.out.println("Valid");
//            } catch(PatternSyntaxException e) {
//            	System.out.println("Invalid");
//            }
//            regex = null;
//        }
//        scanner.close();	
//	}	
//	@Test
//	void test48() {
//        Scanner scanner = new Scanner(System.in);
//        int N = Integer.parseInt(scanner.nextLine());
//       
//        String input = scanner.nextLine();
//        
//        String[] values = input.split("[\\s!,?._'@]+");
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < N; i++) {
//        	list.add(Integer.parseInt(values[i]));
//        }
//        int Q = Integer.parseInt(scanner.nextLine());
//        for(int j = 0; j < Q; j++) {
//        	String queryType = null;
//        	do {
//        		queryType = scanner.nextLine();
//        	}while(queryType.isBlank());
//             
//            if(queryType.equalsIgnoreCase("insert")) {
////            	int a = Integer.parseInt(scanner.nextLine());
////            	int b = Integer.parseInt(scanner.nextLine());
//                int a = scanner.nextInt();
//                int b = scanner.nextInt();
//            	if(a < 0 || a > list.size()) continue;
//            	if(a == list.size()) {
//            		list.add(b);
//            	}
//            	else {
//            		list.add(a, b);
//            	}
//            } else {
//            	int a = Integer.parseInt(scanner.nextLine());
//            	if(a < 0 || a >= list.size()) continue;
//            	list.remove(a);
//            }  	
//        }
//        
//        for(int i = 0; i<list.size(); i++) {
//        	if(i == 0) {
//        		System.out.print(""+list.get(i));
//        	} else {
//        		System.out.print(" "+list.get(i));
//        	}
//        	
//        }
//        scanner.close();
//		
//	}
//	@Test
//	void test47() {
//		List<List<Integer>> listOfList = new ArrayList<>();
//		List<Integer> list = null;
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		for(int i = 0; i < n; i++) {
//			int d = scanner.nextInt();
//			list = new ArrayList<>();
//			for(int j = 0; j < d; j++) {
//				list.add(scanner.nextInt());
//			}	
//			listOfList.add(list);
//		}
//		int q = scanner.nextInt();
//		System.out.println("Q");
//		for(int k = 0; k < q; k++) {
//			int x = scanner.nextInt();
//			int y = scanner.nextInt();
//			Integer result = null;
//			try {
//				result = listOfList.get(x-1).get(y-1);	
//			} catch(Exception e) {
//				
//			}
//			if(Objects.isNull(result)) {
//				System.out.println("ERROR!");
//			} else {
//				System.out.println(""+result);
//			}
//		}	
//		scanner.close();
//	}
//	@Test
//	void test46() throws IOException {
//		try {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String n = bufferedReader.readLine();
//        bufferedReader.close();
//        BigInteger bigNumber = new BigInteger(n);
//        boolean isPrime = bigNumber.isProbablePrime(100);
//        if(isPrime) {
//        	System.out.println("prime");
//        } else {
//        	System.out.println("not prime");
//        }
////        Predicate<Long> isPrimeNumber =   
////        if(number.bitLength() >= 2) {
////        	isPrimeNumber = (element) -> (element>1 && LongStream.range(2l, (long)Math.sqrt(element)).noneMatch(i -> (element%i==0)));
////        } else {
////        	isPrimeNumber = (element) -> (element>1 && LongStream.range(2l, (long)element).noneMatch(i -> (element%i==0)));
////        }
////        
////        System.out.println("isPrimeNumber: "+ isPrimeNumber.test(number));
////        if(isPrimeNumber.test(number)) {
////        	 System.out.println("prime");
////        } else {
////        	System.out.println("not prime");
////        }
//		} catch(Exception e) {
//			System.out.println("Exception: "+e);
//		}
//	}
//	@Test
//	void test45() {
////		s.split("\\W+");
////		Regular Expression:
////
////		\\W matches any non-word character.
////		The + quantifier ensures that one or more consecutive non-word characters are treated as a single delimiter.
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
//        scan.close();
//        // Write your code here.
//        if(s.isBlank()) {
//            System.out.println("0");
//        } else {
//        s = s.trim();
//        String []stringArray = s.split("[\\s!,?._'@]+");
//        System.out.println(stringArray.length);
//        for(String str: stringArray) {
//            if(str.trim().length() > 0)
//                System.out.println(str.trim());
//        }
//        }
//         
//	}	
//	@Test
//	void test44() {
//        Scanner scan = new Scanner(System.in);
//        String a = scan.next();
//        String b = scan.next();
//        scan.close();
//        boolean ret = isAnagram(a, b);
//        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
//	}
//
//	private boolean isAnagram(String a, String b) {
//        a = a.toLowerCase();
//        b = b.toLowerCase();
//            int size = a.length();
//            while((a.length() == b.length()) && (a.length() > 0 && b.length() > 0)) {
//            	char ch = a.charAt(0);
//               a = a.replaceAll(""+ch, "");
//               b = b.replaceAll(""+ch, "");
//               System.out.println("A: "+a);
//               System.out.println("B: "+b);
//            }
//            if(a.length() == b.length()) {
//                return true;
//            } else {
//            return false;
//        } 
//     
//        a = a.toLowerCase();
//        b = b.toLowerCase();
//        char[] charArray = a.toCharArray();
//        Arrays.sort(charArray);
//        a = new String(charArray);
//        charArray = b.toCharArray();
//        Arrays.sort(charArray);
//        b = new String(charArray);
//		return a.equals(b);
//	}
//	@Test
//	void test43() {
//		String input = "madama";
//		boolean isPalindrome = false;
//		isPalindrome = IntStream.range(0, (input.length()-1)/2)
//				 .allMatch(i -> input.charAt(i) == input.charAt((input.length()-1) - i));
//		System.out.println((isPalindrome == true)?"Yes":"No"); 
//	}	
//	@Test
//	void test42() {
//		Scanner scan = new Scanner(System.in);
//		String s = scan.next();
//		int k = scan.nextInt();
//		scan.close();
//		try {
//			System.out.println(getSmallestAndLargest(s, k));
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	private String getSmallestAndLargest(String s, int k) {
//		String smallest = "";
//		String largest = "";
//
//		// Complete the function
//		// 'smallest' must be the lexicographically smallest substring of length 'k'
//		// 'largest' must be the lexicographically largest substring of length 'k'
//		if (s.length() <= k) {
//			smallest = s;
//			largest = s;
//		} else {
//			smallest = largest = s.substring(0, k);
//			for (int i = 1; i < ((s.length()+1) - k); i++) {
//				String subString = s.substring(i, i+k);
//				if (smallest.compareTo(subString) >= 0) {
//					smallest = subString;
//				} else if (largest.compareTo(subString) < 0) {
//					largest = subString;
//				}
//			}
//		}
//		return smallest + "\n" + largest;
//	}
//	
//	@Test
//	void test41() {
//        Scanner sc=new Scanner(System.in);
//        String A=sc.next();
//        String B=sc.next();
//        /* Enter your code here. Print output to STDOUT. */
//        System.out.println(A.length() + B.length());
//        System.out.println((A.compareTo(B) > 0)?"Yes":"No");
//        System.out.println(Character.toUpperCase(A.charAt(0)) + A.substring(1) + " " + Character.toUpperCase(B.charAt(0)) + B.substring(1));
//        sc.close();
//	}
//	@Test 
//	void test40() {
//        Scanner scanner = new Scanner(System.in);
//        scanner.useLocale(Locale.ENGLISH);
//        double number = scanner.nextDouble();
//        String payment = null;
//        System.out.println("US: "+ NumberFormat.getCurrencyInstance(Locale.US).format(number));
////        System.out.println("India: "+ NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(number));
//        String india = NumberFormat.getCurrencyInstance(Locale.US).format(number);
//        india =  india.replace("$","Rs.");
//        System.out.println("India: "+ india);
////        System.out.println("China: "+ NumberFormat.getCurrencyInstance(Locale.CHINA).format(number));
//        payment =  payment.replace("¥","￥");
//        System.out.println("China: "+ payment);
////        System.out.println("France: "+ NumberFormat.getCurrencyInstance(Locale.FRANCE).format(number));
//        payment = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(number);
//        payment =  payment.replace(" "," ");
//        System.out.println("France: "+ payment);
//        scanner.close();
//    }	
//	@Test 
//	void test39() {
//        LocalDate localDate = LocalDate.of(2024, 7, 11);        
//        System.out.println("Day: "+localDate.getDayOfMonth());
//        System.out.println(""+localDate.getDayOfWeek().toString());
//    }
//	@Test 
//	void test38() {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String nString = Integer.toString(n);
//        if(n == (Integer.parseInt(nString))) {
//        	System.out.println("Good job");
//        } else {
//        	System.out.println("Wrong answer");
//        }
//        scanner.close();
//    }
//	
//	@Test 
//	void test37() {
//		int b =0, h = -1;
//		try{
//	        if (b <= 0 || h <= 0) {
//	            throw new Exception("Breadth and height must be positive");
//	        } else {
//	            System.out.println(b*h);
//	        }
//	       } catch(Exception e) {
//	           System.out.println(e.getClass().getName()+ ": "+e.getMessage());    
//	       }
//	}
//	
//	@Test 
//	void test36() {
//        
//        Scanner scanner = new Scanner(System.in);
//       int lineNumber = 0;
//
//       // Read until end of file
//       while (scanner.hasNextLine()) {
//           String line = scanner.nextLine();
//           lineNumber++;
//           System.out.printf("%d %s%n", lineNumber, line);
//       }
////       do {
////           String line = scanner.nextLine();
////           lineNumber++;
////           System.out.printf("%d %s%n", lineNumber, line);
////       }while (scanner.hasNextLine());
//
//       scanner.close();
//	}
	
//	@Test
//	void test35() {
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			String size = scanner.nextLine();
//			if (!size.isBlank()) {
//				for (int i = 0; i < Integer.parseInt(size); i++) {
//					while (true) {
//						String value = scanner.nextLine();
//						if (!value.isBlank()) {
//							Long l = 0l;
//							try {
//								l = Long.parseLong(value);
//								System.out.println(value + " can be fitted in:");
//								if(l >= Byte.MIN_VALUE && l <= Byte.MAX_VALUE) {
//									 System.out.println("* byte");
//									 System.out.println("* short");
//									 System.out.println("* int");
//									 System.out.println("* long");									 
//								} else if(l >= Short.MIN_VALUE && l <= Short.MAX_VALUE) {
//									 System.out.println("* short");
//									 System.out.println("* int");
//									 System.out.println("* long");									 
//								} else if(l >= Integer.MIN_VALUE && l <= Integer.MAX_VALUE) {
//									 System.out.println("* int");
//									 System.out.println("* long");
//								} else {
//									 System.out.println("* long");
//								}								
//							} catch (Exception e) {
//								System.out.println(value + " can't be fitted anywhere.");
//								break;
//							}
//						}
//						break;
//					}
//				}
//				break;
//			}
//		}
//	}
//
//	@Test
//	void test34() {
//		HttpHeaders headers = new HttpHeaders();
//		List<String> values = headers.get("");
//
//		Scanner scanner = new Scanner(System.in);
//		scanner.next();
//
//		int numbOfQueries = scanner.nextInt();
//		for (int i = 0; i < numbOfQueries; i++) {
//			int a = scanner.nextInt();
//			int b = scanner.nextInt();
//			int n = scanner.nextInt();
//			printResult(a, b, n);
//			System.out.println("");
//		}
//		scanner.close();
//		int N = 123;
//		IntStream.rangeClosed(1, 10)
//				.mapToObj(i -> String.format("%d x %d = %d", N, i, (N * i)))
//				.forEach(System.out::println);
//		;
//	}
//
//	private void printResult(int a, int b, int n) {
//		int result = a+b;
//		for(int i = 1; i < n; i++) {
//			
//			result = result + (b * squareOf(i));
//			System.out.print(""+result+" ");
//		}
//		
//	}
//
//	private int squareOf(int n) {
//		int result = 1;
//		for(int i = 0; i<n; i++) {
//			result = result * 2;
//		}
//		return result;
//	}
//	
//	@Test
//	void test33() { 
//		String [] args = {"5", "1 4", "2 5", "3 898", "1 3", "2 12"};
//		System.out.println("Hello");
//		Arrays.stream(args).skip(1).forEach(value -> {
//			Arrays.stream(value.split("\\W")).forEach(System.out::println);
//		});
//		Predicate<Integer> isOdd = number -> number%2!=0;
//		Predicate<Integer> isPrime = number -> IntStream.range(2, number>5?(int) Math.sqrt(number):number)
//														.filter(i -> (number%i==0))
//														.findAny()
//														.isEmpty();
//		Predicate<String> isPalindrome = palStr ->  IntStream.range(0, palStr.length()/2)
//															.filter(i -> palStr.charAt(i) != palStr.charAt(palStr.length()-(i+1)))
//															.findAny()
//															.isEmpty();
//														
//				
//		Arrays.stream(args)
//				.skip(1)
//				.forEach(str -> {
//					String[] str2 = str.split("\\W");
//					Integer operation = Integer.parseInt(str2[0]);
//					Integer number = Integer.parseInt(str2[1]);
//					
//					switch(operation) {
//						case 1: 
//							if(isOdd.test(number)) {
//								System.out.println("ODD");
//							} else {
//								System.out.println("EVEN");
//							}
//							break;
//						case 2: 
//							if(isPrime.test(number)) {
//								System.out.println("PRIME");
//							} else {
//								System.out.println("COMPOSITE");
//							}						
//							break;
//						case 3: 
//							if(isPalindrome.test(str2[1])) {
//								System.out.println("PALINDROME");
//							} else {
//								System.out.println("NOT PALINDROME");
//							}												
//							break;
//						default : 
//							System.out.println("DEFAULT");
//							break;
//					}
//				});
//	}
//	
//	@Test
//	void test32() { 
//		
//		
//		@Controller
//		@ResponseBody
//		 class MyRestController {}
//		//3. Write a Java program to check if a vowel is present in a string.
//		String input = "sfsd";
//		System.out.println("is found ovel: "+input.toLowerCase().matches(".*[aeiou].*")); 
//		input = "sfsde";
//		System.out.println("is found ovel: "+input.toLowerCase().matches(".*[aeiou].*")); 
//		input = "sfsd e";
//		System.out.println("is found ovel: "+input.toLowerCase().matches(".*[aeiou].*")); 
//
//		IntFunction<String> printMsg = (i) -> {
//			String result = "";
//			if(i%3==0) {
//				result = result + "Fizz";
//			}
//			if(i%5==0) {
//				result = result + "Buzz";
//			}
//			if(result.isBlank()) {
//				result = result +i;
//			}
//			return result;
//		};
//		Integer n = 20;
//		IntStream.range(1, n).mapToObj(i -> printMsg.apply(i)).forEach(System.out::println);		
//		
//		//5. Write a Java program to print a Fibonacci sequence using recursion.
//		//org.springframework.stereotype.
//
//	}
//	
	
	
//	@Test
//	void test31() {
//		Employee e = new Employee(1, "1", "A");
//		System.out.println("Emp: "+e);
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(21, "21", "A"));
//		empList.add(new Employee(2, "2", "B"));
//		empList.add(new Employee(11, "11", "B"));
//		empList.add(new Employee(13, "13", "C"));
//		empList.add(new Employee(1, "1", "C"));
//		empList.add(new Employee(31, "13", "D"));
//		empList.add(new Employee(1, "1", "D"));
//		empList.add(new Employee(31, "13", "E"));
//		empList.add(new Employee(1, "1", "E"));
//		empList.add(new Employee(31, "13", "A"));
//		empList.add(new Employee(20, "1", "B"));
//		empList.add(new Employee(21, "1", "B"));
//		empList.add(new Employee(22, "1", "B"));
//		empList.add(new Employee(31, "13", "C"));
//		try {
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 6, 7, 8, 9);
//		Long l = list.stream().count();
//		System.out.println("l: "+l);
//		
//		System.out.print("SKIP 3: ");
//		list.stream().skip(3).forEach(System.out::print);
//		System.out.println("");
//		System.out.print("LIMIT 3: ");
//		list.stream().limit(3).forEach(System.out::print);
//		System.out.println("");
//		//Q.) Create a map from a list where the map contains distinct values from the list as keys and their frequencies as values?
//		 Map<Integer, Long> frequencyMap = list.stream()
//												.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		
//	
//		
//		 String input1 = "ab_jandl-fnand,lanbk hfk$dkf";
//		 
//		// Convert the string to lower case and split by non-word characters to handle punctuation
//		 Stream<String> wordSeperator = Arrays.stream(input1.toLowerCase().split("\\W+"));
//		//Count the number of occurrences of words in given string using Streams? 
//		Map<String, Long> wordFrequencyMap = wordSeperator.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//	    System.out.println("wordFrequencyMap: "+wordFrequencyMap);
//
//	    // Convert the string to a stream of characters
//	    Stream<Character> charStream = input1.chars().mapToObj(inputChar ->  (char)inputChar);
//		//Count the number of occurrences of character in given string using Streams? 
//		Map<Character, Long> charFrequencyMap = charStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//	    System.out.println("charFrequencyMap: "+charFrequencyMap);
//
//	    //Count the number of occurrences of element in given list using Streams?
//	    Map<Integer, Long> numberFrequencyMap = list.stream()
//	    											.collect(
//	    													Collectors.groupingBy(Function.identity(), 
//	    													Collectors.counting()));
//	    //Find duplicate elements from the frequency map
//	    List<Integer> duplicateElements = numberFrequencyMap.entrySet()
//	    					.stream()
//	    					.filter(entry -> entry.getValue() > 1)
//	    					.map(entry -> entry.getKey())
//	    					.toList();
//	    System.out.println("duplicateElements: "+ duplicateElements);
//	    
//		 //Convert Employee List to employee name list then get employee name frequency
//		 Map<String, Long> empFrequencyMap = empList.stream()
//				 									.map(object -> object.getName())
//				 									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		 System.out.println("empFrequencyMap: "+empFrequencyMap);
//		 
//		String s = list.stream()
//			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//			.toString();
//			//.forEach(System.out::print);		
//			System.out.println("s: "+s);
//			
////			list.stream()
////				.map(x -> Collectors.counting());
//			
//		
//		} catch(Exception ex ) {
//			System.out.println("e: "+ ex.getMessage());
//		}
//		
//		
//		Random random = new Random();
//		random.ints(5).forEach(System.out::println);
//		random.ints(40, 50).limit(5).forEach(System.out::println);
//		random.ints(5, 0, 10).forEach(System.out::println);
//
//	
//		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
//		System.out.println("Lowest number in List : " + stats);
//		System.out.println("Lowest number in List : " + stats.getMin());
//		//Lowest number in List : IntSummaryStatistics{count=7, sum=25, min=2, average=3.571429, max=7}
//		//Lowest number in List : 2Lowest number in List : 2
//		
//		Integer number = 7;
//		Boolean isPrime = IntStream	.range(2, number)
//									.filter(i -> (number%i==0))
//									.findAny()
//									.isEmpty();
//		System.out.println("isPrime: "+ (number>1 && isPrime));
//		
//		Boolean isPrime2 = IntStream.range(2, number)
//									.noneMatch(i -> (number%i==0));
//		System.out.println("isPrime2: "+ (number>1 && isPrime2));
//		
//		Predicate<Integer> isPrimeNumber = (element) -> (element>1 && IntStream	.range(2, element)
//															.noneMatch(i -> (element%i==0)));
//		System.out.println("isPrimeNumber: "+ isPrimeNumber.test(2));
//		List<Double> sqrtOfNPrime = Stream	.iterate(1, i -> i+1)
//											.filter(i -> isPrimeNumber.test(i))
//											.peek(System.out::println)
//											.limit(10)
//											.map(Math::sqrt)
//											.toList();
//		System.out.println("sqrtOfNPrime: "+ sqrtOfNPrime);
//		
//		List<Integer> list1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//		Set<Integer> set1 = new HashSet<>();
//		List<Integer> duplicateList1 = list1.stream().filter(a -> !set1.add(a)).distinct().toList();
//		Set<Integer> set2 = new HashSet<>();
//		Set<Integer> duplicateSet2 = list1.stream().filter(a -> !set2.add(a)).collect(Collectors.toSet());
//		System.out.println("duplicateList1: "+duplicateList1);
//		System.out.println("duplicateSet2: "+duplicateSet2);
//		
//		Set<String> employeeSet = new HashSet<>();
//		Set<String> duplicateSet3 = empList	.stream()
//											.filter(employee -> !employeeSet.add(employee.getName()))
//											.map(employee -> employee.getName())
//											.collect(Collectors.toSet());//.distinct().toList(); 
//		System.out.println("duplicateSet3: "+duplicateSet3);
//		
//		Set<String> duplicateSet4 = empList .stream()
//				.filter(emp -> Collections.frequency(empList, emp.getName()) > 1)
//				.map(emp -> emp.getName())
//				.collect(Collectors.toSet());
//		System.out.println("duplicateSet4: "+duplicateSet4);
//		
////		Ascending Order
//		List<Employee> sortedEmpList = empList	.stream()
//												.sorted(Comparator.comparing(Employee::getName))
//												.toList();
//		System.out.println("Sorted: Ascending Order: "+ sortedEmpList);
//	
////		Descending Order
//		List<Employee> sortedEmpList2 = empList	.stream()
//												.sorted((e1, e2) -> (- e1.getName().compareTo(e2.getName()) ) )
//												.toList();
//		System.out.println("Sorted: Descending Order: "+ sortedEmpList2);
//		
//		//Sort and save in existing list
//		System.out.println("");
//		empList.sort((e1, e2) -> ( e1.getName().compareTo(e2.getName()) ));
//		System.out.println("Sorted: Ascending Order: "+ empList);
//
//		System.out.println("");
//		empList.sort((e1, e2) -> (- e1.getName().compareTo(e2.getName()) ));
//		System.out.println("Sorted: Descending Order: "+ empList);
//		
//		System.out.println("");
//		//Sorted in Descending Order and fetch 1st 3
//		List<Employee> sortedEmpList11 = empList	.stream()
//				.sorted((e1, e2) -> (- e1.getName().compareTo(e2.getName())))
//				.limit(3)
//				.toList();
//		System.out.println("Sorted: Descending Order: 1st 3: "+ sortedEmpList11);
//		
//		System.out.println("");
//		//Sorted in Descending Order and fetch last 3
//		List<Employee> sortedEmpList12 = empList	.stream()
//				.sorted((e1, e2) -> (- e1.getName().compareTo(e2.getName())))
//				.skip(empList.size() - 3)
//				.toList();
//
//		System.out.println("Sorted: Descending Order: last 3: "+ sortedEmpList12);
//		
//		
//		IntSummaryStatistics intSummaryStatistics = empList	.stream()
//															.mapToInt(emp -> emp.getId())
//															.summaryStatistics();
//		System.out.println("Min: "+intSummaryStatistics.getMin());
//		System.out.println("Max: "+intSummaryStatistics.getMax());
//		System.out.println("Average: "+intSummaryStatistics.getAverage());
//		System.out.println("Sum: "+intSummaryStatistics.getSum());
//		System.out.println("Count: "+intSummaryStatistics.getCount());
//		
//		String joinedString = empList.stream().map(emp -> emp.getName()).collect(Collectors.joining());
//		System.out.println("joinedString: "+joinedString);
//		
//		String joinedStringWithDelimiter = empList.stream().map(emp -> emp.getName()).collect(Collectors.joining(", "));
//		System.out.println("joinedStringWithDelimiter: "+joinedStringWithDelimiter);
//		
//		
//		Map<Object, List<Employee>> groupByEmpName = empList.stream().collect(Collectors.groupingBy(emp -> emp.getName()));
//		System.out.println("\n\ngroupByEmpName: "+ groupByEmpName);
//		
//		//Override equals and hascode  method to check equality by user name or user id.
//		Map<String, Set<String>> groupByEmpName2 = empList	.stream()
//															.collect(Collectors.groupingBy(Employee::getName,  
//																	Collectors.mapping(Employee::getDesignation, Collectors.toSet()) ));
//		System.out.println("\n\ngroupByEmpName: "+ groupByEmpName);
//		
//		List<Employee2> emp2list = new ArrayList<>();
//
//
//		emp2list.add(new Employee2(4, "Name2", "Pune"));
//		emp2list.add(new Employee2(5, "Name2", "Nagpur"));
//		emp2list.add(new Employee2(6, "Name2", "Nagpur"));
//		
//		emp2list.add(new Employee2(4, "Name3", "Pune"));
//		emp2list.add(new Employee2(5, "Name3", "Pune"));
//		emp2list.add(new Employee2(6, "Name4", "Nagpur"));
//
//		emp2list.add(new Employee2(1, "Name1", "Pune"));
//		emp2list.add(new Employee2(2, "Name1", "Pune"));
//		emp2list.add(new Employee2(3, "Name1", "Mumbai"));
//
//		Map<String, Set<String>> emp2GroupByNameNoDplicateCity = emp2list.stream()
//				.collect(Collectors.groupingBy(Employee2::getName, 
//						Collectors.mapping(Employee2::getVisitedCity, Collectors.toSet())));
//		System.out.println("\n\n emp2GroupByNameNoDplicateCity: "+ emp2GroupByNameNoDplicateCity);
//		
//		Map<String, Set<String>> sortedGroupByNameNoDplicateCity = emp2list.stream()
//				.collect(Collectors.groupingBy(Employee2::getName, 
//						TreeMap::new,
//						Collectors.mapping(Employee2::getVisitedCity, Collectors.toSet())));
//		System.out.println("\n\n sortedGroupByNameNoDplicateCity: "+ sortedGroupByNameNoDplicateCity);
//		
//		
//		JavaInterviewApplicationTests repo = new JavaInterviewApplicationTests();
//		Optional<Employee2> emp = repo.findById();
//		Employee2 e2 = emp.orElseThrow(() -> new IllegalArgumentException());
//		String ename = Optional.ofNullable(e2.getName()).orElse("Anonymous User");
//		System.out.println("ename: "+ ename);
//		
//		Employee2 second2 = emp2list.stream()
//				.collect(Collectors.groupingBy(Employee2::getId))
//				.entrySet().stream()
////				.limit(2)
//				.skip(1)
//				.findFirst()
//				.orElseThrow(() -> new IllegalArgumentException("Second element is not present"))
//				.getValue().stream()
//				.findFirst().orElseThrow(() -> new IllegalArgumentException("Element is not present"));
//		System.out.println("secondSmallest1: "+second2);
//		
//		Integer secondSmallest1 =  emp2list.stream().map(val->val.getId()).sorted().distinct().skip(1).findFirst()
//					.orElseThrow(() -> new IllegalArgumentException("Second element is not present"));
//		System.out.println("secondSmallest1: "+secondSmallest1);
//		
//		int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
//		int[] a2 = {3, 4, 5, 6, 7, 8};
//		List<Integer> commonElement = Arrays.stream(a1)
//							.filter(value -> Arrays.stream(a2).anyMatch(value2 -> (value2==value)))
//							.distinct()
//							.mapToObj(x -> x)
//							.toList();
//		System.out.println("common element: "+ commonElement);
//
//		List<Integer> commonElement2 = Arrays.stream(a1)
//				.filter(value -> Arrays.stream(a2).anyMatch(value2 -> (value2==value)))
//				.distinct()
//				.boxed()
//				.toList();
//		System.out.println("common element 2: "+ commonElement2);
//		
//		final int length = a1.length-1;
//		IntStream.range(0, a1.length/2)
//				.forEach(i -> {
//					System.out.println("element:"+i);
//					a1[i] = a1[i] + a1[length - i];
//					a1[length - i] = a1[i] - a1[length - i];
//					a1[i] = a1[i] - a1[length - i];
//				});
//		Arrays.stream(a1).forEach(value -> System.out.print(" "+value));
//
//		System.out.println("");		
//		String[] sa = {"mlsm", "mlsm", "asjnadj", "mlsm", "asmkdmaks", "mlsm"};
//
//		Integer longestString = Arrays.stream(sa)
//										.mapToInt(String::length)
//										.max()
//										.orElseThrow((() -> new IllegalArgumentException("Longest string is not present")));
//		System.out.println("longestString: "+ longestString);
//		
//		String longestStringName = Arrays.stream(sa)
//										.max(Comparator.comparingInt(String::length))
//										.orElseThrow((() -> new IllegalArgumentException("Longest string is not present")));
//		System.out.println("longestStringName: "+ longestStringName);
//
//		//order may not preserved
//		List<String> a222 =  Arrays.stream(sa)
//				.distinct()
//				.toList();
//		System.out.println("a222: "+a222);
//		
//		List<String> uniqueList = Arrays.stream(sa)
//										.collect(Collectors.toCollection(LinkedHashSet::new))
//										.stream()
//										.collect(Collectors.toList());
//										//.toList();
//		System.out.println("uniqueList: "+uniqueList);
//										
//		
//	}
//	
//	private boolean isPresentInAnotherArray(int value) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	Optional<Employee2> findById() {
////		return null;
////		return Optional.of(new Employee2(3, "Name1", "Mumbai"));
//		return Optional.of(new Employee2(3, null, "Mumbai"));
//	}
//	
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
