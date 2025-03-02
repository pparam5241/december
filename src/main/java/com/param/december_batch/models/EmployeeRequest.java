package com.param.december_batch.models;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequest {
	
	private String departmentName;

	private String employeeName;

	private Date doj;

	private Date dob;
}