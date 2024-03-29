package com.learn.java.mysql.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mysql.model.dto.HouseDto;
import com.learn.java.mysql.model.entity.AddressM2MBi;
import com.learn.java.mysql.model.entity.AddressM2MUni;
import com.learn.java.mysql.model.entity.AddressNPlus1Problem;
import com.learn.java.mysql.model.entity.AddressO2OBi;
import com.learn.java.mysql.model.entity.AddressO2OUni;
import com.learn.java.mysql.model.entity.AddressO2OUniShared;
import com.learn.java.mysql.model.entity.Author;
import com.learn.java.mysql.model.entity.Book;
import com.learn.java.mysql.model.entity.Car;
import com.learn.java.mysql.model.entity.Customer;
import com.learn.java.mysql.model.entity.DepartmentM2MBi;
import com.learn.java.mysql.model.entity.DepartmentM2MUni;
import com.learn.java.mysql.model.entity.DepartmentM2OAndO2MBidirectional;
import com.learn.java.mysql.model.entity.DepartmentM2OUnidirectional;
import com.learn.java.mysql.model.entity.DepartmentO2MUnidirectional;
import com.learn.java.mysql.model.entity.DepartmentO2OBi;
import com.learn.java.mysql.model.entity.DepartmentO2OUni;
import com.learn.java.mysql.model.entity.DepartmentO2OUniShared;
import com.learn.java.mysql.model.entity.EmployeeM2OAndO2MBidirectional;
import com.learn.java.mysql.model.entity.EmployeeM2OUnidirectional;
import com.learn.java.mysql.model.entity.EmployeeO2MUnidirectional;
import com.learn.java.mysql.model.entity.House;
import com.learn.java.mysql.model.entity.Name;
import com.learn.java.mysql.model.entity.ParkingSpace;
import com.learn.java.mysql.model.entity.Person;
import com.learn.java.mysql.model.entity.PersonAddress;
import com.learn.java.mysql.model.entity.Truck;
import com.learn.java.mysql.model.entity.Vehicle;
import com.learn.java.mysql.model.entity.VehicleBrochure;
import com.learn.java.mysql.repository.AddressM2MBiRepository;
import com.learn.java.mysql.repository.AddressM2MUniRepository;
import com.learn.java.mysql.repository.AddressO2OBiRepository;
import com.learn.java.mysql.repository.AddressO2OUniRepository;
import com.learn.java.mysql.repository.AddressO2OUniSharedRepository;
import com.learn.java.mysql.repository.CustomerRepository;
import com.learn.java.mysql.repository.DepartmentM2MBiRepository;
import com.learn.java.mysql.repository.DepartmentM2MUniRepository;
import com.learn.java.mysql.repository.DepartmentM2OAndO2MBidirectionalRepository;
import com.learn.java.mysql.repository.DepartmentM2OUnidirectionRepository;
import com.learn.java.mysql.repository.DepartmentO2MUnidirectionalRepository;
import com.learn.java.mysql.repository.DepartmentO2OBiRepository;
import com.learn.java.mysql.repository.DepartmentO2OUniRepository;
import com.learn.java.mysql.repository.DepartmentO2OUniSharedRepository;
import com.learn.java.mysql.repository.EmployeeM2OAndO2MBidirectionalRepository;
import com.learn.java.mysql.repository.EmployeeM2OUnidirectionRepository;
import com.learn.java.mysql.repository.EmployeeO2MUnidirectionalRepository;
import com.learn.java.mysql.repository.HouseJpqlRepository;
import com.learn.java.mysql.repository.ParkingSpaceRepository;
import com.learn.java.mysql.repository.PersonAddressRepository;
import com.learn.java.mysql.repository.PersonRepository;
import com.learn.java.mysql.repository.VehicleBrochureRepository;
import com.learn.java.mysql.repository.VehicleRepository;
import com.learn.java.mysql.service.EntityRelationshipService;
import com.learn.java.mysql.util.FileUtils;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

@Service
public class EntityRelationshipServiceImpl implements EntityRelationshipService {
	
	
	@Autowired
	private VehicleBrochureRepository vehicleBrochureRepo;

	@Autowired
	private ParkingSpaceRepository parkingSpaceRepo;

