package com.learn.java.rest.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Bean
	RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	
	@Bean
	RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder
				.setReadTimeout(Duration.ofMillis(1000))     // Set, how many time unit it will wait for response
				.setConnectTimeout(Duration.ofMillis(10000)) // Set, how many time unit it will wait for connection
				.build();
	}

 }
