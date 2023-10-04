package com.restApi.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	@Autowired
	private  DepartmentRepository departmentReposiotry;
	
	@GetMapping("/departments")
	public List<String> getDepartments() {
		return departmentReposiotry.findAll();
	}
}
