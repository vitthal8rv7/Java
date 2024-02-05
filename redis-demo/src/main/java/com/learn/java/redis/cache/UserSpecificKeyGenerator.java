package com.learn.java.redis.cache;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class UserSpecificKeyGenerator implements KeyGenerator{

    @Autowired
    private HttpServletRequest request;

	@Override
	public Object generate(Object target, Method method, Object... params) {
        // Custom logic to generate a Redis cache key based on the method and its parameters
		StringBuilder key = new StringBuilder();
//        key.append(target.getClass().getSimpleName()).append(":");
//        key.append(method.getName()).append(":");
//        for (Object param : params) {
//            key.append(param).append(":");
//        }
        key.append(userSpecificKeyGenerator());
        return key.toString();
	}

	private Object userSpecificKeyGenerator() {
		return request.getHeader("userName")+":"+request.getHeader("userId");
	}

}
