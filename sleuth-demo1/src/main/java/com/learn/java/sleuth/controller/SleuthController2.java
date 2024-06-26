package com.learn.java.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;



@RestController
@RequestMapping("/logger/demo")
public class SleuthController2 {

	private static Logger logger = LoggerFactory.getLogger(SleuthController2.class);

	@Autowired
	private Tracer tracer;

	@GetMapping("/traceid")
	public String getSleuthTraceId() {
		logger.info("Hello with Sleuth");
		Span span = tracer.currentSpan();
		if (span != null) {
			
			logger.info("parentId {}", span.context().parentId());
			logger.info("TraceID {}", span.context().traceId());
			logger.info("SpanID {}", span.context().spanId());
		}
		return "Hello from Sleuth";
	}

}
