package com.microservice.organizationservice.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.organizationservice.Dto.OrganizationDto;
import com.microservice.organizationservice.Service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/organizations")
@Tag(name = "Organization-Service - Organization Controller",
description = "Organization Controller Exposes REST APIs for Organization-Service")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	// Build Save Organization REST API

	@Operation(summary = "Save Organization REST API",
			description = "Save Organization RESR API is used to save Employee object in a database")
	@ApiResponse(responseCode =  "201",
	description = "HTTP Status 201 CREATED")
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

		OrganizationDto savedOrganization = organizationService.saveOrganizatio(organizationDto);
		return new ResponseEntity<OrganizationDto>(savedOrganization, HttpStatus.CREATED);

	}
	@Operation(summary = "GET Organization REST API",
			description = "GET Organization RESR API is used to get organization object in a database")
	@ApiResponse(responseCode =  "200",
	description = "HTTP Status 200 SUCESS")
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
	OrganizationDto organizationDto =	organizationService.getOrganizationByCode(organizationCode);
	return ResponseEntity.ok(organizationDto);
	}

}
