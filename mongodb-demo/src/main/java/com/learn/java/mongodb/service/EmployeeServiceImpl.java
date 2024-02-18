package com.learn.java.mongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learn.java.mongodb.collection.Employee;
import com.learn.java.mongodb.repository.EmployeeAPIsDeclarationRepository;
import com.learn.java.mongodb.repository.EmployeeAutogeneratedRepository;
import com.learn.java.mongodb.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeAutogeneratedRepository empAutogeneratedRepo;

	@Autowired
	private EmployeeAPIsDeclarationRepository empApisDeclRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(String id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(String id, String name) {
		Optional<Employee> employeeOp = employeeRepository.findById(id);
		if (employeeOp.isPresent()) {
			Employee employee = employeeOp.get();
			employee.setName(name);
			return employeeRepository.save(employee);
		} else
			return null;
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully";
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween(Float minSalary, Float maxSalary) {
		return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
	}

	@Override
	public void testAutogeneratedAPIs() {

		// add 5 entries for testing
		LOGGER.info("Returns all instances of the type. : " + empAutogeneratedRepo.findAll());
		LOGGER.info("Returns the number of entities available. : " + empAutogeneratedRepo.count());

		Integer i = Integer.parseInt("" + (empAutogeneratedRepo.count() - 1));
		// Creating an example document
		Employee exampleEntity = empAutogeneratedRepo.findAll().get(i);
		exampleEntity.setId("3");
		exampleEntity.setName("name3");
		Example<Employee> example = Example.of(exampleEntity);

		// Counting the number of documents matching the example
		LOGGER.info("Counting the number of documents matching the example : " + empAutogeneratedRepo.count(example));

		empAutogeneratedRepo.delete(empAutogeneratedRepo.findAll().get(i));
		LOGGER.info("1 Document Deleted?");

		empAutogeneratedRepo.deleteById("13");
		LOGGER.info("1 Document Deleted.");

		LOGGER.info("Document Match? : " + empAutogeneratedRepo.equals(empAutogeneratedRepo.findAll().get(0)));
		LOGGER.info("Document Exist By Id? : " + empAutogeneratedRepo.existsById("1"));

		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		LOGGER.info("Returns all instances of the type by sorting order. : " + empAutogeneratedRepo.findAll(sort));

		PageRequest pageRequest = PageRequest.of(0, 3);
		LOGGER.info("Returns all instances of the typ by pagination. : "
				+ empAutogeneratedRepo.findAll(pageRequest).get().collect(Collectors.toList()));

	}

	@Override
	public void testDeclAPIs() {
		Employee exampleEntity = empAutogeneratedRepo.findAll().get(0);
		exampleEntity.setId("11");
		exampleEntity.setName("name11");
		empAutogeneratedRepo.save(exampleEntity);
		exampleEntity.setId("11copy1");
		exampleEntity.setName("name11");
		empAutogeneratedRepo.save(exampleEntity);
		
		LOGGER.info("find all By name: " + empApisDeclRepo.findByName("name11"));
		LOGGER.info("find first By name: " + empApisDeclRepo.findFirstByName("name11"));
		LOGGER.info("find Top By name: " + empApisDeclRepo.findTopByName("name11"));
		LOGGER.info("find first By name Ordered by name DESC: " + empApisDeclRepo.findFirstByNameOrderByNameDesc("name11"));
		LOGGER.info("find first By name Ordered by id DESC: " + empApisDeclRepo.findFirstByNameOrderByIdDesc("name11"));
		LOGGER.info("find first By name Ignore case Ordered by id DESC : " + empApisDeclRepo.findFirstByNameIgnoreCaseOrderByIdDesc("namE11"));
		LOGGER.info("find all By name Ignore Case: " + empApisDeclRepo.findByNameIgnoreCase("NAme11"));
		LOGGER.info("find all By name Ignore Case and Ends With: " + empApisDeclRepo.findByNameIgnoreCaseEndsWith("E11"));
		LOGGER.info("find all By name Ignore Case and Starts With: " + empApisDeclRepo.findByNameIgnoreCaseStartsWith("NAME"));
		LOGGER.info("find First By name Ignore Case and Starts With: " + empApisDeclRepo.findFirstByNameIgnoreCaseStartsWith("NAME"));
		LOGGER.info("find First By name is not Ignore Case: " + empApisDeclRepo.findFirstByNameIsNotIgnoreCase("aNAME"));
		LOGGER.info("find First By name is not Ignore Case: " + empApisDeclRepo.findFirstByNameIsNotIgnoreCase("name1"));
		LOGGER.info("find All By name is not Ignore Case: " + empApisDeclRepo.findAllByNameIsNotIgnoreCase("aNAME"));
		LOGGER.info("find All By name is not Ignore Case: " + empApisDeclRepo.findAllByNameIsNotIgnoreCase("name1"));

		LOGGER.info("find Distinct By name: " + empApisDeclRepo.findDistinctByName("name11"));
		LOGGER.info("count by name: " + empApisDeclRepo.countByName("name11"));
		LOGGER.info("count by Name Containing: " + empApisDeclRepo.countByNameContaining("name"));
		LOGGER.info("find By name Regex: " + empApisDeclRepo.findByNameRegex("^name.*"));
		//The ^ in the regex pattern represents the start of the string, and .* represents any characters after "name".
		
		List<String> names = new ArrayList<>();
		names.add("name4");
		names.add("name130");
		names.add("name3");
		LOGGER.info("find By list of names: " + empApisDeclRepo.findByNameIn(names));
		LOGGER.info("find By which are not from list of names: " + empApisDeclRepo.findByNameIsNotIn(names));
//		LOGGER.info("find All By list of names: " + empApisDeclRepo.findByNames(names));

//		LOGGER.info("find First By name Ignore Case and Not Starts With: " + empApisDeclRepo.findFirstByNameIsNotIgnoreCaseStartsWith("NAME"));		
//		LOGGER.info("find First By name Ignore Case and Not Starts With: " + empApisDeclRepo.findFirstByNameIgnoreCaseStartsWithIsNot("NAME", "NAME"));
//		Error creating bean

//		LOGGER.info("find one By name: " + empApisDeclRepo.findOneByName("name11")); 
//		 Exception saying => returned non unique result
			
		LOGGER.info("find all By department: " + empApisDeclRepo.findByDepartment("department1"));
		LOGGER.info("find first By department: " + empApisDeclRepo.findFirstByDepartment("department1"));
//		LOGGER.info("find last By department: " + empApisDeclRepo.findLastByDepartment("department1"));
		// Exception saying => returned non unique result

		
		System.out.println();
		System.out.println();
		LOGGER.info("find all By name and department: " + empApisDeclRepo.findByNameAndDepartment("name1", "department1"));
		
		System.out.println();
		System.out.println();
		LOGGER.info("find all By name or department: " + empApisDeclRepo.findByNameOrDepartment("name1", "department1"));
		
//		System.out.println();
//		System.out.println();
//		LOGGER.info("find all By name null or department: " + empApisDeclRepo.findByNameNullOrDepartment("name1", "department1"));
//		LOGGER.info("find all By name null or department: " + empApisDeclRepo.findByNameNullOrDepartment("name1", null));
//		LOGGER.info("find all By name null or department: " + empApisDeclRepo.findByNameNullOrDepartment(null, "department1"));
//		LOGGER.info("find all By name null or department: " + empApisDeclRepo.findByNameNullOrDepartment(null, null));
		
		names.add("name1");
		LOGGER.info("find all By names or department: " + empApisDeclRepo.findByNameInAndDepartment(names, "department1"));
		LOGGER.info("find all By names and department ignore case and order by id: " + empApisDeclRepo.findFirstByNameAndDepartmentAllIgnoreCaseOrderByIdDesc("name11", "department1"));
	}

}
