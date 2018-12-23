package com.company.day2.dynProxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.day2.dynProxy.dao.IDepartmentDao;
import com.company.day2.dynProxy.domain.Department;
import com.company.day2.dynProxy.service.IDepartmentService;

public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentDao DepartmentDao;

	@Override
	public void save(Department d) {
		DepartmentDao.save(d);
	}

	@Override
	public void update(Department d) {
		DepartmentDao.update(d);
	}

}
