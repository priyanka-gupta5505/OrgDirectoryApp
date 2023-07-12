package com.microservice.organizationservice.Dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
		description = "OranizationDto Model Information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
	
	private Long id;
	
	@Schema(description = "Oranization name")
	private String organizationName;
	
	@Schema(description = "Oranization description")
	private String organizationDescription;
	
	@Schema(description = "Oranization code")
	private String organizationCode;
	
	@Schema(description = "Oranization createdDate")
	private LocalDateTime createdDate;

}
