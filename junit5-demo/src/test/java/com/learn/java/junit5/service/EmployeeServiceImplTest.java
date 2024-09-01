package com.learn.java.junit5.service;

import com.learn.java.junit5.model.Employee;
import com.learn.java.junit5.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    static String id = UUID.randomUUID().toString();

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this); // Initialize mocks
//    }

    @Test
    void getEmployeeAsString() {

        Optional<Employee> emp = Optional.of(new Employee(id, "emp1", 22));

        when(employeeRepository.findById(anyString())).thenReturn(emp);

        String result = employeeService.getEmployeeAsString();
        assertNotNull(result);
        assertTrue(result.contains(id));
        assertTrue(result.contains("emp1"));
        assertTrue(result.contains("22"));
    }

    @Test
    void getEmployee() {
        Optional<Employee> emp = Optional.of(new Employee(id, "emp1", 22));

        when(employeeRepository.findById(anyString())).thenReturn(emp);

        Employee result = employeeService.getEmployee();
        assertNotNull(result);
        assertTrue(result.getId().equals(id));
        assertEquals(result.getName(), emp.get().getName());
        assertTrue(result.getAge() == emp.get().getAge());
    }

    @Test
    void saveEmployee() {
        Employee emp = new Employee(id, "emp1", 22);

        when(employeeRepository.save(emp)).thenReturn(emp);

        Employee result = employeeService.saveEmployee(emp);
        assertNotNull(result);
        assertTrue(result.getId().equals(id));
        assertEquals(result.getName(), emp.getName());
        assertTrue(result.getAge() == emp.getAge());
    }
}