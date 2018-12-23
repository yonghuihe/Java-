package com.company.day1.mvc.dao.impl;

import com.company.day1.mvc.dao.IEmployeeDao;
import com.company.day1.mvc.domain.Employee;
import com.company.day1.mvc.util.JdbcUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	private JdbcUtil jdbcUtil;
	public void setJdbcUtil(JdbcUtil jdbcUtil) {
		this.jdbcUtil = jdbcUtil;
	}

	@Override
	public void save(Employee e) {
		jdbcUtil.getConnection();
		System.out.println("dao，保存对象");
	}
}
