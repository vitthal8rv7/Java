package com.learn.java.junit5.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;

public class MongoUtilityTest {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MongoUtilityTest.class);
	
	@BeforeAll
	static void init() {
		LOGGER.info("Executed before all tests.");
	}
	
	@AfterAll
	static void cleanUp() {
		LOGGER.info("Executed after all tests.");
	}
	
	@BeforeEach
	void setup() {
		LOGGER.info("Initializing before each tests.");
	}

	@AfterEach
	void tearDown() {
		LOGGER.info("Cleaning up after each tests.");
	}
	@Test
	void testDemo() {
		LOGGER.info("This test is created for demo purpose.");
		assertTrue(true);
	}
	
	
	@Test
	void isStringNotEmptyTest() {
		LOGGER.info("This test is test isStringNotEmpty method.");
		assertTrue(MongoUtility.isStringNotEmpty("notEmpty"));
		assertFalse(MongoUtility.isStringNotEmpty(""));
		assertFalse(MongoUtility.isStringNotEmpty(" "));
		assertFalse(MongoUtility.isStringNotEmpty(null));
	}
	
	@Test
	void isFloatNotEmptyTest() {
		LOGGER.info("This test is test isFloatNotEmpty method.");
		assertTrue(MongoUtility.isFloatNotEmpty(5.6f));
		assertFalse(MongoUtility.isFloatNotEmpty(null));
	}

	@Test
	void isCriteriaNotEmptyTest() {
		LOGGER.info("This test is test isCriteriaNotEmpty method.");
		List<Criteria> criterias = new ArrayList<>();
		assertFalse(MongoUtility.isCriteriaNotEmpty(criterias));
		criterias.add(new Criteria().andOperator(Criteria.where("salary").lt(12)));
		assertTrue(MongoUtility.isCriteriaNotEmpty(criterias));
		criterias = null;
		assertFalse(MongoUtility.isCriteriaNotEmpty(null));
	}

}
