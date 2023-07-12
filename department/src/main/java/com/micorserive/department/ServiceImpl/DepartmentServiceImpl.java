package com.micorserive.department.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micorserive.department.Entity.Department;
import com.micorserive.department.Repository.DepartmentRepository;
import com.micorserive.department.Service.DepartmentService;
import com.micorserive.department.dto.DepartmentDto;
@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		// convert department dto to jpa entity
		
		Department department = new Department(
		departmentDto.getId(),
		departmentDto.getDepartmentName(),
		departmentDto.getDepartmentDescription(),
		departmentDto.getDepartmentCode()
		);
		
	Department saveDepartment =	departmentRepository.save(department);
	DepartmentDto savedDepartmentDto = new DepartmentDto(
			saveDepartment.getId(),
			saveDepartment.getDepartmentCode(),
			saveDepartment.getDepartmentName(),
			saveDepartment.getDepartmentDescription());
	
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		DepartmentDto departmentDto = new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode());
		return departmentDto;
	}

}
