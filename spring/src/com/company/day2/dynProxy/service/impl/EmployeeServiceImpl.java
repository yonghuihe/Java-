package com.company.day2.dynProxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.day2.dynProxy.dao.IEmployeeDao;
import com.company.day2.dynProxy.domain.Employee;
import com.company.day2.dynProxy.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public void save(Employee e) {
		employeeDao.save(e);
	}

	@Override
	public void update(Employee e) {
		employeeDao.update(e);
	}

}
