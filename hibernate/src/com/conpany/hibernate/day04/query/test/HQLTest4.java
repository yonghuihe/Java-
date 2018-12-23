package com.conpany.hibernate.day04.query.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class HQLTest4 {
	/**
	 * 查询出各个部门员工的平均工资和最高工资【使用聚集函数】
	 * 
	 * @throws Exception
	 */
	@Test
	public void testQuery1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		String hql = "select e.dept.name,avg(e.salary),max(e.salary) from Employee e group by e.dept.sn";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}

		session.getTransaction().commit();
		session.close();
	}
	/**
	 * 查询出各个项目参与人数报表
	 * 
	 * @throws Exception
	 */
	@Test
	public void testQuery2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
//		String hql = "select p,p.employees.size from Project p ";
//		String hql = "select p,size(p.employees) from Project p group by p";
		String hql = "select p,count(e) from Project p Left Join p.employees e group by p";
		List<Object[]> list = session.createQuery(hql).list();
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 查询出大于平均工资的员工信息(子查询)
	 * 
	 * @throws Exception
	 */
	@Test		
	public void testQuery3() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		String hql = "select e from Employee e where e.salary > (select avg(e.salary) from Employee e)";
		List<Employee> list = session.createQuery(hql).list();
		for (Employee e : list) {
			System.out.println(e);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * NamedQuery查询
	 * 	在hibernate中，执行查询需要先将HQL翻译成SQL，问题如下：
	 * 		如果HQL比较复杂，翻译的效率是比较低的
	 * 		如果一条HQL重复执行，会重复翻译，效率低
	 * 		如果在代码的不同地方使用到了相同的HQL，需要在不同的地方反复重写HQL，效率低
	 *  解决方案：hibernate提供了NamedQuery方式，来稍微提高静态HQL语句的实现效率
	 *  	NamedQuery的使用：
	 *  		1.在实体文件中添加：
	 *  			<!--该HQL在hibernate启动的时候就会翻译成SQL-->
	 *  			<query name="HQL名称">
	 *					静态HQL语句;
	 *				</query>
	 *			2.查询的时候使用：
	 *				//得到的就是已经翻译成SQL的query对象，
	 *				session.getNamedQuery("HQL名称").list();
	 *		NamedQuery的限制：
	 *			NamedQuery只能配置静态的HQL
	 * @throws Exception
	 */
	@Test		
	public void testNamedQuery() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		for(int i = 0;i <10;i++){
			session.getNamedQuery("SELECT_ALL_EMPLOYEE").list();
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
