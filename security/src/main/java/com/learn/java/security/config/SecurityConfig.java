package com.learn.java.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity//(debug = true)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/", "/home").permitAll();
			request.requestMatchers("/user/**").hasRole("USER");
			request.requestMatchers("/user-specific-readonly").hasAnyAuthority("USER_READ");
			request.requestMatchers("/admin-specific").hasRole("ADMIN");
			request.requestMatchers("/update-api").hasAnyAuthority("ADMIN_WRITE",  "USER_WRITE");
			request.requestMatchers("/update-admin-api/**").hasAnyAuthority("ADMIN_WRITE");
			request.anyRequest().authenticated();
		});

		http.sessionManagement(session -> {
			session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
					.invalidSessionUrl("/invalidSession.html")
					.maximumSessions(1)
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
        return (web) -> web.ignoring().requestMatchers("/ignore-request");
    }

    
    
    // Authentication Verification
//    @Autowired

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // You can use any password encoder you prefer
    }

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User
				.withUsername("u1")
				.password("$2a$10$O0kdPzuVoI172n0dBdsf0OHRAMzdpwU8izzmOOxUPqTXd.CW5k91C")
				.authorities("USER_READ")
				.roles("USER") 
				.build();
		
		
		/*
		 		WHY ?
		 		
		 		When you apply ROLES, Spring Security consider ROLES
				When you apply AUTHORITIES, Spring Security consider AUTHORITIES
				When you apply ROLES and AUTHORITIES, Spring Security consider AUTHORITIES ONLY. NOT ROLES
				When you apply AUTHORITIES and ,ROLES  Spring Security consider ROLES ONLY. NOT AUTHORITIES 
				
				that means Spring Security consider last applied value between ROLES and AUTHORITIES
				
			==>	SPRING SECURITY SHOULD CONSIDER BOTH ROLES AND AUTHORITIES........
		*/
		
		
		UserDetails user2 =
				 User
					.withUsername("u2")
					.password("$2a$10$RSuJuEWGqMno9/R0s4Wj5.lbL7XFB/VT1LsMmLBxVSOND8RxauiY2")
					.authorities("ADMIN_READ")
					.roles("ADMIN")
					.build();
		
		UserDetails user3 =
				 User
					.withUsername("u3")
					.password("$2a$10$o3mCDX.QURdIf8qKGqqQc.f6K1RqKAIdHuK41a8zxZMLY2hOwKG7y")
					.roles("ADMIN", "USER")
					.authorities("USER_READ", "USER_WRITE", "ADMIN_READ", "ADMIN_WRITE")
					.build();
					
		List<UserDetails> users = new ArrayList<>();
		users.add(user);
		users.add(user2);
		users.add(user3);
		return new InMemoryUserDetailsManager(users);
	}


}