package com.param.december_batch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.param.december_batch.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByName(String name);
}