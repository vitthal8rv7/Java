package com.learn.java.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlecode.jmapper.JMapper;
import com.learn.java.mapper.model.Address;
import com.learn.java.mapper.model.Address2;
import com.learn.java.mapper.model.Address3;
import com.learn.java.mapper.model.Address4;
import com.learn.java.mapper.model.Address5;
import com.learn.java.mapper.model.Customer;
import com.learn.java.mapper.model.Name;
import com.learn.java.mapper.model.Order;
import com.learn.java.mapper.model.OrderDTO;
import com.learn.java.mapper.model.Person;
import com.learn.java.mapper.model.Person2;
import com.learn.java.mapper.model.Person3;
import com.learn.java.mapper.model.Person4;
import com.learn.java.mapper.model.PersonDTO;
import com.learn.java.mapper.model.PersonDTO2;
import com.learn.java.mapper.model.PersonDTO3;
import com.learn.java.mapper.model.PersonDTO4;

@RestController
@RequestMapping("/mapper/demo")
public class MapperController {

	@GetMapping("/test2/jmapper")
	public void test2() {
		JMapper<Address2, Address3> addressMapper = new JMapper<>(Address2.class, Address3.class);
		Address3 address3 = new Address3();
		address3.setCity("city1");
		address3.setZipCode("123456");
		Address2 address2 = addressMapper.getDestination(address3);
		System.out.println(address2);

	}

	@GetMapping("/test/jmapper")
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
		person.setAddress(address);

		// Map Person to PersonDTO
		PersonDTO personDTO = personMapper.getDestination(person);

