package com.conpany.hibernate.day04.query.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Department;
import com.conpany.hibernate.day04.query.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

/**
 * HQL的简单查询
 * @author yonghui
 *
 */
@SuppressWarnings("all")
public class HQLTest1 {
	/**
	 * 1、查询所有员工【查询实体类型】
	 * @throws Exception
	 */
	@Test
	public void testQuery1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		List<Employee> list = session.createQuery("select e from Employee e").list();
		for(Employee employee:list){
			System.out.println(employee);
		}
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 2、查询所有员工的姓名和部门名称【特定属性】
	 * @throws Exception
	 */
	@Test
	public void testQuery2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		List<Object[]> list = session.createQuery("select e.name,e.dept.name from Employee e").list();
		for(Object[] obj:list){
			System.out.println(Arrays.toString(obj));
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 3、查询出所有在成都和广州工作的员工【查询结果过滤】
	 * @throws Exception
	 */
	@Test
	public void testQuery3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e where e.dept.address.city in (:cities)";
		List list = session.createQuery(hql).setParameterList("cities",new String[]{"成都","广州"}).list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 4、查询出所有员工信息，按照月薪排序【查询排序】
	 * @throws Exception
	 */
	@Test
	public void testQuery4() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e order by e.salary";
		List<Employee> list = session.createQuery(hql).list();
		for(Employee employee:list){
			System.out.println(employee);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 5、查询出所有员工信息，按照部门编号排序【使用关联对象属性排序】
	 * @throws Exception
	 */
	@Test
	public void testQuery5() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e order by e.dept.sn";
		List<Employee> list = session.createQuery("select e from Employee e order by e.dept.sn").list();
		for(Employee employee:list){
			System.out.println(employee);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 6、查询出工资在5000-6000的员工【使用between and】
	 * @throws Exception
	 */
	@Test
	public void testQuery6() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e where e.salary between ? and ?";
		List<Employee> list = session.createQuery(hql).setParameter(0, BigDecimal.valueOf(5000)).setParameter(1, BigDecimal.valueOf(6000)).list();
		for(Employee employee:list){
			System.out.println(employee);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 7、查询出姓名中包含er或者en的员工【使用like】
	 * @throws Exception
	 */
	@Test
	public void testQuery7() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e where e.name like ? or e.name like ?";
		List<Employee> list = session.createQuery(hql).setParameter(0, "%er%").setParameter(1, "%en%").list();
		for(Employee employee:list){
			System.out.println(employee);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 8、查询出有员工的部门【使用distinct】
	 * @throws Exception
	 */
	@Test
	public void testQuery8() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		List<Department> list = session.createQuery("select distinct e.dept from Employee e").list();
		for(Department department:list){
			System.out.println(department);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
