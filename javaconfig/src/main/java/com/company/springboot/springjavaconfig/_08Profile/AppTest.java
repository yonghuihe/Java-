package com.company.springboot.springjavaconfig._08Profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 该测试方法，测试了，只有活动的profile，才会进行初始化
 * @author yonghui
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("test")
public class AppTest {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() throws Exception {
		DateSource bean = ctx.getBean(DateSource.class);
		System.out.println(bean);
		
		try {
			SomeBean someBean = ctx.getBean(SomeBean.class);
			System.out.println(someBean);
		} catch (Exception e) {
		}
		try {
			OtherBean otherBean = ctx.getBean(OtherBean.class);
			System.out.println(otherBean);
		} catch (Exception e) {
		}
	}
}
