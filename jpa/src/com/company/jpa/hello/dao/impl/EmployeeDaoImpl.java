package com.company.jpa.hello.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.company.jpa.hello.dao.IEmployeeDao;
import com.company.jpa.hello.domain.Employee;
import com.company.jpa.hello.util.JPAUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void save(Employee e) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		// 开启事务
		em.getTransaction().begin();
		// 持久化对象
		em.persist(e);
		// 提交事务
		em.getTransaction().commit();
		// 关闭EntityManager对象
		em.close();
	}

	@Override
	public void delete(Long id) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		//把持久化对象-->删除状态
		//类似于session.delete()方法，但是remove方法只能作用于持久化对象
		Employee e = em.find(Employee.class, 1L);
		em.remove(e);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(Employee e) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		//更新对象
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Employee get(Long id) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		
		Employee e = em.find(Employee.class, id);
		
		em.close();
		return e;
	}

	@Override
	public List<Employee> query() {
		EntityManager em = JPAUtil.getInstance().entityManager();
		System.out.println(em.getDelegate());//JPA委托给了SessionImpl对象，SessionImpl实现了Session接口
		
		//在JPA中，查询语句叫做JPQL，JPQL在语法和使用方式上和HQL90%相似
		//List<Employee> list = em.createQuery("SELECT e FROM Employee e").getResultList();
		List<Employee> list = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		
		em.close();
		return list;
	}

}
