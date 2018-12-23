package com.company.jpa.lock;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.hibernate.StaleObjectStateException;
import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.domain.Employee;
import com.company.jpa.hello.util.JPAUtil;

public class LockTest {
	@Before
	public void test1() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Employee employee = new Employee();
		employee.setName("init");
		em.persist(employee);
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 悲观锁：
	 * 	select for update 可以阻止：除了SELECT之外的其他SQL（FOR UPDATE,DML,LOCK IN SHARE MODE）
	 *  select lock in share mode 可以阻止：DML和FOR UPDATE,LOCK IN SHARE MODE;
	 *  
	 *  在JPA中使用悲观锁：
	 *  em.find(Class,id,LockModeType);
	 *  	LockModeType一般有两种方式：
	 *  		1.PESSIMISTIC_RADE:LOCK IN SHARE MODE:会通过造成死锁来阻止并发事务执行；
	 *  		2.PESSIMISTIC_WRITE:SELECT FOR UPDATE:会延迟另一个事务的执行；（一般使用这种）
	 *  加了悲观锁成功的解决了第一类丢失更新和第二类丢失更新
	 *  悲观锁其实是把事务延后执行了，性能较低
	 * @throws Exception
	 */
	@Test
	public void testLock1() throws Exception {
		EntityManager em1 = JPAUtil.getInstance().entityManager();
		EntityManager em2 = JPAUtil.getInstance().entityManager();
		em1.getTransaction().begin();
		em2.getTransaction().begin();
		
		Employee e1 = em1.find(Employee.class, 1L,LockModeType.PESSIMISTIC_WRITE);
		Employee e2 = em2.find(Employee.class, 1L,LockModeType.PESSIMISTIC_WRITE);
		
		e1.setName("e1");
		e2.setName("e2");
		
		em1.getTransaction().commit();
		em2.getTransaction().commit();
		em1.close();
		em2.close();
	}
	
	/**
	 * 乐观锁：
	 * 	1.在数据库中加一个字段，专门用来表示版本:private Integer version;
	 * 	2.提供getter/setter
	 * 	3.捕获异常，提示用户稍后再试
	 *  乐观锁是解决数据库事务并发的一种方法，效率比较高
	 * @throws Exception
	 */
	@Test
	public void testLock2() throws Exception {
		EntityManager em1 = JPAUtil.getInstance().entityManager();
		EntityManager em2 = JPAUtil.getInstance().entityManager();
		em1.getTransaction().begin();
		em2.getTransaction().begin();
		
		Employee e1 =  em1.find(Employee.class, 1L);
		Employee e2 =  em2.find(Employee.class, 1L);
		
		e1.setName("e11");
		e2.setName("e22");
		
		try{
			em1.merge(e1);
			em2.merge(e2);
			
			em1.getTransaction().commit();
			em2.getTransaction().commit();
		} catch(StaleObjectStateException e){
			e.printStackTrace();
			System.out.println("服务器正忙，请稍后再试！");
		}
		em1.close();
		em2.close();
	}
}
