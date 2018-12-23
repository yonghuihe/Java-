package com.company.day2.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.day2.mvc.dao.IEmployeeDao;
import com.company.day2.mvc.domain.Employee;
import com.company.day2.mvc.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public void save(Employee e) {
		employeeDao.save(e);
		System.out.println("service,保存对象");
	}
}
