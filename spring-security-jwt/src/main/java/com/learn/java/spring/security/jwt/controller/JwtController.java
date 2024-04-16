package com.learn.java.spring.security.jwt.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.spring.security.jwt.model.request.AuthRequest;
import com.learn.java.spring.security.jwt.model.response.AuthResponse;
import com.learn.java.spring.security.jwt.service.UserService;
import com.learn.java.spring.security.jwt.util.JwtUtil;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class JwtController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtController.class);
	
//	@Autowired
//	private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

//    @Autowired
//    private SessionRegistry sessionRegistry;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		

		try {
			final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
			final String jwt = jwtUtil.generateToken(userDetails.getUsername());
			LOGGER.info("JWT" + jwt);
			return ResponseEntity.ok(new AuthResponse(jwt));	
		} catch(Exception e) {
			LOGGER.error("Exception: []"+ e.getMessage());
		}
		return ResponseEntity.ok(new AuthResponse("Wrong"));
	}
 

	@GetMapping("/registerUser")
	public String registerUser(@RequestBody AuthRequest authRequest) { //(@RequestParam(required = true, name = "userName") String userName,
			//@RequestParam(required = true, name = "password") String password) {
		userService.registerUser(authRequest.getUsername(), authRequest.getPassword());
		return "userRegistered";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login-form";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/")
	public String root() {
		return "root";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
