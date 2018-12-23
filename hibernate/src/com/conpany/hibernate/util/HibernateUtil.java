package com.conpany.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 单例模式：
 * 	1、构造函数私有化,所以不能使用（对象.方法名）来获取实例
 * 	2、单例类必须自己创建自己的唯一实例
 * 	3、单例类必须向外界暴露一个获取该实例的公共方法
 * 注意：因为只能使用（类名.方法名）来获取实例，因此暴露的公共的方法必须是static的，实例对象也必须使用static修饰
 * @author yonghui
 *
 */
@SuppressWarnings("all")
public class HibernateUtil {

	
	private static final HibernateUtil instance = new HibernateUtil();
	
	// SessionFactory（和DataSource一样）是线程安全的，因此可以当做成员变量，
	// SessionFactory 每次会生成一个新的副本对象，因此线程安全
	private SessionFactory sessionFactory;
	
	private HibernateUtil(){
		Configuration cfg = new Configuration().configure();
//		sessionFactory = cfg.buildSessionFactory();
		// hibernate4.0 以后把一些重要的功能（连接数据库，二级缓存等）抽成了一个一个的服务，
		// 我们要拿连接，我们只需要找这个服务拿连接就可以了（不需要硬编码）
		sessionFactory = cfg.buildSessionFactory(
				new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry());
	}
	
	public static HibernateUtil getInstance(){
		return instance;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public Session openSession(){
		return sessionFactory.openSession();
	}
}
