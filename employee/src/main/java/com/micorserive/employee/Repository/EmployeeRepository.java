package com.micorserive.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micorserive.employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
