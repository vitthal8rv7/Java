package com.learn.java.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learn.java.profile.model.MyDataSource;

@Configuration
@Profile({ "prod" })
public class ApplicationConfig2 {


}



