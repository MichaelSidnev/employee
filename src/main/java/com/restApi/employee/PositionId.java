package com.restApi.employee;

import java.io.Serializable;

import jakarta.persistence.Column;

public class PositionId implements Serializable {
	private Integer employeeId;

    private String position;

    public PositionId() {
    	
    }

    public PositionId(Integer employeeId, String position) {
        this.employeeId = employeeId;
        this.position = position;
    }
	
}
