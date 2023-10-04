package com.restApi.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
	@Autowired
	private  PositionRepository positionReposiotry;
	
	@GetMapping("/positions")
	public List<String> getDepartments() {
		return positionReposiotry.findAll();
	}
}
