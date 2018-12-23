package com.conpany.hibernate.day02.id.test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day01.hello.dao.IEmployeeDao;
import com.conpany.hibernate.day01.hello.dao.impl.EmployeeDaoImpl;
import com.conpany.hibernate.day02.id.dao.IIdDao;
import com.conpany.hibernate.day02.id.dao.impl.IdDaoImpl;
import com.conpany.hibernate.day02.id.domain.Id;
import com.conpany.hibernate.util.HibernateUtil;

public class IdDaoTest {

	private IIdDao idDao;
	private IEmployeeDao employeeDao;
	
	public IdDaoTest() {
		idDao = new IdDaoImpl();
		employeeDao = new EmployeeDaoImpl();
	}
	
	@Before
	public void testSave() throws Exception {
		Id idDomain = new Id();
		idDomain.setName("stef");
		
		/*Id idDomain2 = new Id();
		idDomain2.setName("stef");*/
		
		/*Employee e = new Employee();
		e.setName("stef");*/
		/**
		 * <generator class="assigned"/>
		 * 在保存之前需要手动的设置主键的值
		 */
		//idDomain.setId(1L);
		
		/**
		 * <generator class="uuid"/>
		 * 此时要求主键的类型必须为String，否则报参数类型不匹配异常
		 */

		idDao.save(idDomain);
		//idDao.save(idDomain2);
		//employeeDao.save(e);
	}
	
	@Test
	public void testDelete() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Id idDomain = (Id) session.get(Id.class, 1L);
		session.delete(idDomain);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(idDomain.getId());
	}
	
	/**
	 * saveOrUpdate():保存没有有id的对象，修改有id的对象
	 * @throws Exception
	 */
	@Test
	public void testSaveOrUpdate() throws Exception {
		Id idDomain = new Id();
		idDomain.setId(1L);
		idDomain.setName("stef");
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//session.saveOrUpdate(idDomain);
		session.update(idDomain);
		session.get(Id.class, 1L);
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * get()&load():都可以查询指定id的对象
	 * 	get():在调用get()的时候会立刻调用select语句，如果没有结果，返回null，如果有结果，返回查询出来的对象
	 * 	load():把真正执行select延后到到使用这个对象的时候，我们叫做延迟加载。
	 * 		真正使用这个对象：指的是在使用对象的非主键属性的时候。
	 * load():的原理：
	 * 	1.load方法返回的对象是hibernate动态的为我们的domain创建的一个子类，
	 * 		在这个子类中hibernate为我们重写了非主键属性的getter和toString方法
	 *  2.hibernate为这个子类添加了一个状态（是否加载完成），
	 *  	如果在调用这个方法的getter方法的时候，还没有加载啊，就发送一条select语句从数据库中查询对象，并把查询到的数据保存到这个对象中，并这个这个对象的状态为已加载完成；
	 *  	如果在调用这个方法的getter方法的时候，已经加载完成，就直接返回属性的值即可。
	 *  3.hibernate使用javassist来完成延迟加载子类的动态生成。
	 *  4.如果在session关闭之前没有去实例化延迟加载对象，会报：no session 异常
	 *  5.用load方法，返回的结果永远不可能为空，返回的是一个代理对象，在真正使用的是，才会根据传入的id去查询数据库
	 *  6.如果load方法返回的对象，在使用的过程中发现数据库里面没有对应的值，会报错（如果使用load方法，请保证id在数据库中一定存在）
	 * @throws Exception
	 */
	@Test
	public void testLoad() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//Id idDomain = (Id)session.get(Id.class,2L);
		Id idDomain = (Id)session.load(Id.class,1L);
		System.out.println("==============");
		System.out.println(idDomain.getName());
		System.out.println(idDomain.getName());
		//System.out.println(idDomain.getId());
		System.out.println(idDomain == null);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testSave2() throws Exception {
		//临时状态：刚new出来，没有id，没有被hibernate管理[此时数据库中没有值对应]
		Id idDomain = new Id();
		idDomain.setName("stef");
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//持久化状态：有id，被hibernate的session缓存管理[此时数据库中有值对应]
		session.save(idDomain);
		/**
		 * 使用get方法测试：
		 * 	执行get方法会立刻打印一条SQL语句
		 * 	此时控制台没有打印select，说明get方法是从缓存中拿的
		 */
		session.get(Id.class, 1L);
		
		session.getTransaction().commit();
		session.close();
		//游离状态：有id，没有被hibernate管理[此时数据库中有值对应]
		System.out.println(idDomain);
	}
	
	@Test
	public void testSaveLoad() throws Exception {
		Id idDomain = new Id();
		idDomain.setName("stef");
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(idDomain);//save方法把临时状态变为持久状态
		Id idLoad = (Id) session.load(Id.class, 1L);
		Id idGet = (Id) session.get(Id.class, 1L);
		System.out.println(idLoad == idGet);
		
		session.getTransaction().commit();
		session.close();
		
		/*session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(idDomain);//save方法把游离状态变为持久状态
		session.get(Id.class, 2L);
		
		session.getTransaction().commit();
		session.close();*/
	}
	
	@Test
	public void testCreateQuery() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.createQuery("From Id").list();//返回的是持久化对象，在处理大量数据的时候，要及时清理缓存，否则内存溢出
		session.get(Id.class, 1L);
		
		session.getTransaction().commit();
		session.close();
	}

}
