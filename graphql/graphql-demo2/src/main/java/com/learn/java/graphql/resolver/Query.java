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
	@SchemaMapping(typeName = "Query", field = "getEmployee") //field value should be match inside given typeName.
		// in type Query, getEmployee query should be there else we will get exception, if found match it with this function.
	public Employee getEmployeeNameChange(@Argument("id") String id2) {  // here id is field name from schema, and id2 is local name
												//field name and local name should be same or map by alisa name(@Argument("id"))
												// if not, we will get null value to the local field or error will occur
		Employee employee = new Employee();
		employee.setId(id2);
		employee.setAddress(new Address());
		System.out.println("Id: "+ id2);
		return employee;
	} 
	
	@SchemaMapping(typeName="Employee", field="address2") //When Employee Model have field address but in schema field name is address2
	// then we will always get null value for address2, to match them we use Schema Mapping with Parent Type(here Parent of address2 is
	//Employee, and schema field name is address2, now write a code to map them in method definition)
	public Address getAddress(Employee e) {
	    return e.getAddress();
	}
}
