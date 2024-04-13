package com.learn.java.security.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.java.security.config.PropertyHolder;
import com.learn.java.security.model.entity.User;
import com.learn.java.security.repository.UserRepository;
import com.learn.java.security.service.ThreadLocalService;
import com.learn.java.security.service.UserService;
import com.learn.java.security.util.ThreadLocalUtilityService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PropertyHolder propertyHolder;
	
	@Autowired
    public PasswordEncoder passwordEncoder;    

	@Autowired
	private ThreadLocalService threadLocalService;

	@Autowired
	private ThreadLocalUtilityService threadLocalUtilityService;

	// Reset Password API (forgot password)
	// Before reseting user password, send OTP Or URL with token to confirm that given information 
	// like number mail is user`s valid information to do that send OTP/URL with Token to user`s number or mail
	// validate it and hitting validation API
	// after successful confirmation reset user password and redirect to login page, else send appropriate exception message.

	
	
	//	@PreAuthorize("hasRole('ADMIN')") //if the requirement is service specific then apply to interface 
	// else if the requirement is implementation specific then apply to implementation class
	@Override
	public void registerUser(String userName, String password) {
//		String password = "p11";
		String salting = BCrypt.gensalt();
		String peppering = propertyHolder.getPeppering();
//		password = passwordEncoder.encode(password);		
		password = passwordEncoder.encode(password+salting+peppering);

		
		// Before saving/registering user, send OTP Or URL with token to confirm that given information 
		// like number mail is user`s valid information to do that send OTP/URL with Token to user`s number or mail
		// validate it and hitting validation API
		// after successful confirmation register user, else send appropriate exception message.
		User user = userRepository.save(User.builder()
				.userName(userName)
				.roles(Arrays.asList("USER", "ADMIN"))
				.authorities(Arrays.asList("USER_READ", "ADMIN_READ", "USER_WRITE", "ADMIN_WRITE"))
				.password(password)
				.salt(salting)
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

	@PostFilter("filterObject != authentication.principal.username")
	@Override
	public List<String> postFilterTest1(List<String> asList) {
		return asList;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername: "+username);
		User user = userRepository.findByUserNameIgnoreCase(username);
		if(Objects.isNull(user)) {
			System.out.println("USER NOT FOUND");
			return null;
		}
		String[] roles = new String[user.getRoles().size()];
		for(int i = 0; i < user.getRoles().size(); i++) {
			roles[i] = user.getRoles().get(i);
		}

		
		String[] authorities = new String[user.getAuthorities().size()];
		for(int i = 0; i < user.getAuthorities().size(); i++) {
			authorities[i] = user.getAuthorities().get(i);
		}
		
		UserDetails userDetails =
		 org.springframework.security.core.userdetails.User
			.withUsername(user.getUserName())
			.password(user.getPassword())
			.authorities(authorities)
			.roles(roles)
			.username(user.getUserName())
			.build();
		return userDetails;
	}

	@Override
	public void threadLocal() {
		threadLocalService.printThreadLocals();
		threadLocalService.updateThreadLocals();
		threadLocalService.printThreadLocals();
		threadLocalUtilityService.getT1().set(111L);
		threadLocalService.printThreadLocals();
		
	}

	@Override
	public User getUser() {
		threadLocalUtilityService.getT1().set(System.currentTimeMillis());
		User user = userRepository.findByUserNameIgnoreCase("u22");
		threadLocalUtilityService.getT2().set(System.currentTimeMillis());
		return user;
	}
}
