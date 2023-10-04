package com.restApi.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
@IdClass(DepartmentId.class)
public class Department {
	private String department;
	
	@Id
	private String position;
	
	@Id
	private String lastName;
	
	public Department() {
	}
	
	public Department(String department, String position, String lastName) {
		this.department = department;
		this.position = position;
		this.lastName = lastName;
	}
}
