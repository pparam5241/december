package com.param.december_batch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.param.december_batch.entities.Department;
import com.param.december_batch.entities.Employee;
import com.param.december_batch.exceptions.DepartmentNotFoundException;
import com.param.december_batch.exceptions.EmployeeNotFoundException;
import com.param.december_batch.models.EmployeeRequest;
import com.param.december_batch.repositories.DepartmentRepository;
import com.param.december_batch.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public Employee createEmployee(EmployeeRequest request) {
		Department department = departmentRepository.findByName(request.getDepartmentName())
				.orElseThrow(() -> new DepartmentNotFoundException(
						"Department not found with Name : " + request.getDepartmentName()));
		Employee employee = Employee.builder().name(request.getEmployeeName()).dob(request.getDob())
				.doj(request.getDoj()).department(department).build();
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Long employeeId, EmployeeRequest request) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
		employee.setDob(request.getDob());
		employee.setDoj(request.getDoj());
		employee.setName(request.getEmployeeName());
		return employeeRepository.save(employee);
	}

	public void createEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with ID: " + id));
		employeeRepository.delete(employee);
	}
	
	public void moveAllTheEmployeesToSpecificDepartment(String name) {
		Department department = departmentRepository.findByName(name).orElseThrow(() -> new DepartmentNotFoundException("Department not found with name -> " + name));
		
		Long departmentId = department.getId();
		// update employee set department_id = :departmentId;
		employeeRepository.moveAllEmployeesToDepartment(departmentId);
	}
	
	public List<Employee> getEmployeesByDepartmentName(String name) {
		return employeeRepository.findByDepartment_Name(name);
	}
}