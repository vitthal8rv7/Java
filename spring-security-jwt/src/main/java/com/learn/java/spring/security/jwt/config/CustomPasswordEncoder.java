package com.learn.java.spring.security.jwt.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.learn.java.spring.security.jwt.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import net.logstash.logback.util.StringUtils;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String encode(CharSequence rawPassword) {
		
		System.out.println("Before assigning new value: passwordEncoder = "+ passwordEncoder);
		
		passwordEncoder = createDelegatingPasswordEncoder("bcrypt");
		// Here we can set any password encoder at run time by suppling value from database/any other data source
//			encoderType = db.fetchEncoderType();
//			passwordEncoder = createDelegatingPasswordEncoder(encoderType);
		// or by adding condition by reading user password and check encode type
		
		
		System.out.println("After assigning new value: passwordEncoder = "+ passwordEncoder);
		
		
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		// Using encoded password we can get the type of encoder and using it we can create that kind of encoder at runtime.
		String subString = encodedPassword.subSequence(encodedPassword.indexOf('{')+1, encodedPassword.indexOf('}')).toString();
		System.out.println("");
		System.out.println("");
		System.out.println("------subString => ENCODER TYPE: "+ subString);
		//USING THIS CREATE NEW ENCODER AND USE IT TO MATCH THE PASSWORD
		passwordEncoder = createDelegatingPasswordEncoder(subString);
		
		System.out.println("");
		System.out.println("");
		return passwordEncoder.matches(rawPassword, encodedPassword);
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
		encoders.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());
		encoders.put("argon2@SpringSecurity_v5_8", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());
		return new DelegatingPasswordEncoder(encodingId, encoders);
	}
}
