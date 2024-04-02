package com.learn.java.security.config;

import java.io.IOException;

//import org.apache.logging.log4j.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.java.security.util.ThreadLocalUtilityService;

import io.micrometer.common.util.StringUtils;

//import com.elc.apac.config.StatsFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
//import net.logstash.logback.marker.Markers;
import jakarta.servlet.http.HttpServletRequest;
import net.logstash.logback.marker.Markers;

@Component
@WebFilter(urlPatterns = "/*")
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class StatsFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatsFilter.class);

	@Autowired
	private ThreadLocalUtilityService threadLocalUtilityService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		MDC.clear();
		MDC.put("testKey", "testValue");
		 HttpServletRequest req = (HttpServletRequest) request;
		updatedMDCFields(req);
		Long startTime = System.currentTimeMillis();
		System.out.println("request start time: "+startTime);

		chain.doFilter(request, response);
		
		Long endTime = System.currentTimeMillis();
		Long totalRequestTime = (endTime - startTime);
		Long totalDatabaseTime = (threadLocalUtilityService.getT2().get() - threadLocalUtilityService.getT1().get());
		Long totalBETime = totalRequestTime - totalDatabaseTime;
		
//		LOGGER.info("BE_PERF_STAT_MS: "+totalBETime);
//		LOGGER.info("Database_PERF_STAT_MS: "+totalDatabaseTime);
//		LOGGER.info("REQUEST_PERF_STAT_MS: "+totalRequestTime);
		
		Marker marker = Markers.append("BE_PERF_STAT_MS: ", totalBETime);
        marker.add(Markers.append("Database_PERF_STAT_MS: ", totalDatabaseTime));
        marker.add(Markers.append("REQUEST_PERF_STAT_MS: ", totalRequestTime));
        LOGGER.info(marker, "X-STAT-PERF");
		
	}
	
	
    protected void updatedMDCFields(HttpServletRequest request) {
        LOGGER.info("Updating the MDC fields");

        if (!StringUtils.isBlank(request.getHeader("X-FORWARDED-FOR"))) {
            MDC.put("CLIENT_IP_ADDR", request.getHeader("X-FORWARDED-FOR"));
        }
        if (!StringUtils.isBlank(request.getHeader("X-TRACE-USER"))) {
            MDC.put("X-TRACE-USER", request.getHeader("X-TRACE-USER"));
        }
        if (!StringUtils.isBlank(request.getHeader("X-TRACE-REQUESTID"))) {
            MDC.put("X-TRACE-REQUESTID", request.getHeader("X-TRACE-REQUESTID"));
        }
        if (!StringUtils.isBlank(request.getHeader("X-TRACE-OPERATION"))) {
            MDC.put("X-TRACE-OPERATION", request.getHeader("X-TRACE-OPERATION"));
        }
        if (!StringUtils.isBlank(request.getHeader("User-Agent"))) {
            MDC.put("User-Agent", request.getHeader("User-Agent"));
        }
        if (!StringUtils.isBlank(request.getHeader("METHOD"))) {
            MDC.put("METHOD", request.getHeader("METHOD"));
        }
        LOGGER.info("MDC fields updated");
    }


}
