package com.restApi.employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends Repository<Department, Integer>{
	@Query(value = "select distinct d.department from Department d")
	List<String> findAll();
	
	@Query("select case when count(d)> 0 then true else false end from Department d where lower(d.department) = lower(:department)")
	boolean exists(@Param("department") String department);
	
	Department save(Department department);
}
