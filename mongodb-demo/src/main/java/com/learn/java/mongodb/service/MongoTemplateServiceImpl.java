package com.learn.java.mongodb.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.learn.java.mongodb.collection.Employee;
import com.learn.java.mongodb.repository.EmployeeRepository;

@Service
public class MongoTemplateServiceImpl implements MongoTemplateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoTemplateServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		employee.setDateOfJoining(new Date(System.currentTimeMillis()));
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(String id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getEmployeeAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(String id, String name) {
		Employee employee = employeeRepository.findById(id);
		if (Objects.isNull(employee)) {
			LOGGER.info("Employee not found.");
			return null;
		} else {
			employee.setName(name);
			return employeeRepository.save(employee);
		}
	}

	@Override
	public String deleteEmployee(String id) {
		Employee employee = employeeRepository.findById(id);
		if (Objects.isNull(employee)) {
			return "Employee not found.";
		} else {
			return employeeRepository.delete(employee) + " Employee Deleted Successfully";
		}
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween(Float minSalary, Float maxSalary) {
		Query query = new Query();
		query.addCriteria(Criteria.where("salary").gte(minSalary).andOperator(Criteria.where("salary").lt(maxSalary)));
		return employeeRepository.getDataInList(query, Employee.class);
	}

	@Override
	public List<Employee> getEmployeeBySalary(Float salary) {
		Query query = new Query(Criteria.where("salary").gte(salary));
		return employeeRepository.getDataInList(query, Employee.class);
	}

	@Override
	public void testCriteriaWithMongoTemplate() {
		Query query = null;

		// Update
		query = new Query(Criteria.where("_id").is("45"));
		Update update = new Update().set("name", "name450");
		LOGGER.info("[Update] : Update by id. Updated employee count is : "
				+ employeeRepository.update(query, update, Employee.class));

		// Delete
//		query = new Query(Criteria.where("_id").is("45"));
//		LOGGER.info("[Delete] : Delete by id. delete employee count is : " + employeeRepository.delete(query, Employee.class));

		// Regex
		query = new Query(Criteria.where("name").regex("^g"));
		LOGGER.info("[Regex] : Employee list whose name starts with g : "
				+ employeeRepository.getDataInList(query, Employee.class));

		// Field Include (use when few field need to Include.)
		query = new Query(Criteria.where("salary").gte(12345.0f));
		query.fields().include("name", "salary");
		LOGGER.info("[Include] : Employee list whose salary greater than given salary and include name, salary : "
				+ employeeRepository.getDataInList(query, Employee.class));

		// Field Exclude (use when few field need to Exclude.)
		query = new Query(Criteria.where("salary").gte(12345.0f));
		query.fields().exclude("addresses");
		LOGGER.info("[Exclude] : Employee list whose salary greater than given salary and Exclude addresses: "
				+ employeeRepository.getDataInList(query, Employee.class));

		Sort sort = Sort.by(Sort.Direction.DESC, "salary");
		Pageable pageable = PageRequest.of(0, 2, sort);
		query = new Query(Criteria.where("salary").gte(12345.0f)).with(pageable);
		LOGGER.info("[SortAndPageable] : Employee list whose salary greater than given salary with Sort and Pageable: "
				+ employeeRepository.getDataInList(query, Employee.class));
		PageImpl<Employee> employees = employeeRepository.getDateWithPagination(query, pageable, Employee.class);
		LOGGER.info(
				"[SortAndPageableCompleteResponse] : Employee list whose salary greater than given salary with Sort and Pageable: "
						+ employees.getPageable() + " Size : " + employees.getSize() + " Total Pages : "
						+ employees.getTotalPages() + " Data: " + employees.getContent());
//		Page<Document> docPage = PageableExecutionUtils.getPage(books, pageable, () -> mongoTemplate.count (query, "books"));

		Float minSalary = 12345.0f;
		Float maxSalary = 41345.0f;
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(new Criteria().andOperator(Criteria.where("salary").gte(minSalary),
				Criteria.where("salary").lt(maxSalary)));
		query.fields().exclude("addresses");
		LOGGER.info("[AndOperator]" + employeeRepository.getDataInList(query, Employee.class));

		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("salary").gte(minSalary).orOperator(Criteria.where("salary").lt(maxSalary)));
		query.fields().exclude("addresses");
		LOGGER.info("[WrongWay-OrOperator]" + employeeRepository.getDataInList(query, Employee.class));
		// only one value in Or Operator, here criteria outside Or operator filter the
		// result(all data will come in this case)
		// then or operator filter data where some of the data got lost
		// if we put both both criteria in or operator then that both condition become 1
		// filter, check below correct Or Operator, here we will get correct result.

		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(new Criteria().orOperator(Criteria.where("salary").gte(minSalary),
				Criteria.where("salary").lt(maxSalary)));
		query.fields().exclude("addresses");
		LOGGER.info("[OrOperator]" + employeeRepository.getDataInList(query, Employee.class));

		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(new Criteria().andOperator(new Criteria().orOperator(Criteria.where("salary").gte(minSalary),
				Criteria.where("salary").lt(maxSalary)), Criteria.where("name").is("name450")));
		query.fields().exclude("addresses");
		LOGGER.info("[AndOperatorAndOrOperator]" + employeeRepository.getDataInList(query, Employee.class));

//		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
//		query.addCriteria(Criteria.where("name").is("name450"));
//		query.addCriteria(Criteria.where("salary").gte(12345.0f));

//        criterias.add(Criteria.where(Constants.STARTDATE).lte(currentTime).andOperator(
//                new Criteria().orOperator(Criteria.where(Constants.ENDDATE).is(0), Criteria.where(Constants.ENDDATE).gte(currentTime))));

	}
}
