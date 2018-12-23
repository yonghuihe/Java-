package com.conpany.hibernate.day04.lock;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day04.query.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class LockTest {
	@Before
	public void test1() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, 1L);
		employee.setName("init");
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * 悲观锁：
	 * 	select for update 只会阻止 for update+DML(不会锁普通的select语句)
	 * 	session1加悲观锁，session2提交，执行update语句，
	 * 		但是Employee#1这个对象被session1锁住了，因此session2要提交必须等待session1执行完才可以执行
	 * 		所以悲观锁可能导致死锁，锁的是update语句
	 *  session1和session2都加悲观锁，所得是select语句
	 *  加了悲观锁成功的解决了第一类丢失更新和第二类丢失更新
	 *  悲观锁其实是把事务延后执行了，性能较低
	 * @throws Exception
	 */
	@Test
	public void testLock1() throws Exception {
		Session session1 = HibernateUtil.getInstance().openSession();
		Session session2 = HibernateUtil.getInstance().openSession();
		session1.beginTransaction();
		session2.beginTransaction();
		
		Employee e1 = (Employee) session1.get(Employee.class, 1L,LockOptions.UPGRADE);
		Employee e2 = (Employee) session2.get(Employee.class, 1L,LockOptions.UPGRADE);
		
		e1.setName("e1");
		e2.setName("e2");
		
		session2.getTransaction().commit();
		session1.getTransaction().commit();
		session1.close();
		session2.close();
	}
	
	/**
	 * 乐观锁：
	 * 	1.在数据库中加一个字段，专门用来表示版本:private Integer version;
	 * 	2.在hibernate的类的映射文件中配置:<version name="version"/>
	 * 	3.捕获异常，提示用户稍后再试
	 *  乐观锁是解决数据库事务并发的一种方法，效率比较高
	 * @throws Exception
	 */
	@Test
	public void testLock2() throws Exception {
		Session session1 = HibernateUtil.getInstance().openSession();
		Session session2 = HibernateUtil.getInstance().openSession();
		session1.beginTransaction();
		session2.beginTransaction();
		
		Employee e1 = (Employee) session1.get(Employee.class, 1L);
		Employee e2 = (Employee) session2.get(Employee.class, 1L);
		
		e1.setName("e1");
		e2.setName("e2");
		
		session2.getTransaction().commit();
		try{
			session1.getTransaction().commit();
		} catch(StaleObjectStateException e){
			e.printStackTrace();
			System.out.println("服务器正忙，请稍后再试！");
		}
		session1.close();
		session2.close();
	}
}
