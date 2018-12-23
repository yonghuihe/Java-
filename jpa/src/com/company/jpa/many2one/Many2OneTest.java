package com.company.jpa.many2one;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.util.JPAUtil;

public class Many2OneTest {
	@Before
	public void testSave() throws Exception {
		Employee e1 = new Employee();
		e1.setName("e1");
		Employee e2 = new Employee();
		e2.setName("e2");
		
		Department dept = new Department();
		dept.setName("dept");
		
		e1.setDept(dept);
		e2.setDept(dept);
		
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.persist(dept);
		em.persist(e1);
		em.persist(e2);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testGet() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, 1L);
		Department dept = e.getDept();
		System.out.println("-------------------");
		System.out.println(e);
		System.out.println(dept);
		
		em.getTransaction().commit();
		em.close();
	}
}
