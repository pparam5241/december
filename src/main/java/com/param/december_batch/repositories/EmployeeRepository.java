package com.param.december_batch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.param.december_batch.entities.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "update employee set department_id = :departmentId", nativeQuery = true)
	void moveAllEmployeesToDepartment(Long departmentId);
	
	List<Employee> findByDepartment_Name(String name);
}