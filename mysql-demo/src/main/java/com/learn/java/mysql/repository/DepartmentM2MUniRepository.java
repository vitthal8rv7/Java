package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentM2MUni;

@Repository
public interface DepartmentM2MUniRepository extends JpaRepository<DepartmentM2MUni, Long>{

}
