package com.learn.java.junit5.service;

import com.learn.java.junit5.record.Employee;
import com.learn.java.junit5.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    static String id = UUID.randomUUID().toString();
    @Override
    public String getEmployeeAsString() {
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()) {
            System.out.println(emp.get().toString());
            return emp.get().toString();
        } else {
            System.out.println("Employee Not Found");
            return "";
        }
        //return new Employee(id, "emp1", 22).toString();
    }

    @Override
    public Employee getEmployee() {
        Optional<Employee> emp = employeeRepository.findById("id");
        return emp.orElse(null);
        //return new Employee(id, "emp1", 22);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
        //return new Employee(id, "emp1", 22);
    }
}