	@Autowired
	private HouseJpqlRepository houseJpqlRepo;
	
	@Autowired
	private PersonAddressRepository personAddressRepo;

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private AddressM2MBiRepository addressM2MBiRepo;

	@Autowired
	private DepartmentM2MBiRepository departmentM2MBiRepo;

	@Autowired
	private AddressM2MUniRepository addressM2MUniRepo;

	@Autowired
	private DepartmentM2MUniRepository departmentM2MUniRepo;

	@Autowired
	private AddressO2OUniSharedRepository addressO2OUniSharedRepo;

	@Autowired
	private DepartmentO2OUniSharedRepository departmentO2OUniSharedRepo;

	@Autowired
	private AddressO2OBiRepository addressO2OBiRepo;

	@Autowired
	private DepartmentO2OBiRepository departmentO2OBiRepo;

	@Autowired
	private AddressO2OUniRepository addressO2OUniRepo;

	@Autowired
	private DepartmentO2OUniRepository departmentO2OUniRepo;

	@Autowired
	private DepartmentO2MUnidirectionalRepository departmentO2MUnidirectionalRepo;

	@Autowired
	private EmployeeO2MUnidirectionalRepository employeeO2MUnidirectionalRepo;

	@Autowired
	private DepartmentM2OUnidirectionRepository departmentM2OUnidirectionRepo;

	@Autowired
	private EmployeeM2OUnidirectionRepository employeeM2OUnidirectionRepo;

	@Autowired
	private DepartmentM2OAndO2MBidirectionalRepository departmentM2OAndO2MBidirectionalRepo;

	@Autowired
	private EmployeeM2OAndO2MBidirectionalRepository employeeM2OAndO2MBidirectionalRepository;

	@Override
	public void testManyToOneUnidirection() {
		DepartmentM2OUnidirectional department = null;
		try {
			department = departmentM2OUnidirectionRepo.findById(1L).get();
		} catch (Exception e) {
			System.out.println("Error");
		}
		if (Objects.isNull(department)) {
			department = departmentM2OUnidirectionRepo
					.save(DepartmentM2OUnidirectional.builder().name("dName123").build());
		}
		EmployeeM2OUnidirectional employee = employeeM2OUnidirectionRepo
				.save(EmployeeM2OUnidirectional.builder().name("emp123").department(department).build());
		System.out.println("Department: " + department);
		System.out.println("Employee: " + employee);
	}

	@Override
	public void testManyToOneBidirection() {

		// Many Side To One Side
		DepartmentM2OAndO2MBidirectional department = null;
		try {
			department = departmentM2OAndO2MBidirectionalRepo.findById(1L).get();
		} catch (Exception e) {
			System.out.println("Error");
		}
		if (Objects.isNull(department)) {
			department = departmentM2OAndO2MBidirectionalRepo
					.save(DepartmentM2OAndO2MBidirectional.builder().name("dName123")
							// .employees(Arrays.asList(employee, employee2))
							.build());
		}

		System.out.println("Department: " + department);

		EmployeeM2OAndO2MBidirectional employee = employeeM2OAndO2MBidirectionalRepository
				.save(EmployeeM2OAndO2MBidirectional.builder().name("emp123").department(department).build());
		EmployeeM2OAndO2MBidirectional employee2 = employeeM2OAndO2MBidirectionalRepository
				.save(EmployeeM2OAndO2MBidirectional.builder().name("emp1234").department(department).build());

		System.out.println("Employee : " + employee);
		System.out.println("Employee 2 : " + employee2);

		// this will work is mapped by set to 'One', that means foreign key at
		// department side so it will work fine.
		// One Side To Many Side // department_id is null // do not use below code to
		// save data.
//		EmployeeM2OAndO2MBidirectional employee3 = employeeM2OAndO2MBidirectionalRepository.save(EmployeeM2OAndO2MBidirectional.builder().name("emp3").build());
//		EmployeeM2OAndO2MBidirectional employee4 = employeeM2OAndO2MBidirectionalRepository.save(EmployeeM2OAndO2MBidirectional.builder().name("emp4").build());
//		department = departmentM2OAndO2MBidirectionalRepo
//				.save(DepartmentM2OAndO2MBidirectional
//						.builder()
//						.name("dName123")
//						.employees(Arrays.asList(employee3, employee4))
//						.build());
//		
//		System.out.println("Employee 3 : "+employee3);
//		System.out.println("Employee 4 : "+employee4);
//		System.out.println("Department : "+department);
//		

	}

