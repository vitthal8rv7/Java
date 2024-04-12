package com.learn.java.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.learn.java.security.config.PropertyHolder;

import net.logstash.logback.util.StringUtils;

@SpringBootApplication
public class SpringSecurityApplication {

	@Autowired
	private PropertyHolder propertyHolder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // You can use any password encoder you prefer
		return PasswordEncoderFactories.createDelegatingPasswordEncoder(); // spring security 5.0
		// we can add our custom password encoder
		// check implementation code of above createDelegatingPasswordEncoder method for
		// reference.
	}

	@Bean
	public PasswordEncoder passwordEncoder2() {
		// we can add our custom password encoder
		// check implementation code of above createDelegatingPasswordEncoder method for
		// reference.
		String encoderType = null;
		encoderType = propertyHolder.getEncoder();
		System.out.println("---------------------------------------------------------encoderType: "+encoderType);
		return createDelegatingPasswordEncoder(encoderType); // spring security 5.0
	}

	public PasswordEncoder createDelegatingPasswordEncoder(String encodingId) {
		if (StringUtils.isBlank(encodingId)) {
			System.out.println("--------------------------------------------------------- encoderType is blank");
			encodingId = "bcrypt";
		}
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put(encodingId, new BCryptPasswordEncoder());
		encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
		encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
		encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
		encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
		encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5());
		encoders.put("pbkdf2@SpringSecurity_v5_8", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
		encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1());
		encoders.put("scrypt@SpringSecurity_v5_8", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
		encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
		encoders.put("SHA-256",
				new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
		encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
		encoders.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2());
		encoders.put("argon2@SpringSecurity_v5_8", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());
		return new DelegatingPasswordEncoder(encodingId, encoders);
	}

	public static void main(String[] args) {

//		System.out.println("p1: "+ new BCryptPasswordEncoder().encode("p1"));
//		System.out.println("p2: "+ new BCryptPasswordEncoder().encode("p2"));
//		System.out.println("p3: "+ new BCryptPasswordEncoder().encode("p3"));
//		p1: $2a$10$O0kdPzuVoI172n0dBdsf0OHRAMzdpwU8izzmOOxUPqTXd.CW5k91C
//		p2: $2a$10$RSuJuEWGqMno9/R0s4Wj5.lbL7XFB/VT1LsMmLBxVSOND8RxauiY2
//		p3: $2a$10$o3mCDX.QURdIf8qKGqqQc.f6K1RqKAIdHuK41a8zxZMLY2hOwKG7y

		SpringApplication.run(SpringSecurityApplication.class, args);

	}

}
