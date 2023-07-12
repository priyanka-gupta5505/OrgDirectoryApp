package com.micorserive.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micorserive.employee.Dto.ApiResponseDto;
import com.micorserive.employee.Dto.EmployeeDto;
import com.micorserive.employee.Service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/employees")
@Tag(name = "Employee-Service - Employee Controller",
description = "Employee Controller Exposes REST APIs for Employee-Service")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Operation(summary = "Save Employee REST API",
			description = "Save Employee RESR API is used to save Employee object in a database")
	@ApiResponse(responseCode =  "201",
	description = "HTTP Status 201 CREATED")
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee (@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@Operation(summary = "GET Employee REST API",
			description = "GET Employee RESR API is used to get employee object in a database")
	@ApiResponse(responseCode =  "200",
	description = "HTTP Status 200 SUCESS")
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId){
		ApiResponseDto apiResponseDto = employeeService.getEmployeeId(employeeId);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
	

}
