package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.EmployeeM2OAndO2MBidirectional;

@Repository
public interface EmployeeM2OAndO2MBidirectionalRepository extends JpaRepository<EmployeeM2OAndO2MBidirectional, Long> {

}
