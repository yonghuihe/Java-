package com.conpany.hibernate.day04.query.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.util.HibernateUtil;

public class HQLTest3 {
	/**
	 * 查询出所有员工及其部门
	 * @throws Exception
	 */
	@Test
	public void testQuery1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e,d.name from Employee e Left Join e.dept d";
		List<Object[]> list = session.createQuery(hql).list();
		for(Object[] obj:list){
			System.out.println(Arrays.toString(obj));
		}
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 查询出市场部员工信息及电话
	 * @throws Exception
	 */
	@Test
	public void testQuery2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//Department name "市场部"
		//Employee   e	             ？
		//Phone		 number ？
		String hql = "select p.number,e from Phone p join p.employee e where e.dept.name='市场部'";
		List<Object[]> list = session.createQuery(hql).list();
		for(Object[] obj:list){
			System.out.println(Arrays.toString(obj));
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
