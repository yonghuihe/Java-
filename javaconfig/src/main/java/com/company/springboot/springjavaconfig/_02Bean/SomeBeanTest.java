package com.company.springboot.springjavaconfig._02Bean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * javaconfig
 * 
 * @author yonghui
 *
 */
public class SomeBeanTest {

	@Test
	public void test() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		SomeBean bean = ctx.getBean("somebean", SomeBean.class);//获取的是工厂中创建的SomeBean
		System.out.println(bean);//com.company.springboot.springjavaconfig._02Bean.SomeBean@34f7dd13
			
		SomeBeanFactory factory = ctx.getBean("&somebean", SomeBeanFactory.class);//获取的是工厂
		System.out.println(factory);//com.company.springboot.springjavaconfig._02Bean.SomeBeanFactory@a470f4f
		
		ctx.close();
	}

}
