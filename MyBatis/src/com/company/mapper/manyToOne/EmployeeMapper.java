package com.company.mapper.manyToOne;

import java.util.List;

import com.company.domain.Employee;

public interface EmployeeMapper {
	public void add(Employee employee);
	
	public Employee get(Long id);
	
	public List<Employee> list();
}
