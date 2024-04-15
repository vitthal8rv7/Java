package com.learn.java.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;

import com.learn.java.security.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity // (debug = true)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class DatabaseBasedSecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseBasedSecurityConfig.class);

	@Autowired
	private UserServiceImpl userDetailsService;

//	@Autowired
//    private PasswordEncoder passwordEncoder;    
//
//	@Autowired
//    private PasswordEncoder passwordEncoder2;    

	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/", "/registerUser/**", "/home").permitAll();
			request.requestMatchers("/user/**").hasRole("USER");
			request.requestMatchers("/user-specific-readonly").hasAnyAuthority("USER_READ");
			request.requestMatchers("/admin-specific").hasRole("ADMIN");
			request.requestMatchers("/update-api").hasAnyAuthority("ADMIN_WRITE", "USER_WRITE");
			request.requestMatchers("/update-admin-api/**").hasAnyAuthority("ADMIN_WRITE");
			request.anyRequest().authenticated();

		});
		
//		http.requiresChannel(t -> t.anyRequest().requiresSecure());

		http.sessionManagement(session -> {
			session.sessionFixation().newSession();
			session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//					.invalidSessionUrl("/invalidSession.html")
					.maximumSessions(100)
					.maxSessionsPreventsLogin(true)
					.expiredUrl("/expiredUrl.html");

		});

		http.rememberMe(rememberMe -> {
			rememberMe.tokenValiditySeconds(604800) // Remember me token validity for 7 days
					.userDetailsService(userDetailsService); // UserDetailsService for loading remember me
		});

		http.formLogin(formLogin -> {
			LOGGER.info("Apply Form Login");
		});
//		http.formLogin();
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
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
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
		System.out.println("auth: " + auth.toString());
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication()
//			.userDnPatterns("uid={0},ou=users")
//			.groupSearchBase("ou=groups")
//			.contextSource()
//			.url("ldap://ldap-server-host:389/dc=example,dc=com")
//            .managerDn("cn=admin,dc=example,dc=com")
//            .managerPassword("admin-password");
//	}	

}