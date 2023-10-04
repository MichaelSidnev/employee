package com.restApi.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="Position")
@IdClass(PositionId.class)
public class Position {
	@Id
	private Integer employeeId;
	
	@Id
	private String position;
	
	public Position() {
	}
	
	public Position(String position, Integer employeeId) {
		this.position = position;
		this.employeeId = employeeId;
	}
}