	@Override
	public void testOneToManyUnidirection() {
		DepartmentO2MUnidirectional department = null;
		EmployeeO2MUnidirectional employee5 = employeeO2MUnidirectionalRepo
				.save(EmployeeO2MUnidirectional.builder().name("emp5").build());
		EmployeeO2MUnidirectional employee6 = employeeO2MUnidirectionalRepo
				.save(EmployeeO2MUnidirectional.builder().name("emp6").build());
		department = departmentO2MUnidirectionalRepo.save(DepartmentO2MUnidirectional.builder().name("dName123")
				.employees(Arrays.asList(employee5, employee6)).build());

		System.out.println("Employee 5 : " + employee5);
		System.out.println("Employee 6 : " + employee6);
		System.out.println("Department : " + department);

	}

	@Override
	public void testOneToOneUni() {
		AddressO2OUni addressO2OUni = addressO2OUniRepo
				.save(AddressO2OUni.builder().street("Ram Nagar").city("Pune").build());
		DepartmentO2OUni departmentO2OUni = departmentO2OUniRepo
				.save(DepartmentO2OUni.builder().name("Maths").address(addressO2OUni).build());
		System.out.println("Address : " + addressO2OUni);
		System.out.println("Department : " + departmentO2OUni);

	}

	@Override
	public void testOneToOneBi() {
		AddressO2OBi addressO2OBi = addressO2OBiRepo
				.save(AddressO2OBi.builder().street("Ram Nagar").city("Pune").build());
		DepartmentO2OBi departmentO2OBi = departmentO2OBiRepo
				.save(DepartmentO2OBi.builder().name("Maths").address(addressO2OBi).build());
		System.out.println("Address : " + addressO2OBi);
		System.out.println("Department : " + departmentO2OBi);
	}

	@Override
	public void testOneToOneUniSharedPk() {
		AddressO2OUniShared addressO2OUniShared = addressO2OUniSharedRepo
				.save(AddressO2OUniShared.builder().street("Ram Nagar").city("Pune").build());
		DepartmentO2OUniShared departmentO2OUniShared = departmentO2OUniSharedRepo
				.save(DepartmentO2OUniShared.builder().name("Maths").address(addressO2OUniShared).build());
		System.out.println("Address : " + addressO2OUniShared);
		System.out.println("Department : " + departmentO2OUniShared);
	}

	@Override
	public void testManyToManyUni() {
		AddressM2MUni addressM2MUni = addressM2MUniRepo
				.save(AddressM2MUni.builder().street("Ram Nagar1").city("Pune1").build());
		AddressM2MUni addressM2MUni2 = addressM2MUniRepo
				.save(AddressM2MUni.builder().street("Ram Nagar2").city("Pune2").build());
		AddressM2MUni addressM2MUni3 = addressM2MUniRepo
				.save(AddressM2MUni.builder().street("Ram Nagar3").city("Pune3").build());

		DepartmentM2MUni departmentM2MUni = departmentM2MUniRepo.save(DepartmentM2MUni.builder().name("Maths1")
				.addresses(Arrays.asList(addressM2MUni, addressM2MUni2)).build());
		DepartmentM2MUni departmentM2MUni2 = departmentM2MUniRepo.save(DepartmentM2MUni.builder().name("Maths2")
				.addresses(Arrays.asList(addressM2MUni2, addressM2MUni3)).build());

		System.out.println("Department1 : " + departmentM2MUni);
		System.out.println("Department2 : " + departmentM2MUni2);

	}

