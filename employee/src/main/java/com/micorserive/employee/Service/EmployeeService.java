package com.micorserive.employee.Service;

import com.micorserive.employee.Dto.ApiResponseDto;
import com.micorserive.employee.Dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	ApiResponseDto getEmployeeId(Long employeeId);
}
