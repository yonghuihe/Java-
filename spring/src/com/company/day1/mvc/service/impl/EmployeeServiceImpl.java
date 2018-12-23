package com.company.day1.mvc.service.impl;

import com.company.day1.mvc.dao.IEmployeeDao;
import com.company.day1.mvc.domain.Employee;
import com.company.day1.mvc.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao employeeDao;
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void save(Employee e) {
		employeeDao.save(e);
		System.out.println("service,保存对象");
	}
}
