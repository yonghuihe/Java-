package com.company.jpa.component;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.util.JPAUtil;

public class ComponentTest {

	@Before
	public void testSave() throws Exception {
		Company c = new Company();
		c.setName("name");
		
		Address a1 = new Address();
		a1.setProvice("provice");
		a1.setCity("city");
		a1.setStreet("street");
		
		Address a2 = new Address();
		a2.setProvice("reg_provice");
		a2.setCity("reg_city");
		a2.setStreet("reg_street");
		
		c.setAddress(a1);
		c.setRegAddress(a2);
		
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.persist(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testGet() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Company company = em.find(Company.class, 1L);
		System.out.println(company);
		
		em.getTransaction().commit();
		em.close();
	}
}
