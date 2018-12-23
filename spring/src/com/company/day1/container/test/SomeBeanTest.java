package com.company.day1.container.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day1.container.dao.ISomeBeanDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SomeBeanTest {
	private ISomeBeanDao dao;
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() {
		ctx = new ClassPathXmlApplicationContext(
				"com/company/day1/container/test/SomeBeanTest-context.xml");
		dao = ctx.getBean("someBean", ISomeBeanDao.class);
		dao.print();
	}
	@Test
	public void test2() {
		dao = ctx.getBean("someBean", ISomeBeanDao.class);
		dao.print();
	}
}
