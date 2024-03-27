package com.learn.java.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		
//		System.out.println(""+ new BCryptPasswordEncoder().encode("password1"));
//		$2a$10$czKLroWcWHEF3ZQH4LiYkusUCDIv0rf5aqK5qAYHA9a/eSObVTtbK 
		
//		System.out.println(""+ new BCryptPasswordEncoder().encode("password2"));
//		$2a$10$RGYVyLz8tEdvUSmo9d1gUuG.ZyBdcXdvUuVfpGwggwmkOLgjIBlOO
		
//		System.out.println(""+ new BCryptPasswordEncoder().encode("password3"));
//		$2a$10$qZhZY5ZypIb0PiKf9fW8gOEhMMH22ym/ljJPGJmT1S3IUjkkoe9cW
		SpringApplication.run(SpringSecurityApplication.class, args);
		
		
	}

}
