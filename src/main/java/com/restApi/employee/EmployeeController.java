package com.restApi.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		var employees = employeeRepository.findAll();
		return employees;
	}
	
	@GetMapping("/employee/{id}/details")
	public EmployeeDetails getEmployeeDetails(@PathVariable(value = "id", required = true) Integer id) {
		var employee = employeeRepository.findDetailsById(id);
		// there are no strict requirements so I use the most simple solution.
		return employee.orElse(null);
	}
	
	@GetMapping("/employees/details")
	public List<EmployeeDetails> getEmployeesDetails() {
		var employees = employeeRepository.findAllDetails();
		return employees;
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody EmployeeDetails employeeDetails) {
		var isPositionExists = positionRepository.exists(employeeDetails.getPosition());
		if (!isPositionExists) {
			return "Position is not exist.";
		}
		
		var isDepartmentExists = departmentRepository.exists(employeeDetails.getDepartment());
		if (!isDepartmentExists) {
			return "Department is not exist.";
		}
		
		var employee = new Employee(employeeDetails.getFirstName(), employeeDetails.getLastName());
		employeeRepository.save(employee);
		
		var position = new Position(employeeDetails.getPosition(), employee.getId());
		positionRepository.save(position);
		
		var department = new Department(
				employeeDetails.getDepartment(), 
				employeeDetails.getPosition(), 
				employeeDetails.getLastName());
		departmentRepository.save(department);
		
		return "OK";
	}
}
