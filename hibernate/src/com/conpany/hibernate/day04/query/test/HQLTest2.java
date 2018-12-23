package com.conpany.hibernate.day04.query.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Project;
import com.conpany.hibernate.util.HibernateUtil;

public class HQLTest2 {
	
	/**
	 * 查询有员工参与开发的项目
	 * @throws Exception
	 */
	@Test
	public void testQuery1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//String hql = "select p from Project p where p.employees.size > 0";
		String hql = "select p from Project p where size(p.employees) > 0";
		List<Project> list = session.createQuery(hql).list();
		for(Project p:list){
			System.out.println(p);
		}
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 查询有没有员工参与开发的项目【对集合使用size/is empty】
	 * @throws Exception
	 */
	@Test
	public void testQuery2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//String hql = "select p from Project p where p.employees.size = 0";
		//String hql = "select p from Project p where size(p.employees) = 0";
		String hql = "select p from Project p where p.employees is empty";
		List<Project> list = session.createQuery(hql).list();
		for(Project p:list){
			System.out.println(p);
		}
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 查询出项目信息，按照项目的参与者总数排序【使用函数排序】
	 * @throws Exception
	 */
	@Test
	public void testQuery3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select p from Project p order by size(p.employees) ASC";
		List<Project> list = session.createQuery(hql).list();
		for(Project project:list){
			System.out.println(project);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
