package com.company.springboot.springjavaconfig._09Conditional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 该测试方法，测试了，只有活动的profile，才会进行初始化
 * @author yonghui
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() throws Exception {
		int size = ctx.getBeansOfType(SomeBean.class).size();
		System.out.println(size);
		size = ctx.getBeansOfType(DependencyBean.class).size();
		System.out.println(size);
	}
}
