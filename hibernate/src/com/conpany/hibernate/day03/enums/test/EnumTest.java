package com.conpany.hibernate.day03.enums.test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day03.enums.domain.Employee;
import com.conpany.hibernate.day03.enums.domain.Sex;
import com.conpany.hibernate.util.HibernateUtil;

public class EnumTest {

	@Before
	public void testSave() throws Exception {
		Employee e = new Employee();
		e.setName("name");
		e.setSex(Sex.FEMALE);
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(e);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, 1L);
		System.out.println(employee);
		
		session.getTransaction().commit();
		session.close();
	}
}
