package com.param.december_batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.param.december_batch.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}