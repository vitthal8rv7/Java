package com.learn.java.junit5.service;

import com.learn.java.junit5.record.Employee;

public interface EmployeeService {
    public String getEmployeeAsString();

   public Employee getEmployee();

    public Employee saveEmployee(Employee employee);
}
