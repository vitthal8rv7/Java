package com.learn.java.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learn.java.redis.cache.CacheConstants;
import com.learn.java.redis.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HttpServletRequest request;

	@Cacheable(value = "getUserName", keyGenerator = CacheConstants.USER_SPECIFIC_KEY_GENERATOR)
	@Override
	public String getUserName() {
		System.out.println("In Get User Name Method.");
		return request.getHeader("userName");
	}

	@Cacheable(value = CacheConstants.USER_AND_LANG_SPECIFIC_KEY_GENERATOR, keyGenerator = CacheConstants.USER_AND_LANG_SPECIFIC_KEY_GENERATOR)
	@Override
	public String getUserNameInCurrentLang() {
		System.out.println("In Get getUserNameInCurrentLang Method.");
		return request.getHeader("userName")+request.getHeader("lang");
	}
}