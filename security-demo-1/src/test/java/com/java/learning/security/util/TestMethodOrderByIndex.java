package com.java.learning.security.util;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Order(3)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMethodOrderByIndex {
    StringBuilder sb = new StringBuilder();

    @Order(1)
    @Test
    @DisplayName("TestD")
    void testIntegerDivide_whenEightDivideByTwo_shouldReturnTwo(TestInfo testInfo) {
        System.out.println("Test INFO: " + testInfo.getTestMethod().get().getName());
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.integerDivide(8, 2), () -> "8/2 should return 4. Failed.");
        sb.append("TestD");
    }

    @Order(3)
    @Test
    @DisplayName("TestA")
    void testIntegerDivide_whenEightDivideByZero_shouldThrowException() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.integerDivide(8, 0), () -> "8/2 should return 4. Failed.");
        sb.append("TestA");
    }

    @Order(2)
    @Test
    @DisplayName("TestC")
    void testIntegerDivide_whenEightDivideByTwo_shouldNotReturnThree() {
        Calculator calculator = new Calculator();
        assertNotEquals(3, calculator.integerDivide(8, 2), () -> "8/2 should return 4. Failed.");
        sb.append("TestC");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("SB: "+ sb);
    }

}
