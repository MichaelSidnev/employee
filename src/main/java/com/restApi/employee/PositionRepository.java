package com.restApi.employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface PositionRepository extends Repository<Position, Integer> {
	@Query(value = "select distinct p.position from Position p")
	List<String> findAll();
	
	@Query("select case when count(p)> 0 then true else false end from Position p where lower(p.position) = lower(:position)")
	boolean exists(@Param("position") String position);
	
	Position save(Position position);
}
