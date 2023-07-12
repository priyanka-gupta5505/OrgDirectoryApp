package com.microservice.organizationservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.organizationservice.Entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	Organization findByOrganizationCode(String OrganizationCode);
	

}
