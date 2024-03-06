package com.learn.java.mysql.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.learn.java.mysql.model.dto.EmployeeDto;
import com.learn.java.mysql.model.entity.Employee;
import com.learn.java.mysql.repository.EmployeeJpqlRepository;
import com.learn.java.mysql.repository.EmployeePagingAndSortingRepository;
import com.learn.java.mysql.repository.EmployeeRepository;
import com.learn.java.mysql.service.EmployeeService;
import com.learn.java.mysql.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeePagingAndSortingRepository empPagingAndSortingRepo;

	@Autowired
	private EmployeeJpqlRepository employeeJpqlRepository;

	private Employee findById(String employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if (employeeOptional.isPresent()) {
			return employeeOptional.get();
		}
		return null;

	}

	@Override
	public EmployeeDto readEmployee(String employeeId) {
		Employee employee = null;
		employee = findById(employeeId);
		if (Objects.isNull(employee)) {
			return null;
		}
		return EmployeeUtil.getEmployee(employee);
	}

	@Override
	public List<EmployeeDto> readAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return EmployeeUtil.convertEmployeeListToEmployeeDtoList(employees);
	}

	@Override
	public List<EmployeeDto> saveEmployees(List<EmployeeDto> employees) {
		List<Employee> employeeList = EmployeeUtil.convertEmployeeDtoListToEmployeeList(employees);
		employeeList = employeeRepository.saveAll(employeeList);
		if (CollectionUtils.isNotEmpty(employeeList)) {
			employees = EmployeeUtil.convertEmployeeListToEmployeeDtoList(employeeList);
			return employees;
		}
		return null;
	}

	@Override
	public EmployeeDto updateEmployee(String id, String name) {
		Employee employee = findById(id);
		employee.setName(name);
		employee = employeeRepository.save(employee);
		return EmployeeUtil.getEmployee(employee);
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee deleted successfully.";
	}

	@Override
	public void testAutoGeneratedQueries() {
		// TODO Auto-generated method stub
		
		//LOGGER.info("Find one By Name: "+ employeeRepository.findOneByNameIs("name1"));

		LOGGER.info("Find By Name: "+ employeeRepository.findByNameIs("name1"));
		
		LOGGER.info("Find By Name Is Not: "+ employeeRepository.findByNameIsNot("name1"));
		
		LOGGER.info("Find By Name Equals: "+ employeeRepository.findByNameEquals("name1"));
		
		LOGGER.info("Find By Name Containing: "+ employeeRepository.findByNameContaining("name1"));
		
		LOGGER.info("Find By Name Contains: "+ employeeRepository.findByNameContains("name1"));

		LOGGER.info("Find By Name Ignore Case: "+ employeeRepository.findByNameIgnoreCase("nAme1"));
		
		LOGGER.info("Find By Name Ignoring Case: "+ employeeRepository.findByNameIgnoringCase("naMe1"));
		
		LOGGER.info("Find By Name Ending With: "+ employeeRepository.findByNameEndingWith("1"));
		
		LOGGER.info("Find By Name Ends With: "+ employeeRepository.findByNameEndsWith("2"));
		
		LOGGER.info("Find By Name Starting With: "+ employeeRepository.findByNameStartingWith("name2"));
		
		LOGGER.info("Find By Name Starts With: "+ employeeRepository.findByNameStartsWith("Name2"));
		
		List<String> names = new ArrayList<>();
		names.add("name11");
		names.add("name21");
		LOGGER.info("Find By Names: "+ employeeRepository.findByNameIn(names));
		
		LOGGER.info("Find By Name in DESC Order of Age: "+ employeeRepository.findByNameOrderByAgeDesc("name1"));
		
		LOGGER.info("Find By NameIsNot And AgeLessThan: "+ employeeRepository.findByNameIsNotAndAgeLessThan("name1", 25));
		
		LOGGER.info("Find By NameIsNot And AgeLessThanEqual: "+ employeeRepository.findByNameIsNotAndAgeLessThanEqual("name1", 25));
		
		LOGGER.info("Find By NameIsNot And AndAgeGreaterThan: "+ employeeRepository.findByNameIsNotAndAgeGreaterThan("name1", 25));
		
		LOGGER.info("Find By NameIsNot And AgeGreaterThanEqual: "+ employeeRepository.findByNameIsNotAndAgeGreaterThanEqual("name1", 25));
		
		LOGGER.info("Find By NameIsNot Or GreaterThanEqualOrderByNameDesc: "+ employeeRepository.findByNameIsNotOrAgeGreaterThanEqualOrderByNameDesc("name1", 25));

		LOGGER.info("Find By NameIn And AgeBetween: "+ employeeRepository.findByNameInAndAgeBetween(names, 10, 21));
		
		List<String> emails = new ArrayList<>();
		emails.add("A@B.com");
		emails.add("A1@B.com");
		LOGGER.info("Find By Name And EmailAllIgnoreCase: "+ employeeRepository.findByNameAndEmailInAllIgnoreCase("name1", emails));

//		 Reason: Index position must be greater zero
//		LOGGER.info("Find By Name RegexIgnoreCase And Email Ends With: "+ employeeRepository.findByNameRegexIgnoreCaseAndEmailEndsWith("com", ".*me.*"));
				
		Sort sort = Sort.by(Direction.ASC, "name", "salary");
		PageRequest pageRequest = PageRequest.of(0, 3);
		LOGGER.info("Find By Names with Sort: "+ empPagingAndSortingRepo.findByNameContaining("name", sort));
		LOGGER.info("Find By Names with Pagination: "+ empPagingAndSortingRepo.findByNameContaining("name", pageRequest));
		
		PageRequest pageAndSortRequest = PageRequest.of(0, 3, sort);
		LOGGER.info("Find By Names with Pagination and Sorting: "+ empPagingAndSortingRepo.findByNameContaining("name", pageAndSortRequest));
	}

	@Override
	public void testJpqlQueries() {
		LOGGER.info("Find All Using JPQL Query: "+ employeeJpqlRepository.findAllUsingJpqlQuery());
		LOGGER.info("");
		LOGGER.info("");
		LOGGER.info("");
		LOGGER.info("");
		LOGGER.info("");
		LOGGER.info("Find By Name And Email Using JPQL Query: "+ employeeJpqlRepository.findByNameAndEmail("name1", "com"));
		LOGGER.info("Find By Name Or Email Using JPQL Query: "+ employeeJpqlRepository.findByNameOrEmail("name1", "com"));
		LOGGER.info("Delete By Name Using JPQL Query: "+ employeeJpqlRepository.deleteByName("name91"));
		LOGGER.info("Find All Sort by salary Using JPQL Query: "+ employeeJpqlRepository.findAllSortByName());
		Sort sort = Sort.by(Direction.ASC, "name", "salary");
		LOGGER.info("Find All with Sort object Using JPQL Query: "+ employeeJpqlRepository.findAllSortByName(sort));
		LOGGER.info("findByNameContaining Without wrap by %  Using JPQL Query: "+ employeeJpqlRepository.findByNameContaining("name1"));
		LOGGER.info("findByNameContaining wrap by % Using JPQL Query: "+ employeeJpqlRepository.findByNameContaining2("name1"));
		LOGGER.info("findByNameContaining CONCAT Using JPQL Query: "+ employeeJpqlRepository.findByNameContaining3("name1"));
		Pageable pageRequest = PageRequest.of(0, 3);
		LOGGER.info("findByNameContaining Page 1 Size 3 Using JPQL Query: "+ employeeJpqlRepository.findByNameContainingWithPageable("name1", pageRequest));
		LOGGER.info("findByNameContaining Page Object Using JPQL Query: "+ employeeJpqlRepository.findByNameContainingWithPageable2("name1", pageRequest));
		pageRequest = PageRequest.of(0, 10, sort);
		LOGGER.info("findByNameContaining Page 1 Size 5 and Sort by name and salary Using JPQL Query: "+ employeeJpqlRepository.findByNameContainingWithPageable("name1", pageRequest));

		LOGGER.info("findDistinctNames Using JPQL Query: "+ employeeJpqlRepository.findDistinctNames());
		LOGGER.info("countAllEntities Using JPQL Query: "+ employeeJpqlRepository.countAllEntities());
		LOGGER.info("countAllDistinctNameEntities Using JPQL Query: "+ employeeJpqlRepository.countAllDistinctNameEntities());
		LOGGER.info("sumOfSalaryByNameLike Using JPQL Query: "+ employeeJpqlRepository.sumOfSalaryByNameLike("name11"));
		
		LOGGER.info("findDTOs Using JPQL Query: "+ employeeJpqlRepository.findDTOs());
	}

	
	
}
