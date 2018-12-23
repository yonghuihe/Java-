package com.company.mapper.manyToOne;

import com.company.domain.Department;

public interface DepartmentMapper {
	
	public void add(Department department);
	
	public Department get(Long id);
}
