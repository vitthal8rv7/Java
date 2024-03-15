package com.learn.java.mysql.service.impl;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mysql.model.entity.AddressO2OBi;
import com.learn.java.mysql.model.entity.AddressO2OUni;
import com.learn.java.mysql.model.entity.DepartmentM2OAndO2MBidirectional;
import com.learn.java.mysql.model.entity.DepartmentM2OUnidirectional;
import com.learn.java.mysql.model.entity.DepartmentO2MUnidirectional;
import com.learn.java.mysql.model.entity.DepartmentO2OBi;
import com.learn.java.mysql.model.entity.DepartmentO2OUni;
import com.learn.java.mysql.model.entity.EmployeeM2OAndO2MBidirectional;
import com.learn.java.mysql.model.entity.EmployeeM2OUnidirectional;
import com.learn.java.mysql.model.entity.EmployeeO2MUnidirectional;
import com.learn.java.mysql.repository.AddressO2OBiRepository;
import com.learn.java.mysql.repository.AddressO2OUniRepository;
import com.learn.java.mysql.repository.DepartmentM2OAndO2MBidirectionalRepository;
import com.learn.java.mysql.repository.DepartmentM2OUnidirectionRepository;
import com.learn.java.mysql.repository.DepartmentO2MUnidirectionalRepository;
import com.learn.java.mysql.repository.DepartmentO2OBiRepository;
import com.learn.java.mysql.repository.DepartmentO2OUniRepository;
import com.learn.java.mysql.repository.EmployeeM2OAndO2MBidirectionalRepository;
import com.learn.java.mysql.repository.EmployeeM2OUnidirectionRepository;
import com.learn.java.mysql.repository.EmployeeO2MUnidirectionalRepository;
import com.learn.java.mysql.service.EntityRelationshipService;

@Service
public class EntityRelationshipServiceImpl implements EntityRelationshipService {

	@Autowired
	private AddressO2OBiRepository addressO2OBiRepo;

	@Autowired
	private DepartmentO2OBiRepository departmentO2OBiRepo;

	@Autowired
	private AddressO2OUniRepository addressO2OUniRepo;

	@Autowired
	private DepartmentO2OUniRepository departmentO2OUniRepo;

	@Autowired
	private DepartmentO2MUnidirectionalRepository departmentO2MUnidirectionalRepo;

	@Autowired
	private EmployeeO2MUnidirectionalRepository employeeO2MUnidirectionalRepo;

	@Autowired
	private DepartmentM2OUnidirectionRepository departmentM2OUnidirectionRepo;

	@Autowired
	private EmployeeM2OUnidirectionRepository employeeM2OUnidirectionRepo;

	@Autowired
	private DepartmentM2OAndO2MBidirectionalRepository departmentM2OAndO2MBidirectionalRepo;

	@Autowired
	private EmployeeM2OAndO2MBidirectionalRepository employeeM2OAndO2MBidirectionalRepository;

	@Override
	public void testManyToOneUnidirection() {
		DepartmentM2OUnidirectional department = null;
		try {
			department = departmentM2OUnidirectionRepo.findById(1L).get();	
		} catch (Exception e) {
			System.out.println("Error");
		}
		if(Objects.isNull(department)) {
			department = departmentM2OUnidirectionRepo.save(DepartmentM2OUnidirectional.builder().name("dName123").build());
		}
		EmployeeM2OUnidirectional employee = employeeM2OUnidirectionRepo.save(EmployeeM2OUnidirectional.builder().name("emp123").department(department).build());
		System.out.println("Department: "+department);
		System.out.println("Employee: "+employee);
	}

	@Override
	public void testManyToOneBidirection() {
		
		//Many Side To One Side
		DepartmentM2OAndO2MBidirectional department = null;
		try {
			department = departmentM2OAndO2MBidirectionalRepo.findById(1L).get();	
		} catch (Exception e) {
			System.out.println("Error");
		}
		if (Objects.isNull(department)) {			
			department = departmentM2OAndO2MBidirectionalRepo
					.save(DepartmentM2OAndO2MBidirectional
							.builder()
							.name("dName123")
							//.employees(Arrays.asList(employee, employee2))
							.build());
		}		 

		System.out.println("Department: "+department);
		
		EmployeeM2OAndO2MBidirectional employee = employeeM2OAndO2MBidirectionalRepository.save(EmployeeM2OAndO2MBidirectional.builder().name("emp123").department(department).build());
		EmployeeM2OAndO2MBidirectional employee2 = employeeM2OAndO2MBidirectionalRepository.save(EmployeeM2OAndO2MBidirectional.builder().name("emp1234").department(department).build());
		
		System.out.println("Employee : "+employee);
		System.out.println("Employee 2 : "+employee2);
	
		
		//this will work is mapped by set to 'One', that means foreign key at department side so it will work fine.
		//One Side To Many Side  // department_id is null // do not use below code to save data.
//		EmployeeM2OAndO2MBidirectional employee3 = employeeM2OAndO2MBidirectionalRepository.save(EmployeeM2OAndO2MBidirectional.builder().name("emp3").build());
//		EmployeeM2OAndO2MBidirectional employee4 = employeeM2OAndO2MBidirectionalRepository.save(EmployeeM2OAndO2MBidirectional.builder().name("emp4").build());
//		department = departmentM2OAndO2MBidirectionalRepo
//				.save(DepartmentM2OAndO2MBidirectional
//						.builder()
//						.name("dName123")
//						.employees(Arrays.asList(employee3, employee4))
//						.build());
//		
//		System.out.println("Employee 3 : "+employee3);
//		System.out.println("Employee 4 : "+employee4);
//		System.out.println("Department : "+department);
//		

	}

	@Override
	public void testOneToManyUnidirection() {
		DepartmentO2MUnidirectional department = null;
		EmployeeO2MUnidirectional employee5 = employeeO2MUnidirectionalRepo.save(EmployeeO2MUnidirectional.builder().name("emp5").build());
		EmployeeO2MUnidirectional employee6 = employeeO2MUnidirectionalRepo.save(EmployeeO2MUnidirectional.builder().name("emp6").build());
		department = departmentO2MUnidirectionalRepo
				.save(DepartmentO2MUnidirectional
						.builder()
						.name("dName123")
						.employees(Arrays.asList(employee5, employee6))
						.build());
		
		System.out.println("Employee 5 : "+employee5);
		System.out.println("Employee 6 : "+employee6);
		System.out.println("Department : "+department);
		
		
	}

	@Override
	public void testOneToOneUni() {
		AddressO2OUni addressO2OUni = addressO2OUniRepo.save(AddressO2OUni.builder().street("Ram Nagar").city("Pune").build());
		DepartmentO2OUni departmentO2OUni = departmentO2OUniRepo.save(DepartmentO2OUni.builder().name("Maths").address(addressO2OUni).build());
		System.out.println("Address : "+addressO2OUni);
		System.out.println("Department : "+departmentO2OUni);
		
	}

	@Override
	public void testOneToOneBi() {
		AddressO2OBi addressO2OBi = addressO2OBiRepo.save(AddressO2OBi.builder().street("Ram Nagar").city("Pune").build());
		DepartmentO2OBi departmentO2OBi = departmentO2OBiRepo.save(DepartmentO2OBi.builder().name("Maths").address(addressO2OBi).build());
		System.out.println("Address : "+addressO2OBi);
		System.out.println("Department : "+departmentO2OBi);		
	}

	
}
