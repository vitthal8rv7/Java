package com.learning.java.sleuth.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/logger/demo")
public class SleuthController {

	private static Logger logger = LoggerFactory.getLogger(SleuthController.class);
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/log-levels")
	public String checkLogLevels() {
		String traceId = request.getHeader("X-TRACE-REQUESTID").toString();
		String operation = request.getHeader("X-TRACE-OPERATION").toString();
		String user = request.getHeader("X-TRACE-USER").toString();
		logger.info("traceId: "+traceId + " operation: "+ operation+ " user: "+ user);
		return "Log Level Checked.\n Default Log Level Is INFO.";
	}
}
