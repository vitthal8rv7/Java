package com.learn.java.security.oauth2.google.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping("/home")
	public String homeOAuth2() {
		LOGGER.info("OAuth 2 tested successfully.");
		return "OAuth 2 tested successfully.";
	}

	@GetMapping("/ram")
	public String ramOAuth2() {
		LOGGER.info("OAuth 2 tested successfully.");
		return "OAuth 2 tested successfully......";
	}

}
