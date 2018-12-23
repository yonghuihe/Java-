package com.company.day2.aop.dao;

import java.util.List;

import com.company.day2.aop.domain.Employee;

public interface IEmployeeDao {
	void save(Employee e);

	void update(Employee e);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> query();
}
