package com.company.springboot.springjavaconfig._01HelloWorld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * javaconfig
 * 
 * @author yonghui
 *
 */
public class SomeBeanTest {
	
	/**
	 * spring使用 java config 方式
	 * 获取到的bean是同一个，拿到的bean是单例的
	 * @throws Exception
	 */
	@Test
	public void testJava() throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		SomeBean bean = ctx.getBean("someBean", SomeBean.class);
		System.out.println(bean);//com.company.springboot.springjavaconfig._01HelloWorld.SomeBean@1e86471
		
		bean = ctx.getBean("someBean", SomeBean.class);
		System.out.println(bean);//com.company.springboot.springjavaconfig._01HelloWorld.SomeBean@1e86471
		
	}

	/**
	 * spring 使用 xml config 方式
	 * 从spring容器中拿到SomeBean
	 * 
	 * @throws Exception
	 */
	@Test
	public void testXML() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SomeBean bean = ctx.getBean("someBean", SomeBean.class);
		System.out.println(bean);//com.company.springboot.springjavaconfig._01HelloWorld.SomeBean@4f1e5ed9
	}
}
