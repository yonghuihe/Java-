package com.conpany.hibernate.day02.many2one.dao;

import com.conpany.hibernate.day02.many2one.domain.Employee;

public interface IEmployeeDao {
	void save(Employee e);
	
	Employee get(Long id);
}
