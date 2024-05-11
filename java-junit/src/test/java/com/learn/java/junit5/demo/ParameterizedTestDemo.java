package com.learn.java.junit5.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestDemo {

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		assertTrue(isPalindrome(candidate));
	}

	@ParameterizedTest
	@ValueSource(classes = { String.class, Number.class, File.class })
	void isChildOfObject(Class type) {
		assertTrue(isStorageClass(type));
	}

	private BooleanSupplier isStorageClass(Class type) {
		return () -> {
//			System.out.println("type.getClass().getName(): " + type.getName());
			if (type.getName().equals("java.lang.String") 
					|| type.getName().equals("java.lang.Number")
					|| type.getName().equals("java.io.File")) {
				return true;
			}
			return false;
		};
	}

	private Boolean isPalindrome(String candidate) {
		return candidate.equals(StringUtils.reverse(candidate));
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void testWithValueSource(int argument) {
		assertFalse(argument > 10);
	}


	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithSimpleMethodSource(String argument) {
		assertThat(argument).hasSize(3);
	}

	static Stream<String> stringProvider() {
		return Stream.of("foo", "bar");
	}

	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
		assertEquals(3, str.length());
		assertTrue(num >= 1 && num <= 2);
		assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
		return Stream.of(Arguments.of("foo", 1, Arrays.asList("a", "b")),
				Arguments.of("bar", 2, Arrays.asList("x", "y")));
	}

	@ParameterizedTest
	@CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
	void testWithCsvSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}
/*	
	Example Input Resulting Argument List
	@CsvSource({ "foo, bar" }) "foo", "bar"
	@CsvSource({ "foo, 'baz, qux'" }) "foo", "baz, qux"
	@CsvSource({ "foo, ''" }) "foo", ""
	@CsvSource({ "foo, " }) "foo", null
*/
	
	@ParameterizedTest
	@CsvFileSource(resources = "/two-column.csv")
	void testWithCsvFileSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}	
	
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(String argument) {
		assertNotNull(argument);
//		assertEquals("foo", argument);
	}

	static class MyArgumentsProvider implements ArgumentsProvider {
		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
			return Stream.of("foo", "bar").map(Arguments::of);
		}
	}
}
