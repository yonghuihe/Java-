package com.conpany.hibernate.day04.cache;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class CacheTest {
	@Test
	public void test1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		Employee e1 = (Employee) session.get(Employee.class, 1L);
		session.close();
		
		Thread.sleep(4000);
		
		session = HibernateUtil.getInstance().openSession();
		Employee e2 = (Employee) session.get(Employee.class, 1L);
		session.close();
	}
	
	/**
	 * 二级缓存的操作
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		Employee e1 = (Employee) session.get(Employee.class, 1L);
		session.close();
		
		SessionFactory sf = HibernateUtil.getInstance().getSessionFactory();
		//得到二级缓存对象
		Cache cache = sf.getCache();
		//剔除一个实例
		//cache.evictEntity(Employee.class, 1L);
		//剔除某种类型的所有实例
		//cache.evictEntityRegion(Employee.class);
		//剔除所有二级缓存实例
		cache.evictEntityRegions();
		
		session = HibernateUtil.getInstance().openSession();
		Employee e2 = (Employee) session.get(Employee.class, 1L);
		session.close();
	}
	
	/**
	 * 查询缓存
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.createQuery("select e from Employee e").setCacheable(true).list();
		session.close();
		
		session = HibernateUtil.getInstance().openSession();
		session.createQuery("select e from Employee e").setCacheable(true).list();
		session.close();
	}
	
}
