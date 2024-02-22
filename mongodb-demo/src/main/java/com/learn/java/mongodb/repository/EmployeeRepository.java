package com.learn.java.mongodb.repository;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import com.learn.java.mongodb.collection.Employee;

@Repository
public class EmployeeRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	public Employee findById(String id) {
		return mongoTemplate.findById(id, Employee.class);
	}

	public Employee save(Employee employee) {
		return mongoTemplate.save(employee);
	}

	public List<Employee> findAll() {
		return mongoTemplate.findAll(Employee.class);
	}

	public Long delete(Employee employee) {
		return mongoTemplate.remove(employee).getDeletedCount();
	}

	public <T> Long delete(Query query, Class<T> classType) {
		return mongoTemplate.remove(query, classType).getDeletedCount();
	}

	public <T> Long update(Query query, Update update, Class<T> classType) {
		return mongoTemplate.updateFirst(query, update, classType).getModifiedCount();
	}

	public <T> List<T> getDataInList(Query query, Class<T> classType) {
		try {
			return mongoTemplate.find(query, classType);
		} catch (Exception e) {
			LOGGER.error("No Data Found.");
			return null;
		}
	}

	public <T> T getData(Query query, Class<T> classType) {
		try {
			return mongoTemplate.findOne(query, classType);
		} catch (Exception e) {
			LOGGER.error("No Data Found.");
			return null;
		}
	}

	public PageImpl<Employee> getDateWithPagination(Query query, Pageable pageable, Class<Employee> classType) {
		List<Employee> employees = getDataInList(query, Employee.class);
		Long count = mongoTemplate.count(query, Employee.class);
		return new PageImpl<>(employees, pageable, count);
	}
	
	public Page<Employee> getDateWithPage(Query query, Pageable pageable, Class<Employee> classType) {
		return PageableExecutionUtils.getPage(mongoTemplate.find(query, Employee.class), 
				pageable, () -> mongoTemplate.count(query.skip(0).limit(0), Employee.class));
//				() -> {return 0l;});
//		LongSupplier ls =  () -> {return 0l;};
	}

	public <T> AggregationResults<T> aggregate(Aggregation aggregation,
			Class<T> classType) {
		return mongoTemplate.aggregate(aggregation, Employee.class, classType);
	}
	
	public AggregationResults<Document> aggregateDoc(Aggregation aggregation) {
		return mongoTemplate.aggregate(aggregation, Employee.class, Document.class);
	}
	
		
	
}
