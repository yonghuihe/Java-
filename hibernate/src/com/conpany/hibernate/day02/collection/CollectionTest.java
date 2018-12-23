package com.conpany.hibernate.day02.collection;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.util.HibernateUtil;

public class CollectionTest {

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
		
		d.getEmps().add(e2);
		d.getEmps().add(e1);
		
		for(int i = 0; i < d.getEmps().size(); i++ ){
			d.getEmps().get(i).setSequence(i);
		}
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(d);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Department department = (Department) session.get(Department.class, 1L);
		System.out.println(department.getEmps());
		
		session.getTransaction().commit();
		session.close();
	}
	
	
}
