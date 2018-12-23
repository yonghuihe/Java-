package com.company.jpa.one2many;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.util.JPAUtil;

public class One2ManyTest {
	@Before
	public void testSave() throws Exception {
		Employee e1 = new Employee();
		e1.setName("e1");
		Employee e2 = new Employee();
		e2.setName("e2");
		
		Department d = new Department();
		d.setName("d");
		
		d.getEmps().add(e2);
		d.getEmps().add(e1);
		
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.persist(d);
		em.persist(e1);
		em.persist(e2);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testGet() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Department dept = em.find(Department.class, 1L);
		List<Employee> emps = dept.getEmps();
		System.out.println(emps);
		/*for (Employee employee : emps) {			
			System.out.println(employee);
		}*/
		
		em.getTransaction().commit();
		em.close();
	}
}
