package com.learn.java.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // You can use any password encoder you prefer
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
