package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.EmployeeM2OUnidirectional;

@Repository
public interface EmployeeM2OUnidirectionRepository extends JpaRepository<EmployeeM2OUnidirectional, Long> {

}
