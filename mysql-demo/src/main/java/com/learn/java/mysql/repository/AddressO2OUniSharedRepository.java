package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.AddressO2OUniShared;

@Repository
public interface AddressO2OUniSharedRepository extends JpaRepository<AddressO2OUniShared, Long>{

}
