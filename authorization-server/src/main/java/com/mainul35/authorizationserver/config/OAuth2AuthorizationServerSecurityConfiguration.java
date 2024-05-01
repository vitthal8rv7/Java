//package com.mainul35.authorizationserver.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
//
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////	@Bean
////	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http.headers(hs -> {
////			hs.httpStrictTransportSecurity(hs2 -> {
////				hs2.maxAgeInSeconds(300000).includeSubDomains(true);
////			});
////
////		});
////
////		return http.build();
////	}
////}
//
////@Configuration
////public class OAuth2AuthorizationServerSecurityConfiguration {
////
////	@Bean
////	@Order(1)
////	public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
////		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
////		return http.build();
////	}
////	
////}
