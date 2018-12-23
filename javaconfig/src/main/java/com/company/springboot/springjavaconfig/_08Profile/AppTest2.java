package com.company.springboot.springjavaconfig._08Profile;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * 通过在test时设置environment参数：spring.profiles.active为哪个profile
 * 
 * @author yonghui
 *
 */
public class AppTest2 {
	
	/**
	 * AbstractEnvironment
	 * 	spring.profiles.active
	 * 	spring.profiles.default
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBean(DateSource.class));
	}
}
