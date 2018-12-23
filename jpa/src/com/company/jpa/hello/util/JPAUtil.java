package com.company.jpa.hello.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA工具
 * @author yonghui
 *
 */
public class JPAUtil {
	
	private static final JPAUtil instance = new JPAUtil();
	
	// SessionFactory（和DataSource一样）是线程安全的，因此可以当做成员变量，
	// SessionFactory 每次会生成一个新的副本对象，因此线程安全
	/**
	 * EntityManagerFactory也是现场安全的,相当于SessionFactory
	 * EntityManager是现场不安全的，相当于Session
	 */
	private EntityManagerFactory emFactory;
	
	private JPAUtil(){
		/**
		 * 启动框架，读取配置文件
		 * 使用createEntityManagerFactory就可以：
		 * 	1、从classpath下的META-INF文件夹中读取persistence.xml文件
		 * 	2、使用该名字对应的配置项去创建一个EntityManagerFactory
		 */
		emFactory = Persistence.createEntityManagerFactory("com.company.jpa");
	}
	
	public static JPAUtil getInstance(){
		return instance;
	}
	
	public EntityManagerFactory entityManagerFactory(){
		return emFactory;
	}
	
	public EntityManager entityManager(){
		return emFactory.createEntityManager();
	}
}
