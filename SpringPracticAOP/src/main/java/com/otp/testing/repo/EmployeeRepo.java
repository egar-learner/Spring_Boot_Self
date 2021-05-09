package com.otp.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otp.testing.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	void deleteEmployeeById(Long id);

}
