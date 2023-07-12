package com.micorserive.department.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micorserive.department.Service.DepartmentService;
import com.micorserive.department.dto.DepartmentDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/department")
@AllArgsConstructor
@Tag(name = "Department-Service - Department Controller",
description = "Department Controller Exposes REST APIs for Department-Service")
public class DepartmentController {

	private DepartmentService departmentService;
	
	@Operation(summary = "Save Department REST API",
			description = "Save Department RESR API is used to save department object in a database")
	@ApiResponse(responseCode =  "201",
	description = "HTTP Status 201 CREATED")
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
	}
	@Operation(summary = "GET Department REST API",
			description = "GET Department RESR API is used to get department object in a database")
	@ApiResponse(responseCode =  "200",
	description = "HTTP Status 200 SUCESS")
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
		
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

}
