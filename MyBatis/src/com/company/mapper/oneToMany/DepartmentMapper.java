package com.company.mapper.oneToMany;

import com.company.domain.Department;

public interface DepartmentMapper {
	
	public void add(Department department);

	public void delete(Long did);
	
	public Department get(Long did);
	
}
