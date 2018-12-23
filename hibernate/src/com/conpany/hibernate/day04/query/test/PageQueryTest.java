package com.conpany.hibernate.day04.query.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.util.HibernateUtil;

public class PageQueryTest {

	/**
	 * 查询当前页数据
	 * @throws Exception
	 */
	@Test
	public void testQueryCurrentPage() throws Exception {
		int pageSize = 3;
		int currentPage = 3;
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e ";
		List list = session.createQuery(hql).setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize).list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 查询总条数
	 * @throws Exception
	 */
	@Test
	public void testTotal() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select count(e) from Employee e";
		List list = session.createQuery(hql).list();
		System.out.println(list.get(0));
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testTotal2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select count(e) from Employee e";
		Long count = (Long) session.createQuery(hql).uniqueResult();
		System.out.println(count);
		
		session.getTransaction().commit();
		session.close();
	}
}
