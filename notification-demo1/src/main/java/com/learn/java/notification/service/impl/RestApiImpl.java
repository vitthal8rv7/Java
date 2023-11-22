/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.notification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.java.notification.service.RestApiService;

/**
 * Rest API Implementation
 * 
 * @author Mindstix
 */
@Service
public class RestApiImpl implements RestApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestApiImpl.class);

    @Override
    public Object postForObject(String url, HttpHeaders httpHeaders, Object body,
            Class<?> responseType) {
        LOGGER.info("Making post call at url {}", url);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(body, httpHeaders);
        return restTemplate.postForObject(url, httpEntity, responseType);
    }
}
