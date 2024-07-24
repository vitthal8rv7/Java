package com.learn.java.graphql.resolver;

import java.util.Arrays;
import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.learn.java.graphql.model.Animal;
import com.learn.java.graphql.model.Cat;
import com.learn.java.graphql.model.Dog;

@Controller
public class Queries {

	@QueryMapping(name = "animals", value = "animals")
	public List<Animal> animals() {
        Animal dog = new Dog("1", "Buddy", "Golden Retriever");
        Animal cat = new Cat("2", "Whiskers", 9);
        return Arrays.asList(dog, cat);
	}
}
