package com.company.day1.hello.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day1.hello.dao.IHelloWorldDao;

/**
 * 添加RunWith标签：
 * 	1.告诉JUnit，在启动JUnit测试的时候，先启动spring容器，在测试完成之后记得关闭spring容器
 * 	2.自动的把当前这个测试类也加入到了spring容器中管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 告诉spring从什么地方加载配置文件，默认情况下使用相对路径查询；
 * 如果在ContextConfiguration标签中不写配置文件地址，spring可以通过一个约定的方式找到配置文件；
 * 	1.和测试类在一个包里面
 * 	2.这个配置文件的名字叫做：测试类-context.xml
 * @author yonghui
 *
 */

@ContextConfiguration
public class SpringTest {
	private IHelloWorldDao dao;

	/**
	 * 使用Autowired标签，就自动的把spring创建好的容器的引用，设置给了这个字段
	 */
	@Autowired
	private BeanFactory beanFactory;
	
	@Test
	public void test() {
		dao = beanFactory.getBean("helloWorld", IHelloWorldDao.class);
		dao.hello();
	}
}
