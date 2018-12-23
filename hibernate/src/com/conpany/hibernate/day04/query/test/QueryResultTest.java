package com.conpany.hibernate.day04.query.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Department;
import com.conpany.hibernate.util.HibernateUtil;

/**
 * 查询结果：
 * 	1.查询一个实体对象
 * 		直接查询实体对象返回的是实体对象的列表
 * 		注意，这个列表中所有的对象都是实体化的，所以如果查询的数据量过大，记得：分页+清空一级缓存
 * 	2.投影查询
 * 		查询一个简单属性
 * @author yonghui
 */
public class QueryResultTest {
	@Test
	public void testQuery1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//查询一个简单属性，返回的是这个属性的list集合
		List list = session.createQuery("select e.name from Employee e").list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testQuery2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//查询一个的属性是一个实体对象，返回的是这个实体对象的list集合
		List<Department> list = session.createQuery("select e.dept from Employee e").list();
		for(Department dept:list){
			System.out.println(dept);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testQuery3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//查询多个属性，返回的是一个Object[]的list集合
		List<Object[]> list = session.createQuery("select e.name,e.salary,e.hireDate from Employee e").list();
		for (Object[] obj: list){
			System.out.println(Arrays.toString(obj));
		}
		
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testQuery4() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//查询多个属性，返回的是一个Object[]的list集合
		//如果查询的多个属性中有实体对象，那么返回的list集合中也是这些实体对象，并且这些实体对象是持久化的
		List<Object[]> list = session.createQuery("select e.name,e.salary,e.dept,e.hireDate from Employee e").list();
		for (Object[] obj: list){
			System.out.println(Arrays.toString(obj));
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
