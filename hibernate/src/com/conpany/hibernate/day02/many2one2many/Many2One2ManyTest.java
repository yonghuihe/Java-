package com.conpany.hibernate.day02.many2one2many;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.util.HibernateUtil;

public class Many2One2ManyTest {

	@Before
	public void testSave() throws Exception {
		
		Employee e1 = new Employee();
		e1.setName("e1");

		Employee e2 = new Employee();
		e2.setName("e2");
		
		Department d = new Department();
		d.setName("d");
		
		e1.setDept(d);
		e2.setDept(d);
		
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(d);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDeleteMany() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, 1L);
		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDeleteOne() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Department department = (Department) session.get(Department.class, 1L);
		session.delete(department);
		
		session.getTransaction().commit();
		session.close();
	}
}
