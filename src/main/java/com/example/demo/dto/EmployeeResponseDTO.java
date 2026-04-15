package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDTO {
	private Long id;
	private String name;
	private String email;
	private String department;
	private String designation;
	private Double salary;
	private String city;
	private String status;
	private LocalDate joiningDate;

}
