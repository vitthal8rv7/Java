package com.learn.java.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.java.mysql.model.entity.Employee;

@Repository
public interface EmployeeJpqlRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "select * from employee", nativeQuery = true)
	public List<Employee> findAllUsingJpqlQuery();

	@Query(value = "from Employee where name= :name and email= :email")
	public List<Employee> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

	@Query(value = "from Employee where name= :name or email= :email")
	public List<Employee> findByNameOrEmail(@Param("name") String name, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "delete from Employee where name= :name")
	public Integer deleteByName(@Param("name") String name);

}
