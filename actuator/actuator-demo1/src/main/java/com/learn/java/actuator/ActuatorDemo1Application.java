package com.learn.java.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActuatorDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorDemo1Application.class, args);
	}

	@Bean
	public InMemoryAuditEventRepository repository(){
		
	 return new InMemoryAuditEventRepository();
	}
}
