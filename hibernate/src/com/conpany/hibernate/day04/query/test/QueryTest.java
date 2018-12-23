package com.conpany.hibernate.day04.query.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class QueryTest {
	@Test
	public void testSave() throws Exception {
		HibernateUtil.getInstance();
	}

	/**
	 * 查询员工名字中包含a，且id在1~10之间
	 * 
	 * @throws Exception
	 */
	@Test
	public void testHQL() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		String hql = "select e from Employee e where e.name like ? and e.id between ? and ?";
		List list = session.createQuery(hql).setParameter(0, "%a%").setParameter(1, 1L).setParameter(2, 10L).list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testSQL() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		String sql = "select * from Employee where name like ? and id between ? and ?";
		List list = session.createSQLQuery(sql).setParameter(0, "%a%").setParameter(1, 1L).setParameter(2, 10L).list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString((Object[]) list.get(i)));
		}
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testCriteria() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();

		List list = session.createCriteria(Employee.class).add(Restrictions.ilike("name", "a", MatchMode.ANYWHERE))
				.add(Restrictions.between("id", 1L, 10L)).list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
}
