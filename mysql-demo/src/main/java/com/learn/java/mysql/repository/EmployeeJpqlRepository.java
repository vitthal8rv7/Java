package com.learn.java.mysql.repository;

import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.java.mysql.model.dto.EmployeeDto;
import com.learn.java.mysql.model.entity.Employee;

@Repository
public interface EmployeeJpqlRepository extends JpaRepository<Employee, Long> {

//	@Query("select * from Employee") //Not Working
//	@Query("from employee") //Not Working
	@Query("from Employee") // Working
	public List<Employee> findAllUsingJpqlQuery();

	// Works
//	@Query(value = "from Employee where name= :name and email= :email")
//	public List<Employee> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

	// Also Works
	@Query(value = "from Employee where name= ?1 and email= ?2")
	public List<Employee> findByNameAndEmail(String name, String email);

	// Works
//	@Query(value = "from Employee where name= :name or email= :email")
//	public List<Employee> findByNameOrEmail(@Param("name") String name, @Param("email") String email);

	// Also Works
	@Query(value = "from Employee e where e.name= ?1 or email= ?2")
	public List<Employee> findByNameOrEmail(@Param("name") String name, @Param("email") String email);

	/*
	 * To Modify Table, Using @Query We have to use Transactional and Modifying
	 * annotation.
	 */
	@Transactional
	@Modifying
	@Query(value = "delete from Employee where name= :name")
	public Integer deleteByName(@Param("name") String name);

	// Sorting
	@Query("from Employee Order by salary ASC") // Working
	public List<Employee> findAllSortByName();

	@Query("from Employee") // Working
	public List<Employee> findAllSortByName(Sort sort);

	// Don`t Work as a Like Clause, it work as a 'is/equal' clause
	// , like clause work if placeholder wrap with '%' sign, like this %?1%
	@Query(value = "from Employee e where e.name like ?1")
	public List<Employee> findByNameContaining(String name);

	// Works, like clause work if placeholder wrap with '%' sign, like this %?1%
	@Query(value = "from Employee e where e.name like %?1%")
	public List<Employee> findByNameContaining2(String name);

	// Empty Result, CONCAT issue?
	@Query(value = "from Employee e where e.name like CONCAT('%', '?1', '%')")
	public List<Employee> findByNameContaining3(String name);

	@Query(value = "from Employee e where e.name like %?1%")
	public List<Employee> findByNameContainingWithPageable(String name, Pageable pageable);

	@Query(value = "from Employee e where e.name like %?1%")
	public Page<List<Employee>> findByNameContainingWithPageable2(String name, Pageable pageable);

	@Query("SELECT DISTINCT e.name FROM Employee e")
	List<String> findDistinctNames();

	@Query("SELECT COUNT(e) FROM Employee e")
	long countAllEntities();

	@Query("SELECT COUNT(DISTINCT e.name) FROM Employee e")
	long countAllDistinctNameEntities();

	@Query("SELECT SUM(e.salary) FROM Employee e Where e.name in (SELECT e.name FROM Employee e Where e.name like %?1%)")
	long sumOfSalaryByNameLike(String name);

	@Query("SELECT NEW com.learn.java.mysql.model.dto.EmployeeDto(e.id, e.name, e.salary, e.joiningDate) FROM Employee e")
	List<EmployeeDto> findDTOs();

	@Query("SELECT e FROM Employee e WHERE UPPER(e.name) = UPPER(?1)")
	List<Employee> findByNameIgnoreCase(@Param("name") String name);

//	@Query(nativeQuery = true)
	List<Employee> findBySalaryLessThan42000();
}
