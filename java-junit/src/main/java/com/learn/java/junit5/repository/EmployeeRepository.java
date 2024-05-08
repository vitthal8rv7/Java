package com.learn.java.junit5.repository;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import com.learn.java.junit5.collection.Employee;

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

	public <T> List<T> getDataInListWithQueryExplain(Query query, Class<T> classType) {
		try {
			System.out.println(
					"\n\n\n\n" + mongoTemplate.getCollection("" + classType).find(query.getQueryObject()).explain());
//			System.out.println("\n\n\n\n"+ mongoTemplate.getCollection(""+classType).find(query.getQueryObject()).explain().toJson());
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
		return PageableExecutionUtils.getPage(mongoTemplate.find(query, Employee.class), pageable,
				() -> mongoTemplate.count(query.skip(0).limit(0), Employee.class));
//				() -> {return 0l;});
//		LongSupplier ls =  () -> {return 0l;};
	}

	public <T> AggregationResults<T> aggregate(Aggregation aggregation, Class<T> classType) {
		return mongoTemplate.aggregate(aggregation, Employee.class, classType);
	}

	public AggregationResults<Document> aggregateDoc(Aggregation aggregation) {
		return mongoTemplate.aggregate(aggregation, Employee.class, Document.class);
	}

	public <T> String createIndex(String indexFieldName, Direction sortingOrder, Class<T> collectionType) {
//		Document document = new Document();
//		  if (StringUtils.hasText(indexFieldName)) {
//		    document.put("name", indexFieldName+"_1");
//		  }
//		  
//		  Boolean unique = true; //set false if you want duplicates 
//		  if (unique) {
//		    document.put("unique", true);
//		  }
//		  
//		  Boolean sparse = true; 
//		  if (sparse) {
//		    document.put("sparse", true);
//		  }
//		  
//		  Boolean background = true; //create index in background
//		  if (background) {
//		    document.put("background", true);
//		  }
//		  
//		  document.put("size", indexFieldName.length());
//		  //works with date field only
////		  Date expire = new Date();
////		  if (expire >= 0) {
////		    document.put("expireAfterSeconds", expire);
////		  }
//		  
//		IndexFilter indexFilter = () -> { return document; };
//		
//		Index index = new Index();
//		index.on(indexFieldName, sortingOrder).background().unique().partial(indexFilter);
//		return mongoTemplate.indexOps(collectionType).ensureIndex(index);

		Index index = new Index();
		index.on(indexFieldName, sortingOrder).background().unique();
		return mongoTemplate.indexOps(collectionType.getClass().getName()).ensureIndex(index);
	}

	public <T> List<IndexInfo> listIndex(Class<T> collectionType) {
		return mongoTemplate.indexOps(collectionType.getClass().getName()).getIndexInfo();
	}

	public <T> String createTextIndex(Class<T> collectionType, String... fieldNames) {
		TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
				.onFields(fieldNames)
				.build();
		return mongoTemplate.indexOps(collectionType.getClass().getName()).ensureIndex(textIndex);
	}

	public <T> List<T> textSearch(Query query, Class<T> collectionType) {
		return mongoTemplate.find(query, collectionType);
	}

}
