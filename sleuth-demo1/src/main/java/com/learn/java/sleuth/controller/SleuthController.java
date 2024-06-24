package com.learn.java.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.Span;
import brave.Tracer;



@RestController
@RequestMapping("/logger/demo")
public class SleuthController {

	private static Logger logger = LoggerFactory.getLogger(SleuthController.class);

	@Autowired
	private Tracer tracer;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/log-levels")
	public String checkLogLevels() {
		
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("X-TRACE-OPERATION", "log-levels");
        headers.set("X-TRACE-REQUESTID", tracer.currentSpan().context().traceIdString());
        headers.set("traceId", ""+tracer.currentSpan().context().traceId());
        headers.set("X-TRACE-USER", "Vitthal Aradwad");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/logger/demo/traceid/2", HttpMethod.GET,
                httpEntity, String.class);
        logger.info("httpEntity"+ responseEntity.getBody());
		return "Log Level Checked.\n Default Log Level Is INFO.";
	}
}
