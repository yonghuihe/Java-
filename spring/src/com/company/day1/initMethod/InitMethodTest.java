package com.company.day1.initMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class InitMethodTest {
	
	@Autowired
	private ApplicationContext ctx;
	
	/**
	 * 如果scope设置为prototype，spring是不会帮我们销毁bean的，需要我们手动调用close方法，并设置为null，gc才会回收
	 */
	@Test
	public void test() {
		SomeBean bean = ctx.getBean("someBean", SomeBean.class);
		bean.print();
		bean.close();
		bean = null;
	}
	
	/**
	 * 如果手动启动容器，容器在测试结束后被强行关闭；
	 * 必须正常关闭spring容器，才能调用到destroy-method
	 */
	@Test
	public void test2() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/company/day1/initMethod/InitMethodTest-context.xml");
		SomeBean bean = ctx.getBean("someBean", SomeBean.class);
		bean.print();
		ctx.close();
	}
	
	/**
	 * registerShutdownHook,代表，在JVM的正常关闭线程中，添加一个Spring的关闭子线程，在子线程中调用close方法
	 * 	只要JVM能正常结束，Spring就可以正常结束
	 * 	系统的守护进程
	 */
	@Test
	public void test3() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/company/day1/initMethod/InitMethodTest-context.xml");
		SomeBean bean = ctx.getBean("someBean", SomeBean.class);
		bean.print();
		ctx.registerShutdownHook();
	}
}
