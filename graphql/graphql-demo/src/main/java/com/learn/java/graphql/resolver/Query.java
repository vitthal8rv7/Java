package com.learn.java.graphql.resolver;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.learn.java.graphql.model.Animal;
import com.learn.java.graphql.model.Cat;
import com.learn.java.graphql.model.Dog;
import com.learn.java.graphql.model.Employee;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
@Configuration
public class Query implements GraphQLQueryResolver {

    public String testQuery() {
    	System.out.println("Id: ");
    	return "OK";
    }
	
	public Employee getEmployee(String id) {
		Employee employee = new Employee();
		employee.setId(id);
		System.out.println("Id: "+ id);
		return employee;
	} 
	
	public List<Animal> animals() {
        Animal dog = new Dog("1", "Buddy", "Golden Retriever");
        Animal cat = new Cat("2", "Whiskers", 9);

        return Arrays.asList(dog, cat);
	}
}
