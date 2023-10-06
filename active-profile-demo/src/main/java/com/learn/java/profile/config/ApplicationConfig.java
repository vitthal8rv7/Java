package com.learn.java.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learn.java.profile.model.MyDataSource;

@Configuration
@Profile({ "dev", "prod" })
public class ApplicationConfig {

	@Profile("dev")
	@Bean("devDataSource")
	MyDataSource devDataSource() {
		return new MyDataSource("Dev");
	}
	
	@Profile("prod")
	@Bean("prodDataSource")
	MyDataSource prodDataSource() {
		return new MyDataSource("Prod");
	}

}



