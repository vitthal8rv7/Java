package com.learn.java.multithreading.config;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.learn.java.multithreading")
public class ThreadPoolConfig implements WebMvcConfigurer{

    public ThreadPoolConfig() {
        super();
    }

    // beans
    
    @Bean
    ThreadPoolExecutor setupExecutor() {
        final int coreThreads = 4;
        final int maxThreads = 8;
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreThreads, maxThreads, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

}
