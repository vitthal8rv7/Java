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
//@Order(1)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class securityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("securityFilter: request start time: "+System.currentTimeMillis());
		System.out.println("request: "+request.toString());
		chain.doFilter(request, response);
		
	}

}
