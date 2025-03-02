package com.param.december_batch.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.param.december_batch.entities.Department;
import com.param.december_batch.exceptions.DepartmentAlreadyExistsException;
import com.param.december_batch.exceptions.DepartmentNotFoundException;
import com.param.december_batch.models.DepartmentRequest;
import com.param.december_batch.repositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public Department createDepartment(DepartmentRequest request) {
		Optional<Department> opt = departmentRepository.findByName(request.getName());
		if (opt.isPresent()) {
			log.error("Department already exists with name {}", request.getName());
			throw new DepartmentAlreadyExistsException("Department already exists with name " + request.getName());
		}
		Department department = Department.builder().name(request.getName()).createdAt(LocalDate.now())
				.modifiedAt(LocalDate.now()).build();
		return departmentRepository.save(department);
	}

	public List<Department> fetchAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department updateDepartment(Long id, DepartmentRequest request) {
		Department department = departmentRepository.findById(id).orElseThrow(
				() -> new DepartmentNotFoundException("Department not found with name: " + request.getName()));
		department.setName(request.getName());
		department.setModifiedAt(LocalDate.now());
		return departmentRepository.save(department);
	}

	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
}