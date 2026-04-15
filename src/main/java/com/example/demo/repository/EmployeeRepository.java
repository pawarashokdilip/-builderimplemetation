package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// find by department
	List<Employee> findByDepartment(String department);

	// find by status

	List<Employee> findByStatus(String status);

	// find by email
	Optional<Employee> findByEmail(String email);

	// check email is exist
	boolean existsByEmail(String email);

}