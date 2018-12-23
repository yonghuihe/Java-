package com.company.springboot.springjavaconfig._03Inject;

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
		SomeBean bean = ctx.getBean("somebean3", SomeBean.class);
		System.out.println(bean.getOtherbean());//com.company.springboot.springjavaconfig._03Inject.OtherBean@559ed86
		
		ctx.close();
	}

}
