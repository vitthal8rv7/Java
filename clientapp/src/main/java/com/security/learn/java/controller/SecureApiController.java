package com.security.learn.java.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureApiController {
    @GetMapping("/")
    public String demo(Authentication authentication) {
//        return "demo";
        if(authentication instanceof UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken){
            System.out.println(usernamePasswordAuthenticationToken);
        } else if (authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken) {
            System.out.println(oAuth2AuthenticationToken);
        }
        return "secure.html";
    }
}
