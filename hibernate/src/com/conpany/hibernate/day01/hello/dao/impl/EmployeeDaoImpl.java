package com.conpany.hibernate.day01.hello.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.conpany.hibernate.day01.hello.dao.IEmployeeDao;
import com.conpany.hibernate.day01.hello.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

@SuppressWarnings("all")
public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void save(Employee e) {
		Session session = HibernateUtil.getInstance().openSession();
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 执行业务方法
		session.save(e);
		// 提交事务
		tx.commit();
		// 关闭session对象
		session.close();
	}

	@Override
	public void delete(Long id) {
		Employee e = new Employee();
		e.setId(id);
		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Employee e) {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(e);
		tx.commit();
		session.close();
	}

	@Override
	public Employee get(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
		// 执行业务方法
		Employee employee = (Employee) session.get(Employee.class, id);
		// 关闭session
		session.close();
		return employee;
	}

	@Override
	public List<Employee> query() {
		Session session = HibernateUtil.getInstance().openSession();
		// 执行业务方法
		// 在hibernate中提供了一个专门用于查询的对象：Query，在这个对象中包含了：需要查询的HQL，和查询需要的参数
		// HQL可以简写：
		//		select e from com.conpany.hibernate.day01.hello.domain.Employee e
		//		select e from Employee e
		Query query = session.createQuery("select e from Employee e");
		// 调用Query的方法执行查询
		List<Employee> list = query.list();
		// 关闭session
		session.close();
		return list;
	}

}
