package com.conpany.hibernate.day03.many2many.test;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day03.many2many.domain.Student;
import com.conpany.hibernate.day03.many2many.domain.Teacher;
import com.conpany.hibernate.util.HibernateUtil;

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
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(t1);
		session.save(t2);
		
		session.save(s1);
		session.save(s2);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Teacher teacher = (Teacher) session.get(Teacher.class, 1L);
		Set<Student> students = teacher.getStudents();
		System.out.println(teacher);
		System.out.println(students);
		
		session.getTransaction().commit();
		session.close();
	}
}
