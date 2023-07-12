package com.micorserive.employee.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.micorserive.employee.Dto.ApiResponseDto;
import com.micorserive.employee.Dto.DepartmentDto;
import com.micorserive.employee.Dto.EmployeeDto;
import com.micorserive.employee.Dto.OrganizationDto;
import com.micorserive.employee.Entity.Employee;
import com.micorserive.employee.Repository.EmployeeRepository;
import com.micorserive.employee.Service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;

//	@Autowired
//	private APIClient apiClient;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub

		LOGGER.info("inside getEmployeeById() method");

		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartmentCode(), employeeDto.getOrganizationCode());

		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDto saveEmployee = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastname(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode(),
				savedEmployee.getOrganizationCode());

		return saveEmployee;
	}

	// @CircuitBreaker(name = "${spring.application.name}", fallbackMethod =
	// "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeId(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId).get();

//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8080/api/department/" + employee.getDepartmentCode(), DepartmentDto.class);
//		
//		DepartmentDto departmentDto =
//
//				apiClient.getDepartment(employee.getDepartmentCode());
		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/department/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

		OrganizationDto organizationDto = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve()
				.bodyToMono(OrganizationDto.class).block();
		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastname(),
				employee.getEmail(), employee.getDepartmentCode(), employee.getOrganizationCode());

		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setOrganizationDto(organizationDto);
		return apiResponseDto;
	}

	public ApiResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

		LOGGER.info("inside getDefaultDepartment() method");
		Employee employee = employeeRepository.findById(employeeId).get();

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D Department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development Department");
		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastname(),
				employee.getEmail(), employee.getDepartmentCode(), employee.getOrganizationCode());

		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);

		return apiResponseDto;
	}

}
