package com.learn.java.security.config;

import java.io.IOException;

//import org.apache.logging.log4j.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.springframework.stereotype.Component;

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

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		MDC.clear();
		MDC.put("testKey", "testValue");
		 HttpServletRequest req = (HttpServletRequest) request;
		updatedMDCFields(req);
		Long startTime = System.currentTimeMillis();
		System.out.println("request start time: "+startTime);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chain.doFilter(request, response);
		Long endTime = System.currentTimeMillis();
		Long totalRequestTime = (endTime - startTime);
		System.out.println("request end time: "+endTime);
		System.out.println("request total time: "+totalRequestTime);
		
		LOGGER.info("BE_PERF_STAT : "+totalRequestTime);
		Marker marker = Markers.append("Marker:BE_PERF_STAT_MS", totalRequestTime);
        marker.add(Markers.append("Marker:TOTAL_PERF_STAT_MS", totalRequestTime));
        

        LOGGER.info(marker, "Marker");
		
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
