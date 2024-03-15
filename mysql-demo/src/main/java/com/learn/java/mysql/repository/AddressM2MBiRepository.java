package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.AddressM2MBi;

@Repository
public interface AddressM2MBiRepository extends JpaRepository<AddressM2MBi, Long>{

}
