package com.learn.java.junit5.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.java.junit5.model.Employee;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void findAll() throws JSONException, JsonProcessingException {
        employeeRepository.save(new Employee("id", "name", 22));
        List<Employee> employees = employeeRepository.findAll();

        String employeeAsString = objectMapper.writeValueAsString(employees);
        assertEquals(1, employees.size());
        assertEquals("id", employees.get(0).getId());
        assertEquals( employees.get(0).getName(), "name");
        JSONAssert.assertEquals("[{id:\"id\", name:\"name\", age:22}]",  employeeAsString, false);
    }
}