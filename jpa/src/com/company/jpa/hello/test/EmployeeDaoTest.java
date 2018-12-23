package com.company.jpa.hello.test;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.dao.IEmployeeDao;
import com.company.jpa.hello.dao.impl.EmployeeDaoImpl;
import com.company.jpa.hello.domain.Employee;
import com.company.jpa.hello.util.JPAUtil;

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
		dao.delete(1L);
	}
	
	@Test
	public void testUpdate() {
		Employee e = new Employee();
		e.setAge(23);
		e.setHiredate(new Date());
		e.setName("宝宝");
		e.setId(1L);
		dao.update(e);
	}
	
	@Test
	public void testGet() throws Exception {
		Employee employee = dao.get(1L);
		System.out.println(employee);
	}

	@Test
	public void testQuery() throws Exception {
		List<Employee> list = dao.query();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	@Before
	public void testSave2() {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		for (int j = 1; j <= 10; j++) {			
			Employee e = new Employee();
			e.setAge(j);
			//e.setHiredate(new Date());
			e.setName("name"+j);
			em.persist(e);
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testQuery2(){
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		//如果只查询一种实体对象，建议使用TypedQuery
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE name LIKE ?",Employee.class);
		
		//分页的两个方法和Hibernate的Query相同
		List<Employee> list = query.setFirstResult(0).setMaxResults(5).getResultList();
		System.out.println(list);
		
		//如果确定结果集只有一行，使用getSingleResult===hibernate中的uniqueResult
		query.getSingleResult();
		
		//JPA中，查询参数的顺序从1开始
		List<Employee> emps = query.setParameter(1, "%m%").getResultList();
		System.out.println(emps);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
