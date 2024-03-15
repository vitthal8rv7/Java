package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.AddressM2MUni;

@Repository
public interface AddressM2MUniRepository extends JpaRepository<AddressM2MUni, Long>{

}
