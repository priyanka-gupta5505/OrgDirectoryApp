package com.micorserive.employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	
	private Long id;
	
	private String departmentName;
	
	private String departmentDescription;
	
	private String departmentCode;

}
