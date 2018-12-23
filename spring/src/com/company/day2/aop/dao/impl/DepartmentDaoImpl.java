package com.company.day2.aop.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.company.day2.aop.dao.IDepartmentDao;
import com.company.day2.aop.domain.Department;

@Repository
public class DepartmentDaoImpl extends JdbcDaoSupport implements IDepartmentDao {

	@Override
	public void save(Department d) {
		System.out.println("dao.save(" + d + ")");
	}

	@Override
	public void update(Department d) {
		System.out.println("dao.update(" + d + ")");
	}

}
