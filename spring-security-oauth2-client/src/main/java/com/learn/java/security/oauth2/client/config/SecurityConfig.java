package com.learn.java.security.oauth2.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.learn.java.security.oauth2.client.service.OAuth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public OAuth2UserService oAuth2UserService;
	
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
//		http.oauth2Login(Customizer.withDefaults());
		http.oauth2Login(oauth2 -> {
			oauth2.userInfoEndpoint(infoEndpoint -> {
				infoEndpoint.userService(oAuth2UserService);
			});
		});
		return http.build();
	}

}
