package com.learn.java.junit5.repository;

import com.learn.java.junit5.record.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findAll() {
        employeeRepository.save(new Employee("id", "name", 22));
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(1, employees.size());
        assertEquals("id", employees.get(0).getId());
        assertEquals( employees.get(0).getName(), "name");
    }
}