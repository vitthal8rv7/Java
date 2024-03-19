package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.AddressNPlus1Problem;

@Repository
public interface AddressNplus1ProblemRepository extends JpaRepository<AddressNPlus1Problem, Long>{

}
