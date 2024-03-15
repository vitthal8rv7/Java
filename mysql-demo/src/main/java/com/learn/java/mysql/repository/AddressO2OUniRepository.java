package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.AddressO2OUni;

@Repository
public interface AddressO2OUniRepository extends JpaRepository<AddressO2OUni, Long>{

}
