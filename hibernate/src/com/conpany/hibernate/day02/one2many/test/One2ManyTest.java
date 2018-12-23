package com.conpany.hibernate.day02.one2many.test;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day02.one2many.domain.Department;
import com.conpany.hibernate.day02.one2many.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class One2ManyTest {
	/**
	 * 现在是one方（department）维护SQL，所以保存了employee之后，总会再发送两条SQL来更新数据（一共5条SQL）
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Department d = new Department();
		d.setName("d");
		
		Employee e1 = new Employee();
		e1.setName("e1");

		Employee e2 = new Employee();
		e2.setName("e2");
		
		
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
	
	/**
	 * 1.通过one方得到many方，是一个延迟加载
	 * 2.one方中的many方属性是一个集合，这个集合只能使用接口
	 * 3.不能通过ifnull来判断one方是否有many方，只能通过集合的size()方法来判断
	 * 	load方法总会返回一个对象，
	 * 	size方法：在使用这个集合的时候就会发送一条SQL把employee查出来，如果查不到，集合的size为0,
	 * 4.在session关闭之前必须使用集合对象，否则就会报no session错误
	 * @throws Exception
	 */
	@Test
	public void testGet() throws Exception {
	
		Session session = HibernateUtil.getInstance().openSession();

		Department dept = (Department) session.get(Department.class, 1L);
		Set<Employee> emps = dept.getEmps();
		System.out.println(dept);
		System.out.println("===========");
		//class org.hibernate.collection.internal.PersistentSet
		System.out.println(emps.getClass());
		System.out.println(emps);
		
		session.close();
	}
}
