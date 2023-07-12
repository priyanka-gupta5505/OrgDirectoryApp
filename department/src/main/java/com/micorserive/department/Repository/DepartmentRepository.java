package com.micorserive.department.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micorserive.department.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}
