package com.conpany.hibernate.day01.property;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.util.HibernateUtil;

public class EmployeePropertyTest {

	@Test
	public void testSetEmployeeProperty() throws Exception {
		EmployeeProperty employeeProperty = new EmployeeProperty();
		employeeProperty.setFirstName("firstName");
		employeeProperty.setLastName("lastName");
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		session.save(employeeProperty);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGetEmployeeProperty() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		EmployeeProperty ep = (EmployeeProperty) session.get(EmployeeProperty.class, 2L);
		System.out.println(ep);
		session.getTransaction().commit();
		session.close();
	}
}
