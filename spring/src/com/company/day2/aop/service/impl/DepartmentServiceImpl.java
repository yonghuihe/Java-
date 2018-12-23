package com.company.day2.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.day2.aop.dao.IDepartmentDao;
import com.company.day2.aop.domain.Department;
import com.company.day2.aop.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentDao DepartmentDao;

	@Override
	public void save(Department d) {
		DepartmentDao.save(d);
		int i = 1/0;
	}

	@Override
	public void update(Department d) {
		DepartmentDao.update(d);
	}

}
