package com.learn.java.mysql.repository;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.Employee;

@Repository
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Long> {

	public List<Employee> findByNameContaining(String name, Sort sort);
	public List<Employee> findByNameContaining(String name, PageRequest pageRequest);
}
