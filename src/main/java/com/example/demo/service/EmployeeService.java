package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;

public interface EmployeeService {
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);

	EmployeeResponseDTO getEmployeeById(long id);

List<EmployeeResponseDTO>	 getALlEmployee();

	List<EmployeeResponseDTO> getEmployeesByDepartment(String department);

	EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO);

	String deleteEmployee(long id);
}