	@Override
	public void testManyToManyBi() {
		AddressM2MBi addressM2MBi1 = addressM2MBiRepo
				.save(AddressM2MBi.builder().street("Ram Nagar1").city("Pune1").build());
		AddressM2MBi addressM2MBi2 = addressM2MBiRepo
				.save(AddressM2MBi.builder().street("Ram Nagar2").city("Pune2").build());
		AddressM2MBi addressM2MBi3 = addressM2MBiRepo
				.save(AddressM2MBi.builder().street("Ram Nagar3").city("Pune3").build());

		DepartmentM2MBi departmentM2MBi1 = departmentM2MBiRepo.save(DepartmentM2MBi.builder().name("Maths1")
				.addresses(Arrays.asList(addressM2MBi1, addressM2MBi2)).build());
		DepartmentM2MBi departmentM2MBi2 = departmentM2MBiRepo.save(DepartmentM2MBi.builder().name("Maths2")
				.addresses(Arrays.asList(addressM2MBi2, addressM2MBi3)).build());
		DepartmentM2MBi departmentM2MBi3 = departmentM2MBiRepo.save(DepartmentM2MBi.builder().name("Maths3").build());

		System.out.println("Department1 : " + departmentM2MBi1);
		System.out.println("Department2 : " + departmentM2MBi2);
		System.out.println("Department3 : " + departmentM2MBi3);
	}

	@Override
	public void testManyToManyBiCascade() {
		AddressM2MBi addressM2MBi1 = AddressM2MBi.builder().street("Ram Nagar1").city("Pune1").build();
		AddressM2MBi addressM2MBi2 = AddressM2MBi.builder().street("Ram Nagar2").city("Pune2").build();
		AddressM2MBi addressM2MBi3 = AddressM2MBi.builder().street("Ram Nagar3").city("Pune3").build();
		DepartmentM2MBi departmentM2MBi1 = departmentM2MBiRepo.save(DepartmentM2MBi.builder().name("Maths1")
				.addresses(Arrays.asList(addressM2MBi1, addressM2MBi2)).build());
		DepartmentM2MBi departmentM2MBi2 = departmentM2MBiRepo.save(DepartmentM2MBi.builder().name("Maths2")
				.addresses(Arrays.asList(addressM2MBi2, addressM2MBi3)).build());
		System.out.println("Department1 : " + departmentM2MBi1);
		System.out.println("Department2 : " + departmentM2MBi2);

	}

	@Override
	public void testIMSingleTable() {
		addVehicles();
	}

	@Override
	public void testIMJoinedTable() {
		addVehicles();

	}

	@Override
	public void testIMTablePerClass() {
		addVehicles();
	}

	private void addVehicles() {
		Vehicle tataCar = new Car("TATA", 120, "No");
		Vehicle tataTruck = new Truck("TATA", 100, 1200);

		Vehicle mahindraCar = new Car("Mahindra", 125, "Yes");
		Vehicle mahindraTruck = new Truck("Mahindra", 90, 1000);

		vehicleRepository.save(tataCar);
		vehicleRepository.save(tataTruck);
		vehicleRepository.save(mahindraCar);
		vehicleRepository.save(mahindraTruck);
	}

	@Override
	public void testNPlus1ProblemAndSolutions() {
//		saveCustomers();

		/*
		 *  N+1 Problem 
		 */
//		try {
//			System.out.println("");
//			System.out.println("");
//			showCustomers();
//			System.out.println("");
//			System.out.println("");
//		} catch (Exception e) {
//			System.out.println("showCustomers"+e);
//		}

		/*
		 * Solution 1
		 */
//		try {
//			System.out.println("");
//			System.out.println("");
//			showCustomersWithEntityGraph();
//			System.out.println("");
//			System.out.println("");
//		} catch (Exception e) {
//			System.out.println("showCustomersWithEntityGraph"+e);
//		}

		/*
		 * Solution 2
		 */
//		try {
//			System.out.println("");
//			System.out.println("");
//			showCustomersWithJoinFetch();
//			System.out.println("");
//			System.out.println("");
//		} catch (Exception e) {
//			System.out.println("showCustomersWithJoinFetch"+e);
//		}

	
//		/*
//		 * Solution 3
//		 */		
//		try {
//			System.out.println("");
//			System.out.println("");
//			showCustomers(); // but fields are annotated with @BatchSize
//			System.out.println("");
//			System.out.println("");
//		} catch (Exception e) {
//			System.out.println("showCustomersWithJoinFetch"+e);
//		}

		
		/*
		 * Solution 4
		 */		
		try {
			System.out.println("");
			System.out.println("");
			showCustomers(); // but fields are annotated with @Fetch(FetchMode.SUBSELECT)
			System.out.println("");
			System.out.println("");
		} catch (Exception e) {
			System.out.println("showCustomersWithJoinFetch"+e);
		}

		
		System.out.println("testedEntityGraph");

	}

