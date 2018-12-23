package com.conpany.hibernate.day03.component.test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day03.component.domain.Address;
import com.conpany.hibernate.day03.component.domain.Company;
import com.conpany.hibernate.util.HibernateUtil;

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
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Company company = (Company) session.get(Company.class, 1L);
		System.out.println(company);
		
		session.getTransaction().commit();
		session.close();
	}
}
