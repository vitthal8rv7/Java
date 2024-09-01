package com.learn.java.junit5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.java.junit5.model.Employee;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Junit5DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws Exception {
		String response = restTemplate.getForObject("/get", String.class);
		assertEquals("Hello World!", response);
		//JSONAssert.assertEquals("{id:\"id\"}", response, false);
	}

	@Test
	void contextLoads2() throws Exception {
		Employee employee = restTemplate.getForObject("/employee", Employee.class);
		String response =  objectMapper.writeValueAsString(employee);
//		assertEquals("Hello World!", response);
		JSONAssert.assertEquals("{id:\"id\"}", response, false);
	}

}
