/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.notification.service;

import org.springframework.http.HttpHeaders;

/**
 * Rest API Service
 * 
 * @author Mindstix
 */
public interface RestApiService {

    /**
     * Post Call using RestTemplate
     * 
     * @param url
     * @param httpHeaders
     * @param body
     * @param responseType
     * @return Object
     */
    public Object postForObject(String url, HttpHeaders httpHeaders, Object body,
            Class<?> responseType);
}