package com.learn.java.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.security.config.SessionTracker;
import com.learn.java.security.service.UserService;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class AuthController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	
//	@Autowired
//	private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

    @Autowired
    private SessionRegistry sessionRegistry;

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/test/enable-method-security")
	public String testEnableMethodSecurity() {
//		userService.testEnableMethodSecurity();
//		userService.preAuthorizeTest1();
		String username = "u1";
		User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.getUsername();
		System.out.println("username: "+username);
		userService.preAuthorizeTest2("u1");
		
//		userService.postAuthorizeTest1();
		
//		userService.secureMethod1();
//		userService.secureMethod2("u1");
		
//		userService.preFilterTest1(Arrays.asList("u1", "u3"));
//		userService.preFilterTest2(Arrays.asList("u1", "u3"), Arrays.asList("u1", "u2"));
//		userService.postFilterTest1(Arrays.asList("u1", "u3"));
		return "tested enable-method-security";
	}

	
	@GetMapping("/registerUser")
	public String registerUser(@RequestParam(required = true, name = "userName") String userName,
			@RequestParam(required = true, name = "password") String password) {
		userService.registerUser(userName, password);
		return "userRegistered";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login-form";
	}
	
	@GetMapping("/ignore-request")
	public String ignoreRequest() {
		return "ignore-request using webSecurityCustomizer";
	}
	
	@GetMapping("/")
	public String root() {
		return "root";
	}
	
	@GetMapping("/home")
	public String home() {
		LOGGER.info("INSIDE CONTROLLER.");
		return "HomePage";
	}
	
	@GetMapping("/thread-local")
	public String threadLocal() {
		userService.threadLocal();
		return "thread-local";
	}
	
	@GetMapping("/user")
	public com.learn.java.security.model.entity.User getUser() {
		LOGGER.info("INSIDE CONTROLLER.");
		com.learn.java.security.model.entity.User user = userService.getUser();
		return user;
	}

	@GetMapping("/set/cookies")
	public String setCookies(HttpServletResponse response) {
		
		Cookie cookie = new Cookie("userName", "RAM-1");
		cookie.setMaxAge(600);
		cookie.setPath("/");
		cookie.setDomain("localhost");
		cookie.setHttpOnly(true);
		cookie.setSecure(true);		
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("Authorization", "RAM-2-Auth-Token");
		cookie2.setMaxAge(600);
		cookie2.setPath("/");
		cookie2.setDomain("localhost");		
		cookie2.setHttpOnly(true);
		cookie2.setSecure(true);
		response.addCookie(cookie2);
		
		
		
		
		return "tested set cookies";
	}

	@GetMapping("/get/cookies-using-request-object")
	public String setCookies(HttpServletRequest request) {
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		cookies.stream().forEach(cookie -> {
			LOGGER.info("cookie name:"+ cookie.getName() + " \tcookie value:"+ cookie.getValue());
		});
		return "tested get cookies";
	}

	@GetMapping("/get/cookies-using-path-variables")
	public String setCookies(@CookieValue(name = "userName", defaultValue = "Unknown") String userName, @CookieValue(name = "Authorization", defaultValue = "Unknown") String authorization) {
			LOGGER.info("cookie name: userName " + " \tcookie value:"+ userName);
			LOGGER.info("cookie name: Authorization " + " \tcookie value:"+ authorization);
		return "tested get cookies";
	}

	
	@GetMapping("/get-session2")
	public String getSession2(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		cookies.stream().forEach(cookie -> {
			if(cookie.getName().equalsIgnoreCase("JSESSIONID")) {
				LOGGER.info("same cookie name:"+ cookie.getName() + " \tcookie value:"+ cookie.getValue());
			} else {
				LOGGER.info("cookie name:"+ cookie.getName() + " \tcookie value:"+ cookie.getValue());	
			}
		});
		System.out.println("");
		LOGGER.info("Session Id: []"+ session.getAttribute("JSESSIONID"));
		LOGGER.info("session.getAttributeNames().toString(): []"+ session.getAttributeNames().toString());
		
		System.out.println("");
		return "tested getSession: "+session.getAttribute("JSESSIONID");
	}
	
	
	@GetMapping("/set-session")
	public String setSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		LOGGER.info("Session Id: []"+ session.getId());
		LOGGER.info("session.getAttribute(\"JSESSIONID\"): []"+ session.getAttribute("JSESSIONID"));
		session.setAttribute("JSESSIONID", session.getId());
		return "tested setSession: "+session.getAttribute("JSESSIONID");
	}
	
	@GetMapping("/get-session")
	public String getSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		LOGGER.info("Session Id: []"+ session.getId());
		
		String sessionId = (String) session.getAttribute("JSESSIONID");
		if(StringUtils.isNotBlank(sessionId)) {
			System.out.println("");
			LOGGER.info("Session Id: []"+ sessionId);
			System.out.println("");					
		} else {
			 return "Session not set!";
		}
		
		return "tested getSession: "+sessionId;
	}
	
	@GetMapping("/update-session")
	public String updateSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		LOGGER.info("Session Id: []"+ session.getId());
		session.setAttribute("JSESSIONID", "NEW_"+session.getId());
		return "tested updateSession: "+session.getAttribute("JSESSIONID");
	}
	
	@GetMapping("/invalidate-session")
	public String invalidateSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(!Objects.isNull(session)) {
			session.invalidate();
			return "Session invalidated successfully!";
		} else {
			return "No session to invalidate!";
		}
	}
	
	

	
	@GetMapping("/list-all-sessions/sol-1")
	public String listAllSessionsSol1(HttpServletRequest request, HttpServletResponse response) {
		
		
		 List<SessionInformation> sessions = new ArrayList<>();
		 sessionRegistry.getAllPrincipals()
		 	.stream()
		 		.forEach(principal -> 
		 			sessions.addAll(sessionRegistry.getAllSessions(principal, false))
		 		);		 
		List<String> sessionIds = sessions.stream().map(session -> session.getSessionId()).collect(Collectors.toList());
		LOGGER.info("sessionIds : "+sessionIds);
		return "tested listAllSessionsSol1";
	}
	
	
	
	@GetMapping("/list-all-sessions/sol-2")
	public String listAllSessionsSol2(HttpServletRequest request, HttpServletResponse response) {
		
		Set<String> sessionIds = SessionTracker.getActiveSessions();
		LOGGER.info("sessionIds : "+sessionIds);
		return "tested listAllSessionsSol2";
	}
	
	

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/user-specific")
	public String userSpecific() {
		return "user-specific";
	}
	
	@GetMapping("/user-specific-readonly")
	public String userSpecificReadonly() {
		return "user-specific-readonly";
	}
	
	@GetMapping("/admin-specific")
	public String adminSpecific() {
		return "admin-specific";
	}
	

	@GetMapping("/update-api")
	public String updateApi() {
		return "update-api";
	}

}
