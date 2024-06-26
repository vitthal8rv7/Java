package com.mainul35.socialloginclient;

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
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers("/").permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
                .build();
    }
}
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
//		http.sessionManagement(session -> {
//			session.sessionFixation().newSession();
//			session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////					.invalidSessionUrl("/invalidSession.html")
//					.maximumSessions(2)
//					.maxSessionsPreventsLogin(true)
//					.expiredUrl("/expiredUrl.html");
//
//		});
//		
//		http.headers(hs -> {
//			hs.disable();
////			hs.httpStrictTransportSecurity(hs2 -> {
////				hs2.maxAgeInSeconds(0).includeSubDomains(true);
////			});
//
//		});
//
//        return http
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
//                    authorizationManagerRequestMatcherRegistry
//                            .requestMatchers("/").permitAll()
//                            .anyRequest().authenticated();
//                })
//                
//                .oauth2Login(Customizer.withDefaults())  
////                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//}
