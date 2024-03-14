package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentM2OUnidirectional;

@Repository
public interface DepartmentM2OUnidirectionRepository extends JpaRepository<DepartmentM2OUnidirectional, Long> {

}