	private void saveCustomers() {
		AddressNPlus1Problem address1 = AddressNPlus1Problem.builder().city("Pune1").street("Katraj Road 1").build();
		AddressNPlus1Problem address2 = AddressNPlus1Problem.builder().city("Pune2").street("Katraj Road 2").build();
		AddressNPlus1Problem address3 = AddressNPlus1Problem.builder().city("Pune3").street("Katraj Road 3").build();
		AddressNPlus1Problem address4 = AddressNPlus1Problem.builder().city("Pune4").street("Katraj Road 4").build();
		AddressNPlus1Problem address5 = AddressNPlus1Problem.builder().city("Pune5").street("Katraj Road 5").build();
		AddressNPlus1Problem address6 = AddressNPlus1Problem.builder().city("Pune6").street("Katraj Road 6").build();

		Author author1 = Author.builder().name("author1").build();
		Author author2 = Author.builder().name("author2").build();
		Author author3 = Author.builder().name("author3").build();
		Author author4 = Author.builder().name("author4").build();
		Author author5 = Author.builder().name("author5").build();
		Author author6 = Author.builder().name("author6").build();

		Book book1 = Book.builder().name("book1").author(author1).build();
		Book book2 = Book.builder().name("book2").author(author2).build();
		Book book3 = Book.builder().name("book3").author(author3).build();
		Book book4 = Book.builder().name("book4").author(author4).build();
		Book book5 = Book.builder().name("book5").author(author5).build();
		Book book6 = Book.builder().name("book6").author(author6).build();

		List<Book> books1 = Arrays.asList(book1, book2);
		List<Book> books2 = Arrays.asList(book3, book4);
		List<Book> books3 = Arrays.asList(book5, book6);

		Customer cust1 = Customer.builder().name("cname1").address(address1).books(books1).build();
		Customer cust2 = Customer.builder().name("cname2").address(address2).books(books2).build();
		Customer cust3 = Customer.builder().name("cname3").address(address3).books(books3).build();

		// save all
		try {
			customerRepo.saveAll(Arrays.asList(cust1, cust2, cust3));
		} catch (Exception e) {
			System.out.println("saveAll"+e);
		}
		
	}

