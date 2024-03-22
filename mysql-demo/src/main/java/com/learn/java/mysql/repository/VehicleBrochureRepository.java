package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.VehicleBrochure;

@Repository
public interface VehicleBrochureRepository extends JpaRepository<VehicleBrochure, Long>{

}
