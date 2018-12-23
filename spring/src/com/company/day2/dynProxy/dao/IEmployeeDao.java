package com.company.day2.dynProxy.dao;

import com.company.day2.dynProxy.domain.Employee;

public interface IEmployeeDao {
	void save(Employee e);

	void update(Employee e);
}
