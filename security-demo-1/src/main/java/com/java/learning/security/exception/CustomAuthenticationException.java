package com.java.learning.security.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomAuthenticationException implements AuthenticationEntryPoint {
    /**
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        String message = getCustomErrorMessage(authException);
        String path = request.getRequestURI();
        response.setHeader("custom-error-reason", "Authentication failed");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");
        // Construct the JSON response
        String jsonResponse = constructJsonResponse(message, path);
        response.getWriter().write(jsonResponse);
    }

    private String constructJsonResponse(String message, String path) {
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        return String.format("{\"timestamp2\": \"%s\", \"status2\": %d, \"error2\": \"%s\", \"message2\": \"%s\", \"path2\": \"%s\"}",
                currentTimeStamp, HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                message, path);
    }

    private String getCustomErrorMessage(AuthenticationException authException) {
        return (authException != null && authException.getMessage() != null) ? authException.getMessage()
                : "Unauthorized";
    }
}
