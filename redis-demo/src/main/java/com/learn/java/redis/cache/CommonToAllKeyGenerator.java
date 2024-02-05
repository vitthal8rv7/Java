package com.learn.java.redis.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class CommonToAllKeyGenerator implements KeyGenerator{

	@Override
	public Object generate(Object target, Method method, Object... params) {
        // Custom logic to generate a Redis cache key based on the method and its parameters
		StringBuilder key = new StringBuilder();
//        key.append(target.getClass().getSimpleName()).append(":");
//        key.append(method.getName()).append(":");
//        for (Object param : params) {
//            key.append(param).append(":");
//        }
        key.append(commonKeyGenerator());
        return key.toString();
	}

	private Object commonKeyGenerator() {
		return "ABC_Z_Company_Key_Generator";
	}

}
