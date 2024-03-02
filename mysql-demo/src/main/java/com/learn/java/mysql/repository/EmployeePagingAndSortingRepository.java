package com.learn.java.mysql.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.java.mysql.model.entity.Employee;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, String> {

	
}
