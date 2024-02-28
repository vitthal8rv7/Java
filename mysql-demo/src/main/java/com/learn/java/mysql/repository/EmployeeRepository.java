package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.java.mysql.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
