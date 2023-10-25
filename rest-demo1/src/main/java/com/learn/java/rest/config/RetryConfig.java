package com.learn.java.rest.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.learn.java.rest.service.DefaultListenerSupport;

@Configuration
@EnableRetry
@PropertySource("classpath:retryConfig.properties")
public class RetryConfig {

	@Bean
	@Qualifier(value = "retryTemplate")
	RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();

		FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
		fixedBackOffPolicy.setBackOffPeriod(2000l);
		retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(4);
		retryTemplate.setRetryPolicy(retryPolicy);

		//retryTemplate.registerListener(new DefaultListenerSupport());
		
		return retryTemplate;
	}
	
	@Bean
	@Qualifier(value = "retryTemplateWithListener")
	RetryTemplate retryTemplateWithListener() {
		RetryTemplate retryTemplate = new RetryTemplate();

		FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
		fixedBackOffPolicy.setBackOffPeriod(2000l);
		retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(2);
		retryTemplate.setRetryPolicy(retryPolicy);

		retryTemplate.registerListener(new DefaultListenerSupport());
		
		return retryTemplate;
	}
}
