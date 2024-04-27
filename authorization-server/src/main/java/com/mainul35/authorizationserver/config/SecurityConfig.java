//package com.mainul35.authorizationserver.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.headers(hs -> {
//			hs.httpStrictTransportSecurity(hs2 -> {
//				hs2.maxAgeInSeconds(300000).includeSubDomains(true);
//			});
//
//		});
//
//		return http.build();
//	}
//}
