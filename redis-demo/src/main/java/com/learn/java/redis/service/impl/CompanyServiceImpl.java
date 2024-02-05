package com.learn.java.redis.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learn.java.redis.cache.CacheConstants;
import com.learn.java.redis.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	
	@Cacheable(value = "getCompanyName", keyGenerator = CacheConstants.COMMON_TO_ALL_KEY_GENERATOR)
	@Override
	public String getCompanyName() {
		System.out.println("In Get Company Name Method.");
		return "ABC_Z Company";
	}
}