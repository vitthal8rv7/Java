package com.learn.java.mapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlecode.jmapper.JMapper;
import com.learn.java.mapper.model.Address;
import com.learn.java.mapper.model.Person;
import com.learn.java.mapper.model.PersonDTO;

@RestController
@RequestMapping("/mapper/demo")
public class MapperController {

	@GetMapping("/test")
	public void test() {
	       // Create a JMapper instance
     JMapper<PersonDTO, Person> personMapper = new JMapper<>(PersonDTO.class, Person.class);

     // Create a Person instance
     Person person = new Person();
     person.setFirstName("John");
     person.setLastName("Doe");
     person.setAge(30);

     Address address = new Address();
     address.setCity("New York");
     address.setZipCode("10001");
  //   person.setAddress(address);

     // Map Person to PersonDTO
     PersonDTO personDTO = personMapper.getDestination(person);

     // Print the result
     System.out.println("Full Name: " + personDTO.getFullName());
//     System.out.println("City: " + personDTO.getCity());

		
	}

}
