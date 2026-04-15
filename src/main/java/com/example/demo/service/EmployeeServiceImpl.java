package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private final EmployeeRepository  employeeRepository;

	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
		Employee employee = Employee.builder()
				.name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .department(requestDTO.getDepartment())
                .designation(requestDTO.getDesignation())
                .salary(requestDTO.getSalary())
                .city(requestDTO.getCity())
                .build();
		Employee saved =employeeRepository.save(employee);

		return mapToResponseDTO(saved);
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(long id) {
		Employee  employee =employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		         return mapToResponseDTO(employee);
	}

	@Override
	public List<EmployeeResponseDTO> getALlEmployee() {
	
		return employeeRepository.findAll()
				.stream()
				.map(this::mapToResponseDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesByDepartment(String department) {
		
		return employeeRepository.findByDepartment(department)
				.stream()
				.map(this::mapToResponseDTO)
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO  requestDTO) {
		Employee  existing =employeeRepository.findById(id)
				  .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		         
		        		  
		        		// toBuilder() = copy all existing fields, then override only what changed
		        	        Employee updated = existing.toBuilder()
		        	        		.id(existing.getId())
		        	                .name(requestDTO.getName())
		        	                .email(requestDTO.getEmail())
		        	                .department(requestDTO.getDepartment())
		        	                .designation(requestDTO.getDesignation())
		        	                .salary(requestDTO.getSalary())
		        	                .city(requestDTO.getCity())
		        	                .build();
		        	 
		        	        Employee saved = employeeRepository.save(updated);
		        	        return mapToResponseDTO(saved);
	}

	@Override
	public String deleteEmployee(long id) {
		 if (!employeeRepository.existsById(id)) {
	            throw new RuntimeException("Employee not found with id: " + id);
	        }
	        employeeRepository.deleteById(id);
		return " Emsufully ployee deleted su";
	}
	
	
	
	
	
	//HELPER: Entity → ResponseDTO mapping using @Builder
	
	private EmployeeResponseDTO mapToResponseDTO(Employee employee)
	{
		return EmployeeResponseDTO.builder() 	
				.id(employee.getId())
				.name(employee.getName())
				.email(employee.getEmail())
				.department(employee.getDepartment())
				.designation(employee.getDesignation())
				.salary(employee.getSalary())
				.city(employee.getCity())
				.status(employee.getStatus())
				.joiningDate(employee.getJoiningDate())
				.build();
	}

	

}
