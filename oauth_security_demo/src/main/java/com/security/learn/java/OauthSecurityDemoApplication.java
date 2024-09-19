package com.security.learn.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class OauthSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthSecurityDemoApplication.class, args);
	}

}
