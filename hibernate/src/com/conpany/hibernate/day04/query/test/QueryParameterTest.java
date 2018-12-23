package com.conpany.hibernate.day04.query.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Department;
import com.conpany.hibernate.util.HibernateUtil;

public class QueryParameterTest {
	/**
	 * 参数设置的两种方式：
	 * 	位置占位：
	 * 		优点：方便，适用于参数比较少的情况
	 * 		缺点：参数过多时不容易识别
	 * 	名称占位：
	 * 		优点：增加新的参数，查看都比较方便
	 * 			可以为参数名相同的名字占位符同时设置值
	 * 			可以给参数传列表值进去
	 * 			可以通过setEntity给HQL设置一个实体参数
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		String hql = "select e from Employee e where e.name like ? and e.id between ? and ?";
		List list = session.createQuery(hql).setParameter(0, "%a%").setParameter(1, 1L).setParameter(2, 10L).list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e where e.name like :name and e.id between :start and :end";
		List list = session.createQuery(hql).setParameter("name", "%a%").setParameter("start", 1L).setParameter("end", 10L).list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void test3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e where e.id in (:ids)";
		List list = session.createQuery(hql).setParameterList("ids", new Long[]{1L,20L}).list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test4() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Department dept = new Department();
		dept.setId(2L);
		String hql = "select e from Employee e where e.dept = :dept";
		List list = session.createQuery(hql).setEntity("dept", dept).list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
}
