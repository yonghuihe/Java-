package com.company.day1.container.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day1.container.dao.ISomeBeanDao;
import com.company.day1.container.dao.impl.SomeBeanDaoImpl;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
public class ContainerTest {
	private ISomeBeanDao dao;
	/**
	 * 测试bean的创建时机：必须手动创建
	 */
	@Test
	public void testCtx() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/company/day1/container/test/SomeBeanTest-context.xml");
	}
	@Test
	public void testBF() {
		Resource resource = new ClassPathResource(
				"com/company/day1/container/test/SomeBeanTest-context.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		dao = beanFactory.getBean("someBean", ISomeBeanDao.class);
	}
}
