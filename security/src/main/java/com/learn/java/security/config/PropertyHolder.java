package com.learn.java.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.Getter;

@PropertySource("classpath:application.properties")
@Getter
@Service
public class PropertyHolder {

    @Value("${spring.application.security.pepper}")
    private String peppering;

    @Value("${spring.application.security.encoder}")
    private String encoder;

}
