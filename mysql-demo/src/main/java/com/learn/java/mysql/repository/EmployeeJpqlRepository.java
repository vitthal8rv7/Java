package com.learn.java.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.learn.java.mysql.model.entity.Employee;

@Repository
public interface EmployeeJpqlRepository extends JpaRepository<Employee, Long> {
	
//	@Query("select * from Employee") //Not Working
//	@Query("from employee") //Not Working
	@Query("from Employee") // Working
	public List<Employee> findAllUsingJpqlQuery();

	//Works
//	@Query(value = "from Employee where name= :name and email= :email")
//	public List<Employee> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

	//Also Works
	@Query(value = "from Employee where name= ?1 and email= ?2")
	public List<Employee> findByNameAndEmail(String name, String email);

	//Works
//	@Query(value = "from Employee where name= :name or email= :email")
//	public List<Employee> findByNameOrEmail(@Param("name") String name, @Param("email") String email);

	//Also Works
	@Query(value = "from Employee e where e.name= ?1 or email= ?2")
	public List<Employee> findByNameOrEmail(@Param("name") String name, @Param("email") String email);

	
	/* To Modify Table, Using @Query
	 * 	We have to use Transactional and Modifying annotation.
	*/
	@Transactional
	@Modifying
	@Query(value = "delete from Employee where name= :name")
	public Integer deleteByName(@Param("name") String name);

	//Sorting
	@Query("from Employee Order by salary ASC") // Working
	public List<Employee> findAllSortByName();

	
	
}
