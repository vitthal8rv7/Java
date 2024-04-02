package com.learn.java.security.config;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@Component
@WebFilter(urlPatterns = "/*")
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class StatsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
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
		System.out.println("request end time: "+endTime);
		System.out.println("request total time: "+(endTime - startTime));
		
	}

}
