package com.learn.java.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/*
 * Method Level Executor (Thread Pool Setting)
 * 
 * Call it by its Name.
 * 
 * */

@Configuration
@EnableAsync
@ComponentScan("com.learn.java")
public class SpringAsyncConfig {
    
    @Bean(name = "threadPoolTaskExecutor2")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
