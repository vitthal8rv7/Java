package com.learn.java.mysql.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mysql.model.entity.Department;
import com.learn.java.mysql.repository.DepartmentRepository;
import com.learn.java.mysql.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addOneDepartment() {
		Optional<Department> department = departmentRepository.findById(1L);
		if(department.isEmpty()) {
			return departmentRepository.save(Department.builder().name("dName123").build());
		} else {
			return department.get();
		}
		
		
	}

}
