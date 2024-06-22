package com.learning.java.sleuth.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger/demo")
public class SleuthController {

	private static Logger logger = LoggerFactory.getLogger(SleuthController.class);

	@GetMapping("/log-levels")
	public String checkLogLevels() {
		logger.info("Log Level : INFO");
		logger.trace("Log Level : TRACE");
		logger.warn("Log Level : WARN");
		logger.debug("Log Level : DEBUG");
		logger.error("Log Level : ERROR");
		return "Log Level Checked.\n Default Log Level Is INFO.";
	}

	@GetMapping("/traceid")
	public String getSleuthTraceId() {
		logger.info("Hello with Sleuth");
		
		return "Hello from Sleuth";
	}

}
