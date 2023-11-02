package com.learn.java.graphql.resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.learn.java.graphql.model.Address;
import com.learn.java.graphql.model.Employee;

@Controller
public class Query {

//	@QueryMapping
	@SchemaMapping(typeName = "Query", field = "")
	public String testQuery() {
    	System.out.println("Demo 2: ");
    	return "Demo_OK_2";
    }
	
//	@QueryMapping
	@SchemaMapping(typeName = "Query", field = "getEmployee")
	public Employee getEmployee(@Argument("id") String id2) {  // here id is field name from schema, and id2 is local name
												//field name and local name should be same or map by alisa name(@Argument("id"))
												// if not, we will get null value to the local field or error will occur
		Employee employee = new Employee();
		employee.setId(id2);
		System.out.println("Id: "+ id2);
		return employee;
	} 
	
////	@QueryMapping
//	@SchemaMapping(typeName = "Address", field = "empAdd")
//	public Address empAdd(@Argument("addr") Address addr) {  
//		return addr;
//	}
}
