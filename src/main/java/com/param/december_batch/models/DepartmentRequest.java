package com.param.december_batch.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DepartmentRequest {
	private String name;
}