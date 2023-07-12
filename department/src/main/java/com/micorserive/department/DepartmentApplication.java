package com.micorserive.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Deparment Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Priyanka",
						email = "priyanka.gupta@gmail.com"
				),
		license = @License(
				name = "Apache 2.0")
		),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service Doc")
			)
		
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

}
