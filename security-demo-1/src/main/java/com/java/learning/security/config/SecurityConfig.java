package com.java.learning.security.config;

import com.java.learning.security.exception.CustomAccessDeniedException;
import com.java.learning.security.exception.CustomAuthenticationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/home3").permitAll()
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/home2").hasRole("ADMIN"));
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());//hbc -> hbc.authenticationEntryPoint(new CustomAuthenticationException()));
        http.exceptionHandling(ehc -> ehc.authenticationEntryPoint(new CustomAuthenticationException()));
        http.exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedException()));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
