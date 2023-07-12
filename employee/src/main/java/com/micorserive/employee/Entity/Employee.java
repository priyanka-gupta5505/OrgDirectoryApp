package com.micorserive.employee.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "employees" )
public class Employee {
	@Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastname;
	
	@Column(nullable = false, unique =  true)
	private String email;
	
	private String departmentCode;
	
	private String organizationCode;
	
	
	

}
