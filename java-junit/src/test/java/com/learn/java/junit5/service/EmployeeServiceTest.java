package com.learn.java.junit5.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learn.java.junit5.collection.Employee;
import com.learn.java.junit5.repository.EmployeeAutogeneratedRepository;

public class EmployeeServiceTest {

	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceTest.class);
	//Which service we want to test
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	//declare the dependencies
//	private EmployeeAPIsDeclWithQueryRepository empApisDeclWithQueryRepo;

	@Mock
	private EmployeeAutogeneratedRepository empAutogeneratedRepo;

	@BeforeEach
	void setup() {
		LOGGER.info("Initializing before each tests.");
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveEmployeeTest() {
		LOGGER.info("Testing saveEmployee Operation");
		//Given
		Employee employee = Employee
				.builder()
				.name("emp1")
				.department("dept1")
				.salary(123.4f)
				.dateOfJoining(new Date(System.currentTimeMillis()))
				.build();
		
		Employee savedEmployee = Employee
				.builder()
				.name("emp1")
				.department("dept1")
				.salary(123.4f)
				.id("123enen2onrjlwfw")
				.build();
		
		//Mock the calls
		Mockito.when(empAutogeneratedRepo.save(null)).thenReturn(new RuntimeException("Employee object should not be null."));
		Mockito.when(empAutogeneratedRepo.save(employee)).thenReturn(savedEmployee);
				
		//When
		savedEmployee = employeeService.saveEmployee(employee);
		
		//Then
		Assertions.assertNotNull(savedEmployee);
		Assertions.assertEquals(savedEmployee.getName(), "emp1");
		Assertions.assertEquals(savedEmployee.getDepartment(), "dept1");
		
		//Verify empAutogeneratedRepo.save(employee); calls only once (in employeeService.saveEmployee(employee); ) 
		verify(empAutogeneratedRepo, times(1)).save(employee);
		
		
		//When		
		//Then
		Assertions.assertThrows(NullPointerException.class, () -> employeeService.saveEmployee(null));

		LOGGER.info("Tested saveEmployee Operation");
	}
	
	
	@Test
	public void getEmployeeTest() {
		LOGGER.info("Testing getEmployee Operation");
		//Given
		Employee employee = Employee
				.builder()
				.name("emp1")
				.department("dept1")
				.salary(123.4f)
				.dateOfJoining(new Date(System.currentTimeMillis()))
				.build();
		String id = "21";
		
		//Mock the calls
//		Mockito.when(empAutogeneratedRepo.findById(null)).thenThrow(new IllegalArgumentException("Employee id should not be null."));
		Mockito.when(empAutogeneratedRepo.findById(id)).thenReturn(Optional.of(employee));
				
		//When
		Employee savedEmployee = employeeService.getEmployee(id);
		
		//Then
		Assertions.assertNotNull(savedEmployee);
		Assertions.assertEquals(savedEmployee.getName(), "emp1");
		Assertions.assertEquals(savedEmployee.getDepartment(), "dept1");
		
		//Verify empAutogeneratedRepo.save(employee); calls only once (in employeeService.saveEmployee(employee); ) 
		verify(empAutogeneratedRepo, times(1)).findById(id);
		
		
		//When		
		//Then
		NullPointerException npe = Assertions.assertThrows(NullPointerException.class, () -> employeeService.getEmployee(null));
		Assertions.assertEquals("Employee id should not be null.", npe.getMessage());
		
		LOGGER.info("Tested getEmployee Operation");
	}

	
	@Test
	public void updateEmployeeTest() {
		LOGGER.info("Testing updateEmployee Operation");
		//Given
		Employee employee = Employee
				.builder()
				.name("emp1")
				.department("dept1")
				.salary(123.4f)
				.dateOfJoining(new Date(System.currentTimeMillis()))
				.build();
		Employee updatedEmployee = Employee
				.builder()
				.name("emp1Updated")
				.department(employee.getDepartment())
				.salary(employee.getSalary())
				.dateOfJoining(employee.getDateOfJoining())
				.build();
		String id = "21";
		String name = "emp1Updated";
		
		//Mock the calls
//		Mockito.when(empAutogeneratedRepo.findById(null)).thenThrow(new IllegalArgumentException("Employee id should not be null."));
		Mockito.when(empAutogeneratedRepo.findById(id)).thenReturn(Optional.of(employee));
		Mockito.when(empAutogeneratedRepo.save(employee)).thenReturn(updatedEmployee);
		
		//When
		Employee savedEmployee = employeeService.updateEmployee(id, name);
		
		//Then
		Assertions.assertNotNull(savedEmployee);
		Assertions.assertEquals(savedEmployee.getName(), "emp1Updated");
		Assertions.assertEquals(savedEmployee.getDepartment(), "dept1");
		
		//Verify empAutogeneratedRepo.save(employee); calls only once (in employeeService.saveEmployee(employee); ) 
		verify(empAutogeneratedRepo, times(1)).findById(id);
		verify(empAutogeneratedRepo, times(1)).save(employee);
		
		
		//When		
		//Then
		NullPointerException npe = Assertions.assertThrows(NullPointerException.class, () -> employeeService.updateEmployee(null, "something"));
		Assertions.assertEquals("Employee id should not be null.", npe.getMessage());
		
		npe = Assertions.assertThrows(NullPointerException.class, () -> employeeService.updateEmployee("something", ""));
		Assertions.assertEquals("Employee name should not be null.", npe.getMessage());
		
		
		LOGGER.info("Tested updateEmployee Operation");
	}
	
	@Test
	public void deleteEmployeeTest() {
		LOGGER.info("Testing deleteEmployee Operation");
		//Given
		Employee employee = Employee
				.builder()
				.name("emp1")
				.department("dept1")
				.salary(123.4f)
				.dateOfJoining(new Date(System.currentTimeMillis()))
				.build();
		String id = "21";
		//Mock the calls
//		Mockito.when(empAutogeneratedRepo.save(employee)).thenReturn(updatedEmployee);

		
		//When
		String response = employeeService.deleteEmployee(id);
		
		//Then
		Assertions.assertEquals("Employee Deleted Successfully", response);

		LOGGER.info("Tested deleteEmployee Operation");
	}
}