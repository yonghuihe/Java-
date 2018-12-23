package com.conpany.hibernate.day01.hello.dao;

import java.util.List;

import com.conpany.hibernate.day01.hello.domain.Employee;

public interface IEmployeeDao {
	
	void save(Employee e);
	
	void delete(Long id);
	
	void update(Employee e);
	
	Employee get(Long id);
	
	List<Employee> query();
}
