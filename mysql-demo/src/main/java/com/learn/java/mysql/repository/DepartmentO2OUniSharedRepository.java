package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentO2OUniShared;

@Repository
public interface DepartmentO2OUniSharedRepository extends JpaRepository<DepartmentO2OUniShared, Long>{

}
