package com.learn.java.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.sleuth.model.Employee;

@RestController
@RequestMapping("/logger/demo")
public class SleuthController {

	private static Logger logger = LoggerFactory.getLogger(SleuthController.class);

//	@Autowired
//	private Tracer tracer;

	@GetMapping("/log-levels")
	public String checkLogLevels() {
		logger.info("Log Level : INFO");
		logger.trace("Log Level : TRACE");
		logger.warn("Log Level : WARN");
		logger.debug("Log Level : DEBUG");
		logger.error("Log Level : ERROR");
		logAmplify();
		return "Log Level Checked.\n Default Log Level Is INFO.";
	}

	private void logAmplify() {
		logger.info("Log Level : INFO");
		logger.trace("Log Level : TRACE");
		logger.warn("Log Level : WARN");
		logger.debug("Log Level : DEBUG");
		logger.error("Log Level : ERROR");
	}

	@GetMapping("/employee")
	public Employee getEmployee(@RequestParam String employeeId) {
		logger.info("Inside get employee");
		Employee employee = new Employee();
		employee.setId(employeeId);
		employee.setName("E-" + employeeId);
		return employee;
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("Inside add employee");
		return employee;
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		logger.info("Inside update employee");
		return employee;
	}

	@PatchMapping("/employee")
	public Employee updateEmployeeName(@RequestParam String employeeId, @RequestParam String employeeName) {
		logger.info("Inside update employee name");
		Employee employee = new Employee();
		employee.setId(employeeId);
		employee.setName(employeeName);
		return employee;
	}

	@DeleteMapping("/employee")
	public Boolean deleteEmployee(@RequestParam String employeeId) {
		logger.info("Inside delete employee");
		return true;
	}

//	@GetMapping("/traceid")
//	public String getSleuthTraceId() {
//		logger.info("Hello with Sleuth");
//		Span span = tracer.currentSpan();
//		if (span != null) {
//			logger.info("Span ID hex {}", span.context().spanIdString());
//			logger.info("Span ID decimal {}", span.context().spanId());
//			logger.info("Trace ID hex {}", span.context().traceIdString());
//			logger.info("Trace ID decimal {}", span.context().traceId());
//		}
//		return "Hello from Sleuth";
//	}

}
