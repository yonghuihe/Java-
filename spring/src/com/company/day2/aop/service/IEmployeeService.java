package com.company.day2.aop.service;

import java.util.List;

import com.company.day2.aop.domain.Employee;

public interface IEmployeeService {
	void save(Employee e);

	void update(Employee e);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> query();
}
