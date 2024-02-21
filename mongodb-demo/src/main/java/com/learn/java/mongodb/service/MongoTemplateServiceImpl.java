package com.learn.java.mongodb.service;

import java.util.ArrayList;
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
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.learn.java.mongodb.collection.AggregationResult;
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

		// Regex case insensitive
		query = new Query(Criteria.where("name").regex("^G", "i"));
		LOGGER.info("[Regex with i] : Employee list whose name starts with G : "
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

		// Sort and Pagination
		Sort sort = Sort.by(Sort.Direction.DESC, "salary");
		Pageable pageable = PageRequest.of(0, 2, sort);
		query = new Query(Criteria.where("salary").gte(12345.0f)).with(pageable);
		LOGGER.info(
				"[Sort_And_Pageable] : Employee list whose salary greater than given salary with Sort and Pageable: "
						+ employeeRepository.getDataInList(query, Employee.class));
		PageImpl<Employee> employees = employeeRepository.getDateWithPagination(query, pageable, Employee.class);
		LOGGER.info(
				"[Sort_And_Pageable_Complete_Response] : Employee list whose salary greater than given salary with Sort and Pageable: "
						+ employees.getPageable() + " Size : " + employees.getSize() + " Total Pages : "
						+ employees.getTotalPages() + " Data: " + employees.getContent());
//		Page<Document> docPage = PageableExecutionUtils.getPage(books, pageable, () -> mongoTemplate.count (query, "books"));

		// AND
		Float minSalary = 12345.0f;
		Float maxSalary = 41345.0f;
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(new Criteria().andOperator(Criteria.where("salary").gte(minSalary),
				Criteria.where("salary").lt(maxSalary)));
		query.fields().exclude("addresses");
		LOGGER.info("[And_Operator]" + employeeRepository.getDataInList(query, Employee.class));

		// Wrong OR
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("salary").gte(minSalary).orOperator(Criteria.where("salary").lt(maxSalary)));
		query.fields().exclude("addresses");
		LOGGER.info("[WrongWayOf-Or_Operator]" + employeeRepository.getDataInList(query, Employee.class));
		// only one value in Or Operator, here criteria outside Or operator filter the
		// result(all data will come in this case)
		// then or operator filter data where some of the data got lost
		// if we put both both criteria in or operator then that both condition become 1
		// filter, check below correct Or Operator, here we will get correct result.

		// OR
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(new Criteria().orOperator(Criteria.where("salary").gte(minSalary),
				Criteria.where("salary").lt(maxSalary)));
		query.fields().exclude("addresses");
		LOGGER.info("[Or_Operator]" + employeeRepository.getDataInList(query, Employee.class));

		// OR and AND
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(new Criteria().andOperator(new Criteria().orOperator(Criteria.where("salary").gte(minSalary),
				Criteria.where("salary").lt(maxSalary)), Criteria.where("name").is("name450")));
		query.fields().exclude("addresses");
		LOGGER.info("[And_Operator_And_Or_Operator]" + employeeRepository.getDataInList(query, Employee.class));

		// Is
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("name").is("name450"));
		query.fields().exclude("addresses");
		LOGGER.info("[Is_Operator] Check employee whose name exactly match with name450"
				+ employeeRepository.getDataInList(query, Employee.class));

		// NE - not equal
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("name").ne("name450"));
		query.fields().exclude("addresses");
		LOGGER.info("[NE_Operator] Check employee whose name exactly not match with name450"
				+ employeeRepository.getDataInList(query, Employee.class));

		List<String> names = new ArrayList<>();
		names.add("game11");
		names.add("name450");

		// In
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("name").in(names));
		query.fields().exclude("addresses");
		LOGGER.info("[In_Operator] Fetch employees whose name match to names list"
				+ employeeRepository.getDataInList(query, Employee.class));

		// Not
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("name").not().in(names));
		query.fields().exclude("addresses");
		LOGGER.info("[Not_Operator] Fetch employees whose name not match to names list"
				+ employeeRepository.getDataInList(query, Employee.class));

		// Nin
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("name").nin(names));
		query.fields().exclude("addresses");
		LOGGER.info("[Nin_Operator] Fetch employees whose name not match to names list"
				+ employeeRepository.getDataInList(query, Employee.class));

		// Exists
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("addresses").exists(false));
		query.fields().exclude("department", "salary", "dateOfJoining");
		LOGGER.info("[Exists_Operator] Fetch employees whose donn`t have addresses fields "
				+ employeeRepository.getDataInList(query, Employee.class));

		// . Operator
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("addresses.city").is("city141"));
		query.fields().exclude("department", "salary", "dateOfJoining");
		LOGGER.info("[Dot_Operator] Check employee whose city exactly match with city141"
				+ employeeRepository.getDataInList(query, Employee.class));

		// Size - Used in array only
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("addresses").size(3));
		query.fields().exclude("department", "salary", "dateOfJoining");
		LOGGER.info("[Size_Operator] Fetch employees whose addresses array size exact match to given counter(3) "
				+ employeeRepository.getDataInList(query, Employee.class));

		// Type -
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("name").type(2));
		query.fields().include("name");
		LOGGER.info("[Type_Operator] Fetch employees whose name field type is string"
				+ employeeRepository.getDataInList(query, Employee.class));

		List<String> cities = new ArrayList<>();
		cities.add("city14");
		cities.add("city141");

		// All - Used in array only
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("addresses.city").all(cities));
		query.fields().exclude("department", "salary", "dateOfJoining");
		LOGGER.info("[All_Operator] Fetch employees whose addresses array hava exact match to given cities "
				+ employeeRepository.getDataInList(query, Employee.class));

		// ElemMatch-Is - Check exact match with 1 object all/specific values, not
		// across all objects
