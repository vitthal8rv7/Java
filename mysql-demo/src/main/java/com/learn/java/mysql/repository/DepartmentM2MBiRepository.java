package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentM2MBi;

@Repository
public interface DepartmentM2MBiRepository extends JpaRepository<DepartmentM2MBi, Long>{

}
