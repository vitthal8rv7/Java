package com.learn.java.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.learn.java.security.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity//(debug = true)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class DatabaseBasedSecurityConfig {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
    public PasswordEncoder passwordEncoder;    

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/", "/registerUser/**", "/home").permitAll();
			request.requestMatchers("/user/**").hasRole("USER");
			request.requestMatchers("/user-specific-readonly").hasAnyAuthority("USER_READ");
			request.requestMatchers("/admin-specific").hasRole("ADMIN");
			request.requestMatchers("/update-api").hasAnyAuthority("ADMIN_WRITE",  "USER_WRITE");
			request.requestMatchers("/update-admin-api/**").hasAnyAuthority("ADMIN_WRITE");
			request.anyRequest().authenticated();
			
		});

		http.sessionManagement(session -> {
			session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//					.invalidSessionUrl("/invalidSession.html")
					.maximumSessions(100)
					.maxSessionsPreventsLogin(true)
					.expiredUrl("/expiredUrl.html");
			
		});
		
		http.formLogin();
//		http.formLogin(request -> {
//			request.loginPage("/login").permitAll();
//		});
//
//		http.logout(request -> {
//			request.permitAll();
//		});
		
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/ignore-request", "/thread-local", "/user", "/set/cookies",
				"/get/cookies-using-request-object", "/get/cookies-using-path-variables");
	}
    
    
    // Authentication Verification
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("auth: "+auth.toString());
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	
        auth.userDetailsService(userService)
            .passwordEncoder(passwordEncoder);
    }

}