//				Used in multiple fields of array of array(compare in only 1 location, (not all locations))
		Criteria nestedCriteria = new Criteria().andOperator(
				new Criteria().orOperator(Criteria.where("city").is("city"), Criteria.where("city").is("city142")),
				Criteria.where("address1").is("address141"), Criteria.where("address2").is("address242"));
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("addresses").elemMatch(nestedCriteria));
		query.fields().include("addresses");
		LOGGER.info("[ElemMatch_Is_Operator] Fetch employees whose addresses array fields exact match to given data "
				+ employeeRepository.getDataInList(query, Employee.class));

		// ElemMatch-In : Not Recommended to use with In Operator?
		query = new Query().with(Sort.by(Sort.Direction.DESC, "salary"));
		query.addCriteria(Criteria.where("addresses").elemMatch(Criteria.where("city").in(cities)));
		query.fields().exclude("department", "salary", "dateOfJoining");
		LOGGER.info("[ElemMatch_In_Operator] Fetch employees whose addresses array fields exact match to given data "
				+ employeeRepository.getDataInList(query, Employee.class));

		// The $elemMatch operator matches documents that contain an array field with at
		// least one element that matches all the specified query criteria.

		query = new Query();
		List<Criteria> criterias = new ArrayList<>();
		criterias.add(Criteria.where("addresses.city").is("city142"));
		criterias.add(Criteria.where("name").is("name450"));
		criterias.add(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
				Criteria.where("salary").lt(51234.0)));
		if (criterias.size() > 0) {
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
		}
		query.fields().include("name", "salary", "addresses.city");
		query.with(Sort.by(Sort.Direction.DESC, "salary"));
		LOGGER.info(
				"[Criteria_List] Fetch employees whose city = city142, name=name450, salary=gt(12345) And lt(51234) "
						+ employeeRepository.getDataInList(query, Employee.class));

		Aggregation aggregation = null;
		AggregationResults<Employee> agrEmployeeResult = null;
		AggregationResults<AggregationResult> agrResult = null;
		
		// Match + Group + Average
		aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("salary").gte(12345.0)),
				Aggregation.group("department").avg("salary").as("averageSalary"));
		agrResult = employeeRepository.aggregate(aggregation,
				AggregationResult.class);
		LOGGER.info("avg: " + agrResult.getRawResults().toJson());

		// Match + Group + Sum
		aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("salary").gte(12345.0)),
				Aggregation.group("department").sum("salary").as("totalSalary"));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("sum: " + agrResult.getMappedResults());

		// Match + Group + Average + . Operator
		aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("salary").gte(12345.0)),
				Aggregation.group("addresses.city").avg("salary").as("averageSalary"));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("avg: " + agrResult.getMappedResults());

		// Match + Group + Sum + AndOperator
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department").sum("salary").as("totalSalary"));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("sum: " + agrResult.getMappedResults());

		// Match + Group 
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department"));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("group: " + agrResult.getMappedResults());
		
		// Match + Group + Group (all possible combinations of name and department as a Id field for group)
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department", "name"));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("group + group: " + agrResult.getMappedResults());
		
		//Group Them Match (not Recommended)
		aggregation = Aggregation.newAggregation(Aggregation.group("salary"), 
				Aggregation.match(new Criteria().andOperator(Criteria.where("_id").gte(12345.0),
						Criteria.where("_id").lte(42345.0))));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("match then group: " + agrResult.getMappedResults());

		// Match + Group + Sort
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department"), Aggregation.sort(Sort.by(Sort.Direction.DESC, "_id")));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("group: " + agrResult.getMappedResults());

		// Match + Group + Sort
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department"), Aggregation.sort(Sort.by(Sort.Direction.DESC, "_id")));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("group: " + agrResult.getMappedResults());

		
		// Match + Group + Limit + Skip
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))), Aggregation.limit(4), Aggregation.skip(1));
		agrEmployeeResult = employeeRepository.aggregate(aggregation, Employee.class);
		LOGGER.info("group: " + agrEmployeeResult.getMappedResults());

		//Employee.class response
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department"), Aggregation.sort(Sort.by(Sort.Direction.DESC, "_id")));
		agrEmployeeResult = employeeRepository.aggregate(aggregation, Employee.class);
		LOGGER.info("group: " + agrEmployeeResult.getMappedResults());


		// Match + Group + Project (Not Working)
		aggregation = Aggregation.newAggregation(
				Aggregation.match(new Criteria().andOperator(Criteria.where("salary").gte(12345.0),
						Criteria.where("salary").lt(41234.0))),
				Aggregation.group("department"), 
				Aggregation.project("_id", "totalSalary", "salary"));
		agrResult = employeeRepository.aggregate(aggregation, AggregationResult.class);
		LOGGER.info("group: " + agrResult.getMappedResults());

	}
}
