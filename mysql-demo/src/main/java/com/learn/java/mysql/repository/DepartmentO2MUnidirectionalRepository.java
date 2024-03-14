package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentO2MUnidirectional;

@Repository
public interface DepartmentO2MUnidirectionalRepository extends JpaRepository<DepartmentO2MUnidirectional, Long> {

}