	private void showCustomersWithJoinFetch() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c join fetch c.address addr join fetch c.books b join fetch b.author a", Customer.class).getResultList();
		System.out.println("is cust empty" + Objects.isNull(customers));
		customers.stream().forEach(d -> {

			System.out.println("customer name : " + d.getName());
			System.out.println("address : " + d.getAddress());
			d.getBooks().stream().forEach(b -> {
				System.out.println("book name: " + b.getName());
				System.out.println("book author : " + b.getAuthor());

			});

		});
		entityManager.clear();
		entityManager.clear();		
	}

	private void showCustomersWithEntityGraph() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityGraph<Customer> graph = entityManager.createEntityGraph(Customer.class);
		graph.addAttributeNodes("address");
		graph.addSubgraph("books").addAttributeNodes("author");

		List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c", Customer.class)
				.setHint("jakarta.persistence.fetchgraph", graph).getResultList();
		System.out.println("is cust empty" + Objects.isNull(customers));
		customers.stream().forEach(d -> {

			System.out.println("customer name : " + d.getName());
			System.out.println("address : " + d.getAddress());
			d.getBooks().stream().forEach(b -> {
				System.out.println("book name: " + b.getName());
				System.out.println("book author : " + b.getAuthor());

			});

		});
		entityManager.clear();
		entityManager.clear();

	}

	private void showCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
		System.out.println("is cust empty : " + Objects.isNull(customers));
		
		System.out.println("");
		System.out.println("");
		customers.stream().forEach(d -> {
			System.out.println("\n customer name : " + d.getName());
			System.out.println("\n address : " + d.getAddress());
			d.getBooks().stream().forEach(b -> {
				System.out.println("\n book name: " + b.getName());
				System.out.println("\n book author : " + b.getAuthor());
			});
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				
			}

		});
		System.out.println("");
		System.out.println("");
		entityManager.clear();
		entityManager.clear();

	}

	@Override
	public void testCompositePK() {
		Name name1 = Name.builder().firstName("fn1").lastName("ln1").build();
		Person person = Person.builder().email("a@b.com").name(name1).build();
		personRepo.save(person);
		personRepo.findAll();
		
	}

	@Override
	public void testCompositeFK() {
		Name name1 = Name.builder().firstName("fn1").lastName("ln1").build();
		Person person = Person.builder().email("a@b.com").name(name1).build();
		personRepo.save(person);
		personAddressRepo.save(PersonAddress.builder().city("pune").street("sb road").person(person).build());
		
		personRepo.findAll();		
		personAddressRepo.findAll();
	}

	
	@Override
	public void testJoins() {
//		saveHouseAndParking();
//		houseJpqlRepo.save(House.builder().ownerName("owner7").build());
//		parkingSpaceRepo.save(ParkingSpace.builder().parkingName("Parking7").build());
		System.out.println("Inner Join: "+houseJpqlRepo.findHouseAndParking());
		System.out.println("\n");
		System.out.println("Left Join: "+houseJpqlRepo.leftJoin());
		System.out.println("\n");
		System.out.println("Right Join: "+houseJpqlRepo.rightJoin());
		System.out.println("\n");
		System.out.println("Full Join: "+houseJpqlRepo.fullJoin());
		System.out.println("\n");

	}

	private void saveHouseAndParking() {
		ParkingSpace parking1 = parkingSpaceRepo.save(ParkingSpace.builder().parkingName("Parking1").build());
		ParkingSpace parking2 = parkingSpaceRepo.save(ParkingSpace.builder().parkingName("Parking2").build());
		ParkingSpace parking3 = parkingSpaceRepo.save(ParkingSpace.builder().parkingName("Parking3").build());
		ParkingSpace parking4 = parkingSpaceRepo.save(ParkingSpace.builder().parkingName("Parking4").build());
		ParkingSpace parking5 = parkingSpaceRepo.save(ParkingSpace.builder().parkingName("Parking5").build());
		
		houseJpqlRepo.save(House.builder().ownerName("owner2").parking(parking3).build());

		
		houseJpqlRepo.save(House.builder().ownerName("owner2").parking(parking2).build());

		
		houseJpqlRepo.save(House.builder().ownerName("owner3").parking(parking4).build());

		
		houseJpqlRepo.save(House.builder().ownerName("owner4").parking(parking1).build());
		
		
		houseJpqlRepo.save(House.builder().ownerName("owner5").parking(parking5).build());
	}

	@Override
	public void testCriteriaQueries() {
//		testBasicCriteriaQueries();	
//		testJoinCriteriaQueries();
		testSubQueryCriteriaQueries();
	}

	private void testSubQueryCriteriaQueries() {
		// Declaration
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		System.out.println("1");
		CriteriaQuery<HouseDto> criteriaQuery =  criteriaBuilder.createQuery(HouseDto.class);
		System.out.println("2");
		Root<House> fromHouseClass = criteriaQuery.from(House.class);
		
		Subquery<Long> subQuery = criteriaQuery.subquery(Long.class);
		Root<House> subQueryRoot = subQuery.correlate(fromHouseClass);
//		Join<House, ParkingSpace> join = subQueryRoot.join("parking", JoinType.INNER);
//		subQuery.select(criteriaBuilder.count(join));
		subQuery.select(criteriaBuilder.count(subQueryRoot.get("ownerName")));
		subQuery.groupBy(subQueryRoot.get("ownerName"));
//		subQuery.select(subQuery);
		
		
		System.out.println("3");
//		Predicate numberOfEntriesForEachUserName = criteriaBuilder.ge(subQuery, 2L);
//	    criteriaQuery.where(numberOfEntriesForEachUserName);
		criteriaQuery.having(criteriaBuilder.ge(subQuery, 2L));
	    System.out.println("4");
//		criteriaQuery.multiselect(criteriaBuilder.count(fromHouseClass), fromHouseClass.get("ownerName"));
		criteriaQuery.groupBy(fromHouseClass.get("ownerName"));
	    System.out.println("5");
		criteriaQuery.multiselect(criteriaBuilder.count(fromHouseClass.get("ownerName")), fromHouseClass.get("ownerName"));
		
		
		System.out.println("6");
//		criteriaQuery.where(criteriaBuilder.ge(hroot.get("number"), 2L));
//		
		TypedQuery<HouseDto> houses = entityManager.createQuery(criteriaQuery);
		
		System.out.println("");
		houses.getResultStream().forEach(System.out::println);
	}
	
	private void testJoinCriteriaQueries() {
		// Declaration
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		System.out.println("1");
		CriteriaQuery<Tuple> criteriaQuery =  criteriaBuilder.createTupleQuery();
		System.out.println("2");
		Root<House> fromHouseClass = criteriaQuery.from(House.class);
//		Join<House, ParkingSpace> join = fromHouseClass.join("parking", JoinType.INNER);
//		Join<House, ParkingSpace> join = fromHouseClass.join("parking", JoinType.LEFT);
		Join<House, ParkingSpace> join = fromHouseClass.join("parking", JoinType.RIGHT);
		
		criteriaQuery.multiselect(fromHouseClass, join);
		
		TypedQuery<Tuple> tuple = entityManager.createQuery(criteriaQuery);
		
		System.out.println("");
		tuple.getResultStream().forEach(t -> {
			System.out.print(" T[0]:"+ t.get(0));
			System.out.print(" T[1]:"+ t.get(1));
			System.out.println("");
		});
	}

	private void testBasicCriteriaQueries() {
		
		// Declaration
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		System.out.println("1");
//		CriteriaQuery<Object[]> criteriaQuery =  criteriaBuilder.createQuery(Object[].class);
		CriteriaQuery<HouseDto> criteriaQuery =  criteriaBuilder.createQuery(HouseDto.class);
		System.out.println("2");
		Root<House> fromHouseClass = criteriaQuery.from(House.class);
		
		// Conditions ( Predicates(filtering), selecting, orderings ...)
		System.out.println("3");
		Order descOrder = criteriaBuilder.desc(fromHouseClass.get("ownerName"));
		
		Predicate idGreaterThanEqualTo3 = criteriaBuilder.ge(fromHouseClass.get("id"), 3);
		Expression<Number> sum = criteriaBuilder.sum(fromHouseClass.get("id"));
		criteriaQuery.multiselect(sum, fromHouseClass.get("ownerName"));//, fromHouseClass.get("parking"));
		// If ParkingSpace Object is null that record is not selected even condition is true => why like this?
		
//		If id or ownerName field is null that recode is selected depends on condition => correct way
//		criteriaQuery.multiselect(fromHouseClass.get("id"), fromHouseClass.get("ownerName")
		
		// group by and order by column should be same 
		// while grouping, do not include other Object/Entities.
		criteriaQuery.orderBy(descOrder);
		criteriaQuery.groupBy(fromHouseClass.get("ownerName"));
		criteriaQuery.where(idGreaterThanEqualTo3);
		
		// Execute
		System.out.println("");
		System.out.println("");
		System.out.println("4");
//		List<Object[]> houses = entityManager.createQuery(criteriaQuery).getResultList();
		List<HouseDto> houseDtoList = entityManager.createQuery(criteriaQuery).getResultList();
		
		
		
		
		// Print Output
		System.out.println("");
		System.out.println("");
		System.out.println("5");
		try {
			houseDtoList.stream().forEach(System.out::println);
//			houses.stream().forEach(obj -> {
//				Arrays.asList(obj).stream().forEach(System.out::print);
//				System.out.println("");
//			});
			System.out.println("6");
		} catch (Exception e) {
			
		}
		System.out.println("7");		
	}

	@Override
	public void testBlobStorage() {
		byte[] textBlobStorage = null;
		try {
			textBlobStorage = FileUtils.loadFileContent("./dropTable.sql");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VehicleBrochure vehicleBrochure = VehicleBrochure.builder().brouchureTitle("dropTable.sql").brouchureData(textBlobStorage).build();
		vehicleBrochureRepo.save(vehicleBrochure);
		VehicleBrochure result = 	vehicleBrochureRepo.findFirstByBrouchureTitle("dropTable.sql");
		System.out.println(" title: "+ result.getBrouchureTitle());
		System.out.println(" Data Length: "+ result.getBrouchureData().length);
		
	}

}
