package com.company.day1.hello.test;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.company.day1.hello.dao.IHelloWorldDao;

public class HelloWorldTest {
	private IHelloWorldDao dao;

	public HelloWorldTest() {
		// 直接在应用中引入实现类，耦合
		// dao = new HelloWorldDaoImpl();
		// -------------------------------------
		// 使用spring容器来管理实例，我们直接从容器中拿（代码中没有实现类，使用的接口）
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		System.out.println(Arrays.toString(beanFactory.getAliases("helloWorld")));
		dao = beanFactory.getBean("helloWorld", IHelloWorldDao.class);
	}

	@Test
	public void test() {
		dao.hello();
	}
}
