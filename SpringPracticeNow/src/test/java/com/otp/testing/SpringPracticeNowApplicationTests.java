package com.otp.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.otp.testing.model.Employee;
import com.otp.testing.repo.EmployeeRepo;
import com.otp.testing.service.EmployeeService;

@SpringBootTest
class SpringPracticeNowApplicationTests {
	
	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	EmployeeRepo employeeRepo;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void testAddEmployee() { 
		Employee emp = new Employee(1L, "Manish", "sample@gmail.com", "73530", "url", "emplCode", "oneMore");
		when(employeeRepo.save(emp)).thenReturn(emp);
		
		Employee returnedEmp = employeeService.addEmployee(emp);
		
		assertEquals(emp.getEmail(), returnedEmp.getEmail());
		
	}
	

}
