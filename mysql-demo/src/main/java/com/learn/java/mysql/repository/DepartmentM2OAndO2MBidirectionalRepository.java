package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.DepartmentM2OAndO2MBidirectional;

@Repository
public interface DepartmentM2OAndO2MBidirectionalRepository extends JpaRepository<DepartmentM2OAndO2MBidirectional, Long> {

}
