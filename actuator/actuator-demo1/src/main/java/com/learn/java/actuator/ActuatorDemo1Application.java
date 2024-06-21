package com.learn.java.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class ActuatorDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorDemo1Application.class, args);
	}

	@Bean
	public InMemoryAuditEventRepository repository(){
		
	 return new InMemoryAuditEventRepository();
	}
}
