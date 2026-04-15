package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestDTO {
	
	 private String name;
	    private String email;
	    private String department;
	    private String designation;
	    private Double salary;
	    private String city;

}
