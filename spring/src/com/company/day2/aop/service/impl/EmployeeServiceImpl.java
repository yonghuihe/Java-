package com.company.day2.aop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.day2.aop.dao.IEmployeeDao;
import com.company.day2.aop.domain.Employee;
import com.company.day2.aop.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public void save(Employee e) {
		employeeDao.save(e);
	}

	@Override
	public void update(Employee e) {
		int i = 1/0;
		employeeDao.update(e);
	}

	@Override
	public void delete(Long id) {
		employeeDao.delete(id);

	}

	@Override
	public Employee get(Long id) {
		Employee employee = employeeDao.get(id);
		return employee;
	}

	@Override
	public List<Employee> query() {
		List<Employee> query = employeeDao.query();
		return query;
	}

}
