package com.learn.java.security.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
public class SessionTracker implements HttpSessionListener {

    private static final Set<String> activeSessions = new HashSet<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions.add(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions.remove(se.getSession().getId());
    }

    public static Set<String> getActiveSessions() {
        return activeSessions;
    }
}
