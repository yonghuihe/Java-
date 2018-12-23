package com.company.jpa.hello.dao;

import java.util.List;

import com.company.jpa.hello.domain.Employee;

public interface IEmployeeDao {
	
	void save(Employee e);
	
	void delete(Long id);
	
	void update(Employee e);
	
	Employee get(Long id);
	
	List<Employee> query();
}
