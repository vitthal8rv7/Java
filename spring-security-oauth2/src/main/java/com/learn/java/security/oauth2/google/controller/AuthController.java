package com.learn.java.security.oauth2.google.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@GetMapping("")
	public String authenticated(Authentication authentication) {
		try {

//			LOGGER.info("OAuth 2 tested successfully." + authentication.getPrincipal());
			System.out.println("0");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("1");
			LOGGER.info("oauth : " + auth.toString());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return "OAuth 2 tested successfully.";
	}

	@GetMapping("/home")
	public String homeOAuth2() {
		LOGGER.info("OAuth 2 tested successfully.");
		return "OAuth 2 tested successfully.2";
	}

	@GetMapping("/home/ram")
	public String ramOAuth2() {
		LOGGER.info("OAuth 2 tested successfully.");
		return "OAuth 2 tested successfully......3";
	}

}
