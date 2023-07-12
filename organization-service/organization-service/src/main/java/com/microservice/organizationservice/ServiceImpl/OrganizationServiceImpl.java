package com.microservice.organizationservice.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.organizationservice.Dto.OrganizationDto;
import com.microservice.organizationservice.Entity.Organization;
import com.microservice.organizationservice.Mapper.OrganizationMapper;
import com.microservice.organizationservice.Repository.OrganizationRepository;
import com.microservice.organizationservice.Service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public OrganizationDto saveOrganizatio(OrganizationDto organizationDto) {

		// convert OrganizationDto into Organization jpa entity

		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		Organization savedOrganization = organizationRepository.save(organization);
		return OrganizationMapper.mapToOrganizationDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {

Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

return OrganizationMapper.mapToOrganizationDto(organization);
		
	}

}
