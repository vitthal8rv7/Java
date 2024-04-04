package com.learn.java.security.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

	@Bean
	public ServletListenerRegistrationBean<SessionTracker> sessionListener() {
		return new ServletListenerRegistrationBean<>(new SessionTracker());
	}

}
