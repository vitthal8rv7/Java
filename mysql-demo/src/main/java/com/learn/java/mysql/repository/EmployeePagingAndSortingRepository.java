package com.learn.java.mysql.repository;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.java.mysql.model.entity.Employee;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, String> {

	public List<Employee> findByNameContaining(String name, Sort sort);
	public List<Employee> findByNameContaining(String name, PageRequest pageRequest);
}
