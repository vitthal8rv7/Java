package com.java.learning.security.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomAccessDeniedException implements AccessDeniedHandler {
    /**
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Populate dynamic values
        String message = getCustomErrorMessage(accessDeniedException);
        String path = request.getRequestURI();
        response.setHeader("custome-denied-reason", "Authorization failed");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        // Construct the JSON response
        String jsonResponse = constructJsonResponse(message, path);
        response.getWriter().write(jsonResponse);
    }


    private String constructJsonResponse(String message, String path) {
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        return  String.format("{\"timestamp2\": \"%s\", \"status2\": %d, \"error2\": \"%s\", \"message2\": \"%s\", \"path2\": \"%s\"}",
                currentTimeStamp, HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase(),
                message, path);
    }

    private String getCustomErrorMessage(AccessDeniedException accessDeniedException) {
        return (accessDeniedException != null && accessDeniedException.getMessage() != null) ?
                accessDeniedException.getMessage() : "Authorization failed";
    }
}