		// Print the result
		System.out.println("Full Name: " + personDTO.getFullName());
		System.out.println("Address: " + personDTO.getAddress());
		System.out.println("City: " + personDTO.getCity());

	}

	@GetMapping("/test/model/mapper")
	public void testModelMapper() {
		Name name = new Name();
		name.setFirstName("First Name");
		name.setLastName("Last Name");
		Customer customer = new Customer();
		customer.setName(name);
		Address4 address = new Address4();
		address.setCity("City Name");
		address.setStreet("Street Name");

		Order order = new Order();
		order.setBillingAddress(address);
		order.setCustomer(customer);
		ModelMapper modelMapper = new ModelMapper();
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		System.out.println("Order DTO : " + orderDTO);
	}

	@GetMapping("/test/property/model/mapper")
	public void testPropertyModelMapper() {
		Address5 address5 = new Address5();
		address5.setCity("City Name");
		address5.setStreet("Street Name");
		Person2 person2 = new Person2();
		person2.setAddress(address5);
		PropertyMap<Person2, PersonDTO2> personMap = new PropertyMap<Person2, PersonDTO2>() {
			protected void configure() {
				map().setStreet(source.getAddress().getStreet());
				map().setCity(source.getAddress().getCity());
			}
		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(personMap);
		PersonDTO2 personDTO2 = modelMapper.map(person2, PersonDTO2.class);
		System.out.println(personDTO2);
		
	}
	
	@GetMapping("/test/loose-matching-strategy/model/mapper")
	public void testLooseMatchingStrategyModelMapper() {
		Address5 address5 = new Address5();
		address5.setCity("City Name");
		address5.setStreet("Street Name");
		Person2 person2 = new Person2();
		person2.setAddress(address5);
//		PropertyMap<Person2, PersonDTO2> personMap = new PropertyMap<Person2, PersonDTO2>() {
//			protected void configure() {
//				map().setStreet(source.getAddress().getStreet());
//				map().setCity(source.getAddress().getCity());
//			}
//		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//		modelMapper.addMappings(personMap);
		PersonDTO2 personDTO2 = modelMapper.map(person2, PersonDTO2.class);
		System.out.println(personDTO2);
		
	}


	@GetMapping("/test/model/mapper/destination/hierarchy/simple")
	public void testModelMapperDestinationHierarchySimple() {
		Address5 address5 = new Address5();
		address5.setCity("City Name");
		address5.setStreet("Street Name");
		Person2 person2 = new Person2();
		person2.setAddress(address5);
		ModelMapper modelMapper = new ModelMapper();
		PersonDTO3 personDTO3 = modelMapper.map(person2, PersonDTO3.class);
		System.out.println(personDTO3);
	}
	
	@GetMapping("/test/model/mapper/destination/hierarchy/simple2")
	public void testModelMapperDestinationHierarchySimple2() {
		Address5 address5 = new Address5();
		address5.setCity("City Name");
		address5.setStreet("Street Name");
//		Person2 person2 = new Person2();
//		person2.setAddress(address5);
		ModelMapper modelMapper = new ModelMapper();
		PersonDTO3 personDTO3 = modelMapper.map(address5, PersonDTO3.class);
		System.out.println(personDTO3);
	}
	
	@GetMapping("/test/model/mapper/destination/hierarchy/simple3")
	public void testModelMapperDestinationHierarchySimple3() {
		Address5 address5 = new Address5();
		address5.setCity("City Name");
		address5.setStreet("Street Name");
		Name name = new Name();
		name.setFirstName("fn");
		name.setLastName("ln");
		Person3 person3 = new Person3();
		person3.setAddress(address5);
		person3.setName(name);
		ModelMapper modelMapper = new ModelMapper();
		PersonDTO3 personDTO3 = modelMapper.map(person3, PersonDTO3.class);
		System.out.println(personDTO3);
	}
	
	@GetMapping("/test/model/mapper/destination/hierarchy/simple4")
	public void testModelMapperDestinationHierarchySimple4() {
		Address5 address51 = new Address5();
		address51.setCity("City Name1");
		address51.setStreet("Street Name1");
		Address5 address511 = new Address5();
		address511.setCity("City Name2");
		address511.setStreet("Street Name2");
		Name name = new Name();
		name.setFirstName("fn");
		name.setLastName("ln");
		Person4 person4 = new Person4();
		person4.setAddress2(address51);
		person4.setAddress1(address511);
		person4.setName(name);
		ModelMapper modelMapper = new ModelMapper();
		PersonDTO3 personDTO3 = modelMapper.map(person4, PersonDTO3.class);
		System.out.println(personDTO3);
	}

	@GetMapping("/test/model/mapper/destination/hierarchy/simple5")
	public void testModelMapperDestinationHierarchySimple5() {
		Address5 address51 = new Address5();
		address51.setCity("City Name1");
		address51.setStreet("Street Name1");
		Address5 address511 = new Address5();
		address511.setCity("City Name2");
		address511.setStreet("Street Name2");
		Name name = new Name();
		name.setFirstName("fn");
		name.setLastName("ln");
		Person4 person4 = new Person4();
		person4.setAddress2(address51);
		person4.setAddress1(address511);
		person4.setName(name);
		
		PropertyMap<Person4, PersonDTO3> personMap = new PropertyMap<Person4, PersonDTO3>() {
			protected void configure() {
				map().getAddress().setCity(source.getAddress1().getCity());
				map().getAddress().setStreet(source.getAddress2().getStreet());
				
			}
		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(personMap);
		PersonDTO3 personDTO3 = modelMapper.map(person4, PersonDTO3.class);
		System.out.println(personDTO3);
	}

	
	@GetMapping("/test/model/mapper/destination/hierarchy/complex1")
	public void testModelMapperDestinationHierarchyComplex1() {
		Address5 address51 = new Address5();
		address51.setCity("City Name1");
		address51.setStreet("Street Name1");
		Address5 address511 = new Address5();
		address511.setCity("City Name2");
		address511.setStreet("Street Name2");
		Name name = new Name();
		name.setFirstName("fn");
		name.setLastName("ln");
		Person4 person4 = new Person4();
		person4.setAddress2(address51);
		person4.setAddress1(address511);
		person4.setName(name);
		
		PropertyMap<Person4, PersonDTO4> personMap = new PropertyMap<Person4, PersonDTO4>() {
			protected void configure() {
				map().getAddress().setCity(source.getAddress1().getCity());
				map().getAddress().setStreet(source.getAddress2().getStreet());
			//	map().getAddress().getName().setFirstName(source.getName().getFirstName());
			//	map().getAddress().getName().setLastName(source.getName().getLastName());
				
			}
		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(personMap);
		PersonDTO4 personDTO4 = modelMapper.map(person4, PersonDTO4.class);
		System.out.println(personDTO4);
	}

}
