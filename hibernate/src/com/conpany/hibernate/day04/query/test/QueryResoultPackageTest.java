package com.conpany.hibernate.day04.query.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.EmployeeVO;
import com.conpany.hibernate.util.HibernateUtil;

/**
 * 查询结果的封装
 * 
 * @author yonghui
 *
 */
public class QueryResoultPackageTest {

	@Test
	public void test1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		// 查询结果封装成Object[]
		String hql = "SELECT e.id,e.name,e.salary,e.dept.name,e.dept.sn,e.dept.address.city FROM Employee e";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void test2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		// 查询结果封装成List对象--使用new List()
		String hql = "SELECT new List(e.id,e.name,e.salary,e.dept.name,e.dept.sn,e.dept.address.city) FROM Employee e";
		List<List<Object>> list = session.createQuery(hql).list();
		for (List obj : list) {
			System.out.println(obj);
		}

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void test3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		// 查询结果封装成Map对象--使用new Map()
		String hql = "SELECT new Map("
				+ "e.id as eId,e.name as eName,e.salary as eSalary,e.dept.name as deptName,"
				+ "e.dept.sn as deptSn,e.dept.address.city as addressCity"
				+ ") FROM Employee e";
		List<Map<String, Object>> list = session.createQuery(hql).list();
		for (Map obj : list) {
			System.out.println(obj);
		}

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void test4() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		// 查询结果封装成VO对象--使用new VO()
		String hql = "SELECT new EmployeeVO("
				+ "e.id,e.name,e.salary,e.dept.name,e.dept.sn,e.dept.address.city"
				+ ") FROM Employee e";
		List<EmployeeVO> list = session.createQuery(hql).list();
		for (EmployeeVO vo : list) {
			System.out.println(vo);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
