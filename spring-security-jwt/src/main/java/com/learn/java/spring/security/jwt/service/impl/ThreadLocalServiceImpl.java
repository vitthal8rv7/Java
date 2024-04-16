package com.learn.java.spring.security.jwt.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.spring.security.jwt.service.ThreadLocalService;
import com.learn.java.spring.security.jwt.util.ThreadLocalUtilityService;

@Service
public class ThreadLocalServiceImpl implements ThreadLocalService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadLocalServiceImpl.class);

	@Autowired
	private ThreadLocalUtilityService threadLocalUtilityService;

	@Override
	public void updateThreadLocals() {
		ThreadLocal<Long> t1 = threadLocalUtilityService.getT1();
		t1.set(11L);
		
		ThreadLocal<Long> t2 = threadLocalUtilityService.getT2();
		t2.set(22L);

		ThreadLocal<Long> t3 = threadLocalUtilityService.getT3();
		t3.set(33L);

		ThreadLocal<Long> t4 = threadLocalUtilityService.getT4();
		t4.set(44L);

		
	}

	@Override
	public void printThreadLocals() {
		ThreadLocal<Long> t1 = threadLocalUtilityService.getT1();
		ThreadLocal<Long> t2 = threadLocalUtilityService.getT2();
		ThreadLocal<Long> t3 = threadLocalUtilityService.getT3();
		ThreadLocal<Long> t4 = threadLocalUtilityService.getT4();
		
		LOGGER.info("T1: "+t1.get());
		LOGGER.info("T2: "+t2.get());
		LOGGER.info("T3: "+t3.get());
		LOGGER.info("T4: "+t4.get());
	}

}
