package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentO2OBi;

@Repository
public interface DepartmentO2OBiRepository extends JpaRepository<DepartmentO2OBi, Long>{

}
