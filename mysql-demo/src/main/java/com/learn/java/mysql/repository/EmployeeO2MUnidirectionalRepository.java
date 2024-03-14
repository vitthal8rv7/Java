package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.EmployeeO2MUnidirectional;

@Repository
public interface EmployeeO2MUnidirectionalRepository extends JpaRepository<EmployeeO2MUnidirectional, Long> {

}
