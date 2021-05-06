package com.otp.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otp.testing.model.Employee;
import com.otp.testing.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public String getResultIfRunning() {
		
		return "Running!";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		 List<Employee> allEmployees = employeeService.getAllEmployees();
		 
		 return new ResponseEntity<>(allEmployees, HttpStatus.OK);
		 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId) {
		
		Employee foundEmployee = employeeService.findEmployeeById(empId);
		return new ResponseEntity(foundEmployee, HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
		
		Employee addedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity(addedEmployee, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity(updatedEmployee, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") Long id){
		
		employeeService.deleteEmployee(id);
	}
	
	

}
