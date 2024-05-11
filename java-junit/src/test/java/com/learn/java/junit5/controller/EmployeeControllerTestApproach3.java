package com.learn.java.junit5.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learn.java.junit5.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTestApproach3 {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setMockOutput() {
    	
    }

    @Test
    public void greeting() {
    	when(employeeService.getWelcomeMessage()).thenReturn("Hello Mockito Test");
        String response = employeeController.greeting();
        assertThat(response).isEqualTo("Hello Mockito Test");
    }
    @Test
    public void shouldReturnDefaultMessage() {
    	when(employeeService.getWelcomeMessage()).thenReturn("Hello Mockito Test");
        String response = "Hello Mockito Test";//employeeController.greeting();
        assertThat(response).isEqualTo("Hello Mockito Test");
    }
    
    @Test
    public void shouldReturnDefaultMessage2() {
    	lenient().when(employeeService.getWelcomeMessage()).thenReturn("Hello Mockito Test");
        String response = "Hello Mockito Test";//employeeController.greeting();
        assertThat(response).isEqualTo("Hello Mockito Test");
    }
}