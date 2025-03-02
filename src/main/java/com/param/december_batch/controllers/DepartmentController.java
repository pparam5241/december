package com.param.december_batch.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.param.december_batch.entities.Department;
import com.param.december_batch.models.DepartmentRequest;
import com.param.december_batch.services.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;

	@PostMapping("/create")
	public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequest request) {
		Department department = departmentService.createDepartment(request);
		return ResponseEntity.ok(department);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Department>> fetchAllDepartments(){
		return ResponseEntity.ok(departmentService.fetchAllDepartments());
	}
	
	@PutMapping("/{departmentId}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(name = "departmentId") Long id, @RequestBody DepartmentRequest request) {
		return ResponseEntity.ok(departmentService.updateDepartment(id, request));
	}
	
	@DeleteMapping("/{departmentId}")
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable(name = "departmentId") Long id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok().build();
	}
}