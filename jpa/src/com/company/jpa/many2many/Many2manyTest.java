package com.company.jpa.many2many;

import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.util.JPAUtil;


public class Many2manyTest {
	@Before
	public void testSave() throws Exception {
		Teacher t1 = new Teacher();
		t1.setName("t1");
		Teacher t2 = new Teacher();
		t2.setName("t2");
		
		Student s1 = new Student();
		s1.setName("s1");
		Student s2 = new Student();
		s2.setName("s2");
		
		t1.getStudents().add(s1);
		t2.getStudents().add(s1);
		t1.getStudents().add(s2);
		t2.getStudents().add(s2);
		
		s1.getTeachers().add(t1);
		s2.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		s2.getTeachers().add(t2);
		
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.persist(t1);
		em.persist(t2);
		
		em.persist(s1);
		em.persist(s2);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testGet() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Teacher teacher = em.find(Teacher.class, 1L);
		Set<Student> students = teacher.getStudents();
		System.out.println(teacher);
		System.out.println(students);
		
		em.getTransaction().commit();
		em.close();
	}
}
