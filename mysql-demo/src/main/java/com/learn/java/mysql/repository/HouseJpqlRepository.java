package com.learn.java.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.House;

@Repository
public interface HouseJpqlRepository extends JpaRepository<House, Long> {
	
	@Query("FROM House h join ParkingSpace p on h.parking.id = p.id")// where h.parking.id = 4")
	public List<House> findHouseAndParking();
	
//	@Query("SELECT h.ownerName, p.parkingName FROM House h join ParkingSpace p on h.parking.id = p.id ")
//	public List<String> findHouseAndParking2();

	@Query("SELECT h.ownerName, p.parkingName FROM House h left join ParkingSpace p on h.parking.id = p.id ")
	public List<String> leftJoin();
	
	@Query("SELECT h.ownerName, p.parkingName FROM House h right join ParkingSpace p on h.parking.id = p.id ")
	public List<String> rightJoin();

	@Query(" SELECT h.ownerName, p.parkingName FROM House h left join ParkingSpace p on h.parking.id = p.id "
			+ "UNION"
			+ " SELECT h.ownerName, p.parkingName FROM House h right join ParkingSpace p on h.parking.id = p.id") 
	public List<String> fullJoin();

}
