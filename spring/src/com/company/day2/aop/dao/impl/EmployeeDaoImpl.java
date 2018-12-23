package com.company.day2.aop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.company.day2.aop.dao.IEmployeeDao;
import com.company.day2.aop.domain.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements IEmployeeDao {

	@Override
	public void save(Employee e) {
		this.getJdbcTemplate().update("INSERT INTO employee (name,age,password)values(?,?,?)",
				new Object[] { e.getName(), e.getAge(), e.getPassword() });
	}

	@Override
	public void update(Employee e) {
		this.getJdbcTemplate().update("update employee set name = ?,age = ?,password=? WHERE id = ?",
				new Object[] { e.getName(), e.getAge(), e.getPassword(), e.getId() });
	}

	@Override
	public void delete(Long id) {
		this.getJdbcTemplate().update("DELETE FROM employee WHERE id = ?", id);

	}

	@Override
	public Employee get(Long id) {
		Employee employee = this.getJdbcTemplate().query("SELECT * FROM employee WHERE id = ?",
				new ResultSetExtractor<Employee>() {
					@Override
					public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							Employee e = new Employee();
							e.setId(rs.getLong("id"));
							e.setName(rs.getString("name"));
							e.setAge(rs.getInt("age"));
							e.setPassword(rs.getString("password"));
							System.out.println(e);
							return e;
						}
						return null;
					}
				}, id);
		return employee;
	}

	@Override
	public List<Employee> query() {
		List<Employee> employees = this.getJdbcTemplate().query("SELECT * FROM employee",
				new ResultSetExtractor<List<Employee>>() {
					@Override
					public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<Employee> emps = new ArrayList<Employee>();
						while (rs.next()) {
							Employee e = new Employee();
							e.setId(rs.getLong("id"));
							e.setAge(rs.getInt("age"));
							e.setName(rs.getString("name"));
							e.setPassword(rs.getString("password"));
							emps.add(e);
						}
						return emps;
					}
				});
		return employees;
	}

}
