package com.learn.java.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry
@PropertySource("classpath:retryConfig.properties")
public class RetryConfig {

	
}
