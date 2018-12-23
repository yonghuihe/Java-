package com.conpany.hibernate.day01.hello.test;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.conpany.hibernate.day01.hello.dao.IEmployeeDao;
import com.conpany.hibernate.day01.hello.dao.impl.EmployeeDaoImpl;
import com.conpany.hibernate.day01.hello.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class EmployeeDaoTest {

	private IEmployeeDao dao;

	public EmployeeDaoTest() {
		dao = new EmployeeDaoImpl();
	}

	@Test
	public void testSave() {
		Employee e = new Employee();
		e.setAge(22);
		e.setHiredate(new Date());
		e.setName("jack");
		dao.save(e);
	}
	
	@Test
	public void testDelete() {
		dao.delete(8L);
	}
	
	@Test
	public void testUpdate() {
		Employee e = new Employee();
		e.setAge(23);
		e.setHiredate(new Date());
		e.setName("宝宝");
		e.setId(7L);
		dao.update(e);
	}
	
	@Test
	public void testGet() throws Exception {
		Employee employee = dao.get(5L);
		System.out.println(employee);
	}

	@Test
	public void testQuery() throws Exception {
		List<Employee> list = dao.query();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void testSession() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		Employee e1 = (Employee) session.get(Employee.class, 7L);
		
		session.evict(e1);
		
		session = HibernateUtil.getInstance().openSession();
		Employee e2 = (Employee) session.get(Employee.class, 7L);
		System.out.println(e1 == e2);
	}
	
	@Test
	public void testTransaction1() throws Exception {
		Employee e = new Employee("tx",10,new Date());
		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		dao.save(e);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testTransaction2() throws Exception {
		Employee e = new Employee("tx",10,new Date());
		
		Session session = null;
		try{
			session = HibernateUtil.getInstance().openSession();
			session.beginTransaction();//标记当前事务正常开始了
			dao.save(e);
			session.getTransaction().commit();
		} catch (HibernateException ex){//在hibernate中，把所有JDBC的异常都封装到了HibernateException中了
			ex.printStackTrace();
			if (session != null && session.getTransaction().isActive()){//当前事务是正常活动的
				session.getTransaction().rollback();
			}
		} finally {
			if(session != null && session.isOpen()){//当前session处于开启状态
				session.close();
			}
		}
	}
}
