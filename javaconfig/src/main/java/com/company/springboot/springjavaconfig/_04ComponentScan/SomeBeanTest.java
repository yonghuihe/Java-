package com.company.springboot.springjavaconfig._04ComponentScan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * javaconfig
 * 
 * @author yonghui
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)//指定主配置文件的位置
public class SomeBeanTest {
	
	@Autowired
	private SomeBean somebean;
	
	@Test
	public void testAutowired() throws Exception {
		System.out.println(somebean.getOtherbean());//com.company.springboot.springjavaconfig._04ComponentScan.OtherBean@14d90e02
	}

	@Test
	public void test() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		SomeBean bean = ctx.getBean("somebean", SomeBean.class);//默认是SomeBean首字母小写，可以在@Component("somebean")中设置
		System.out.println(bean.getOtherbean());//com.company.springboot.springjavaconfig._04ComponentScan.OtherBean@627096dc
		
		ctx.close();
	}

}
