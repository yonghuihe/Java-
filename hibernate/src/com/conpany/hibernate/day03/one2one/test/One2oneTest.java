package com.conpany.hibernate.day03.one2one.test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day03.one2one.domain.QQNumber;
import com.conpany.hibernate.day03.one2one.domain.QQZone;
import com.conpany.hibernate.util.HibernateUtil;

public class One2oneTest {
	@Before
	public void testSave() throws Exception {
		QQNumber number = new QQNumber();
		number.setName("name");
		
		QQZone zone = new QQZone();
		zone.setTitle("title");
		
		//number.setZone(zone);
		zone.setNumber(number);
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(zone);
		session.save(number);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//从主对象中拿从对象，只发送了一条SQL（左外连接）(不会使用延迟加载)
		QQNumber number = (QQNumber) session.get(QQNumber.class, 1L);
		QQZone zone = number.getZone();
		
		System.out.println(number);
		System.out.println(zone);
		
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testGet2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//从从对象中拿主对象，使用了延迟加载
		QQZone zone = (QQZone) session.get(QQZone.class, 1L);
		QQNumber number = zone.getNumber();
		
		System.out.println(number);
		System.out.println(zone);
		
		session.getTransaction().commit();
		session.close();
	}
}
