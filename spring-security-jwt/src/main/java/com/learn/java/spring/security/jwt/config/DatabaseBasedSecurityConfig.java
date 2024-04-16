package com.learn.java.spring.security.jwt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.learn.java.spring.security.jwt.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity // (debug = true)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class DatabaseBasedSecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseBasedSecurityConfig.class);

	@Autowired
	private UserServiceImpl userDetailsService;

	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/registerUser", "/", "/registerUser/**", "/home", "/authenticate", "/authenticate/**", "/registerUser/*", "/registerUser*" , "/registerUser", "/registerUser?username=u0&password=p0", "/registerUser/**").permitAll();
//			request.requestMatchers(HttpMethod.GET, "/registerUser", "/registerUser/**").permitAll();
//			request.requestMatchers(HttpMethod.POST, "/authenticate", "/authenticate/**").permitAll();
			request.anyRequest().authenticated();

		});

//		http.requiresChannel(t -> t.anyRequest().requiresSecure());
		http.csrf(csrf -> csrf.disable());
		http.sessionManagement(session -> {
//			session.sessionFixation().newSession();
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//					.invalidSessionUrl("/invalidSession.html")
//					.maximumSessions(100)
//					.maxSessionsPreventsLogin(true)
//					.expiredUrl("/expiredUrl.html");

		});

//		http.rememberMe(rememberMe -> {
//			rememberMe.tokenValiditySeconds(604800) // Remember me token validity for 7 days
//					.userDetailsService(userDetailsService); // UserDetailsService for loading remember me
//		});

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//		http.formLogin(formLogin -> {
//			LOGGER.info("Apply Form Login");
//		});

		
		return http.build();
	}

//	@Bean
//	public SessionRegistry sessionRegistry() {
//		return new SessionRegistryImpl();
//	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/home");
	}

	// Authentication Verification
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
	}

//	@Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return new AuthenticationManagerFactoryBean().getObject();
//    }

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}