package com.restApi.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


public interface EmployeeRepository extends Repository<Employee, Integer> {
	@Query(value = "select e.id, e.last_name, e.first_name from employee e", nativeQuery = true)
	List<Employee> findAll();
	
	@Query(value = "select new com.testTask.javaTask.EmployeeDetails(e.id, e.firstName, e.lastName, p.position, d.department) "
			+ "from Employee e "
			+ "left join Position p on p.employeeId = e.id "
			+ "left join Department d on d.position = p.position and d.lastName = e.lastName")
	List<EmployeeDetails> findAllDetails();
	
	@Query(value = "select new com.testTask.javaTask.EmployeeDetails(e.id, e.firstName, e.lastName, p.position, d.department) "
			+ "from Employee e "
			+ "left join Position p on p.employeeId = e.id "
			+ "left join Department d on d.position = p.position and d.lastName = e.lastName "
			+ "where e.Id = :id")
	Optional<EmployeeDetails> findDetailsById(@Param("id") Integer id);
	
	Employee save(Employee employee);
}
