package com.company.day2.mvc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.day2.mvc.dao.IEmployeeDao;
import com.company.day2.mvc.domain.Employee;
import com.company.day2.mvc.util.JdbcUtil;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private JdbcUtil jdbcUtil;

	@Override
	public void save(Employee e) {
		jdbcUtil.getConnection();
		System.out.println("dao，保存对象");
	}
}
