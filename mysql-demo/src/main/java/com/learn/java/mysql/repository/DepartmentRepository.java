package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
