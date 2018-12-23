package com.company.day2.dynProxy.dao.impl;

import com.company.day2.dynProxy.dao.IDepartmentDao;
import com.company.day2.dynProxy.domain.Department;

public class DepartmentDaoImpl implements IDepartmentDao {

	@Override
	public void save(Department d) {
		System.out.println("dao.save(" + d + ")");
	}

	@Override
	public void update(Department d) {
		System.out.println("dao.update(" + d + ")");
	}

}
