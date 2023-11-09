package com.learn.java.swagger.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Component
public class SpringFoxConfig {

	@Bean
	Docket api() {
		List<Response> list = new ArrayList<Response>();
		list.add(new ResponseBuilder().code("500").description("500 message").build());
		list.add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).globalResponses(HttpMethod.GET, list)
.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	@Bean
	ApiInfo apiInfo() {
		
		
		return new ApiInfo("My REST API", "Some Custom Description Of API", "API LIST", "Terms Of Service",
				new Contact("John Doe", "www.example.com", "myeaddress@company.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

}