package com.otp.testing.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otp.testing.annotation.TrackExecutionTime;
import com.otp.testing.exception.UserNotFoundException;
import com.otp.testing.model.Employee;
import com.otp.testing.repo.EmployeeRepo;

@Service
public class EmployeeService{
	
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee employee) {
		
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
		
	}
	
	@TrackExecutionTime
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
		
	}
	
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
		
	}
	
	@Transactional
	public void deleteEmployee(Long employeeId) {
		employeeRepo.deleteEmployeeById(employeeId);
	}
	
	
	public Employee findEmployeeById(Long employeeId) {
		
		return employeeRepo.findById(employeeId).
				orElseThrow(
						()-> new UserNotFoundException("User with userId " + employeeId + 
								" not found in the database"));
	}
}
