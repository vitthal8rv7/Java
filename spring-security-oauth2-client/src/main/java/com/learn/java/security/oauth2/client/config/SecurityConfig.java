package com.learn.java.security.oauth2.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers("/", "/registerUser/**", "/home").permitAll();
			authorize.anyRequest().authenticated();
		});

		http.sessionManagement(session -> {
			session.sessionFixation().newSession();
			session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//					.invalidSessionUrl("/invalidSession.html")
					.maximumSessions(2)
					.maxSessionsPreventsLogin(true)
					.expiredUrl("/expiredUrl.html");

		});
		http.oauth2Client(Customizer.withDefaults());
		http.oauth2Login(Customizer.withDefaults());
		return http.build();
	}

}
