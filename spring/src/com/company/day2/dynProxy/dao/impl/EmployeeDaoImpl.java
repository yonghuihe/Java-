package com.company.day2.dynProxy.dao.impl;

import com.company.day2.dynProxy.dao.IEmployeeDao;
import com.company.day2.dynProxy.domain.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void save(Employee e) {
		System.out.println("dao.save(" + e + ")");
	}

	@Override
	public void update(Employee e) {
		System.out.println("dao.update(" + e + ")");
	}

}
