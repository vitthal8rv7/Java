package com.learn.java.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SleuthDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SleuthDemo1Application.class, args);
	}

}
