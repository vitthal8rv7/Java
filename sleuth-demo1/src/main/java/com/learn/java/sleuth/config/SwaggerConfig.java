package com.learn.java.sleuth.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {


    @Bean
     GroupedOpenApi publicOpenAPI() {
        return GroupedOpenApi.builder().group("public-apis").pathsToMatch("/**").build();
    }
    
    @Bean
    OpenAPI customOpenApi() {
    	return new OpenAPI().info(new Info().title("T1").version("V1"));
    }
    
}