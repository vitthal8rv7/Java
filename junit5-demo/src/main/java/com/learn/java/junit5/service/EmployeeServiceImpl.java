package com.learn.java.junit5.service;

import com.learn.java.junit5.record.Employee;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    static String id = UUID.randomUUID().toString();
    @Override
    public String getEmployeeAsString() {
        return new Employee(id, "emp1", 22).toString();
    }

    @Override
    public Employee getEmployee() {
        return new Employee(id, "emp1", 22);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return new Employee(id, "emp1", 22);
    }
}
