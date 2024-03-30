package com.learn.java.security.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.java.security.config.PropertyHolder;
import com.learn.java.security.model.entity.User;
import com.learn.java.security.repository.UserRepository;
import com.learn.java.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PropertyHolder propertyHolder;
	
//	@PreAuthorize("hasRole('ADMIN')") //if the requirement is service specific then apply to interface 
	// else if the requirement is implementation specific then apply to implementation class
	@Override
	public void registerUser() {
		String password = "pass@user@123";
		String salting = BCrypt.gensalt();
		String peppering = propertyHolder.getPeppering();
		
		password = passwordEncoder.encode(""+password+salting+peppering);
		
		User user = userRepository.save(User.builder()
				.userName("user_123")
				.roles(Arrays.asList("USER", "ADMIN"))
				.authorities(Arrays.asList("USER_READ", "ADMIN_READ", "USER_WRITE", "ADMIN_WRITE"))
				.password(password)
				.build());
		System.out.println("User: "+user);		
	}

	@Override
	public void testEnableMethodSecurity() {
		preAuthorizeTest1();
//		preAuthorizeTest1("");
//		preAuthorizeTest1("", "");
//		preAuthorizeTest1(list);
//		preAuthorizeTest1(list1, list2);
		
	}

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void preAuthorizeTest1() {
		System.out.println("@PreAuthorize hasRole('ADMIN')");
		
	}
	
	@PreAuthorize("#userName != authentication.principal.username")
	@Override
	public void preAuthorizeTest2(String userName) {
		System.out.println("#userName == authentication.principal.username");
		
	}

	@PostAuthorize("returnObject.username == authentication.principal.username")
	@Override
	public org.springframework.security.core.userdetails.User postAuthorizeTest1() {
		org.springframework.security.core.userdetails.User user =  (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user: "+user);
		return user;

		
	}

	@Secured("ROLE_USER")
	@Override
	public void secureMethod1() {
		System.out.println("inside secureMethod1: true");
		
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@Override
	public void secureMethod2(String userName) {
		System.out.println("inside secureMethod2: true");
		
	}

	@PreFilter("filterObject == authentication.principal.username")
	@Override
	public void preFilterTest1(List<String> asList) {
		System.out.println("inside preFilterTest1: true");
		
	}
	
	@PreFilter(value = "filterObject != authentication.principal.username", filterTarget = "asList2")
	@Override
	public void preFilterTest2(List<String> asList, List<String> asList2) {
		System.out.println("inside preFilterTest2: true");
		
	}
}
