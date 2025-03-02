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

import com.param.december_batch.entities.Employee;
import com.param.december_batch.models.EmployeeRequest;
import com.param.december_batch.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest request) {
		return ResponseEntity.ok(service.createEmployee(request));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(service.getAllEmployees());
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeRequest request,
			@PathVariable Long employeeId) {
		return ResponseEntity.ok(service.updateEmployee(employeeId, request));
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(name = "employeeId") Long id) {
		service.createEmployee(id);
		return ResponseEntity.ok().build();
	}
}