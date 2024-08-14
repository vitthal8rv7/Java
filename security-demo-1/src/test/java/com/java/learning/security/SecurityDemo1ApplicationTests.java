package com.java.learning.security;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Order(2)
@SpringBootTest
class SecurityDemo1ApplicationTests {


	@Test
	void contextLoads() {
		System.out.println("Test Pass?");
	}

}
