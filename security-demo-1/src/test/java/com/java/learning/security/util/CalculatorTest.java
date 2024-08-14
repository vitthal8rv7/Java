package com.java.learning.security.util;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Order(1)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    @Test
    @DisplayName("4/2 = 2")
    void testIntegerDivide_whenEightDivideByTwo_shouldReturnTwo(TestInfo testInfo) {
        System.out.println("Test INFO: " + testInfo.getTestMethod().get().getName());
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.integerDivide(8, 2), () -> "8/2 should return 4. Failed.");
    }

    @Disabled("TODO: Still need to work on this test case.")
    @Test
    @DisplayName("4/2 != 3")
    void testIntegerDivide_whenEightDivideByTwo_shouldNotReturnThree() {
        Calculator calculator = new Calculator();
        assertNotEquals(3, calculator.integerDivide(8, 2), () -> "8/2 should return 4. Failed.");
    }

    @Test
    @DisplayName("4/0 ==> Excepption")
    void testIntegerDivide_whenEightDivideByZero_shouldThrowException() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.integerDivide(8, 0), () -> "8/2 should return 4. Failed.");
    }


    @ParameterizedTest
//    @MethodSource("parameterizedTestIntegerDivideParameters")
    @MethodSource() //if Method name same, then no need to mention method name in @MethodSource()
    @DisplayName("ParameterizedTest_MethodSource 4/2 = 2")
    void parameterizedTestIntegerDivide_whenEightDivideByTwo_shouldReturnTwo(int a, int b, int c) {
        Calculator calculator = new Calculator();
        assertEquals(c, calculator.integerDivide(a, b), () -> "8/2 should return 4. Failed.");
    }

//    private static Stream<Arguments> parameterizedTestIntegerDivideParameters() {
//        return Stream.of(
//                Arguments.of(8, 2, 4),
//                Arguments.of(16, 4, 4),
//                Arguments.of(22, 11, 2),
//                Arguments.of(222, 2, 11)
//        );
//    }

    private static Stream<Arguments> parameterizedTestIntegerDivide_whenEightDivideByTwo_shouldReturnTwo() {
        return Stream.of(Arguments.of(8, 2, 4), Arguments.of(16, 4, 4), Arguments.of(22, 11, 2), Arguments.of(222, 2, 111));
    }

    @ParameterizedTest
    @CsvSource({"8, 2, 4", "16, 4, 4", "22, 11, 2", "222, 2, 111"})
    @DisplayName("ParameterizedTest_ScvSource 4/2 = 2")
    void parameterizedTest_CsvSource_IntegerDivide_whenEightDivideByTwo_shouldReturnTwo(int a, int b, int c) {
        Calculator calculator = new Calculator();
        assertEquals(c, calculator.integerDivide(a, b), () -> "8/2 should return 4. Failed.");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ada.csv")
    @DisplayName("ParameterizedTest_ScvFileSource 4/2 = 2")
    void parameterizedTest_CsvFileSource_IntegerDivide_whenEightDivideByTwo_shouldReturnTwo(int a, int b, int c) {
        Calculator calculator = new Calculator();
        assertEquals(c, calculator.integerDivide(a, b), () -> "8/2 should return 4. Failed.");
    }


    @RepeatedTest(3)
    @DisplayName("RepeatedTest 4/2 = 2")
    void repeatedTest_IntegerDivide_whenEightDivideByTwo_shouldReturnTwo(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("RepeatedTest INFO: current repetition: " + repetitionInfo.getCurrentRepetition());
        System.out.println("RepeatedTest INFO: total repetition: " + repetitionInfo.getTotalRepetitions());
        System.out.println("Test INFO: " + testInfo.getTestMethod().get().getName());

        Calculator calculator = new Calculator();
        assertEquals(4, calculator.integerDivide(8, 2), () -> "8/2 should return 4. Failed.");
    }

    @RepeatedTest(value = 3, name = "{currentRepetition} of {totalRepetitions} repeatation of {displayName}. ")
    @DisplayName("RepeatedTest 4/2 = 2")
    void repeatedTest2_IntegerDivide_whenEightDivideByTwo_shouldReturnTwo(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("RepeatedTest INFO: current repetition: " + repetitionInfo.getCurrentRepetition());
        System.out.println("RepeatedTest INFO: total repetition: " + repetitionInfo.getTotalRepetitions());
        System.out.println("Test INFO: " + testInfo.getTestMethod().get().getName());

        Calculator calculator = new Calculator();
        assertEquals(4, calculator.integerDivide(8, 2), () -> "8/2 should return 4. Failed.");
    }
}