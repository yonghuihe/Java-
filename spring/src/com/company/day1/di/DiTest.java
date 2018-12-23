package com.company.day1.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DiTest {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() throws Exception {
		SomeBean bean = ctx.getBean("someBean",SomeBean.class);
		System.out.println(bean);
	}
}
