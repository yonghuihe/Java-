package com.company.jpa.cache;

import java.util.Date;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.domain.Employee;
import com.company.jpa.hello.util.JPAUtil;

@SuppressWarnings("all")
public class SLCTest {
	@Before
	public void init() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();

		Employee e = new Employee();
		e.setAge(10);
		e.setHiredate(new Date());
		e.setName("name");
		em.persist(e);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testGet() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		Employee e1 = em.find(Employee.class, 1L);
		em.close();
		
		EntityManager em2 = JPAUtil.getInstance().entityManager();
		Employee e2 = em2.find(Employee.class, 1L);
		em2.close();
		
	}
	
	/**
	 * 二级缓存的操作
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		
		EntityManager em = JPAUtil.getInstance().entityManager();
		Employee e1 = em.find(Employee.class, 1L);
		em.close();
		
		EntityManagerFactory emFactory = JPAUtil.getInstance().entityManagerFactory();
		
		//得到二级缓存对象
		Cache cache = emFactory.getCache();
		System.out.println(cache);
		//剔除一个实例
		cache.evict(Employee.class, 1L);
		//剔除某种类型的所有实例
		cache.evict(Employee.class);
		//剔除所有的二级缓存实例
		cache.evictAll();
		
		em = JPAUtil.getInstance().entityManager();
		Employee e2 = em.find(Employee.class, 1L);
		em.close();
	}
}
