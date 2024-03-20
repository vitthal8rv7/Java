package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.PersonAddress;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long>{

}
