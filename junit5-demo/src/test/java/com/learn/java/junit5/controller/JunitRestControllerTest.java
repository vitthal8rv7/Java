package com.learn.java.junit5.controller;

import com.learn.java.junit5.record.Employee;
import com.learn.java.junit5.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(JunitRestController.class)
class JunitRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void returnStringWithResponseEntity() throws Exception {
        String output = "Hello World!";
        mockMvc.perform(get("/get")).andExpect(status().isOk()).andExpect(content().string(output));
    }

    @Test
    void returnString() throws Exception {

        String output = "Hello World!";

        mockMvc.perform(get("/get-string"))
                .andExpect(status().isOk())
                .andExpect(content().string(output));
    }

    @Test
    void returnEmployeeAsString() throws Exception {
        String output = new Employee(UUID.randomUUID().toString(), "emp1", 22).toString();

        when(employeeService.getEmployeeAsString()).thenReturn(output);

        mockMvc.perform(get("/employee-as-string"))
                .andExpect(status().isOk());
        assertFalse(output.contains("id=null"));
        assertTrue(output.contains("name=emp1"));
        assertTrue(output.contains("age=22"));
    }


    @Test
    void returnEmployee() throws Exception {

        when(employeeService.getEmployee()).thenReturn(new Employee(UUID.randomUUID().toString(), "emp1", 22));

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("emp1"))
                .andExpect(jsonPath("$.age").value(22));

    }

    @Test
    void saveEmployee() throws Exception {
        Employee employee = new Employee(UUID.randomUUID().toString(), "emp1", 22);
        String employeeAsString = objectMapper.writeValueAsString(employee);

        when(employeeService.saveEmployee(employee))
                .thenReturn(new Employee(employee.id(), employee.name() , employee.age()));

        mockMvc.perform(post("/save-employee")
                        .content(employeeAsString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(employee.id()))
                .andExpect(jsonPath("$.name").value("emp1"))
                .andExpect(jsonPath("$.age").value(22));

    }

    @Test
    void readData() throws Exception {
        MockMultipartFile input = new MockMultipartFile("file", "test.txt", "text/plain", "Hello World!".getBytes());

        mockMvc.perform(multipart("/read-multipart-file")
                .file(input)
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(content().string("test.txt"));
    }
}