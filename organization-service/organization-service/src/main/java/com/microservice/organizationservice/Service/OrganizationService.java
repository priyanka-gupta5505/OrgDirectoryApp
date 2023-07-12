package com.microservice.organizationservice.Service;

import com.microservice.organizationservice.Dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganizatio(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizationByCode(String OrganizationCode);
	
}
