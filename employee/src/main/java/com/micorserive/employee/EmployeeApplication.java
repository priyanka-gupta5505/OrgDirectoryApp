package com.micorserive.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Priyanka",
						email = "priyanka.gupta@gmail.com"
				),
		license = @License(
				name = "Apache 2.0")
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee-Service Doc")
			)
@SpringBootApplication
//@EnableFeignClients
public class EmployeeApplication {
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	

}
