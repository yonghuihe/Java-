package com.company.springboot.springjavaconfig._07ValueInject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
	
	@Autowired
	private DateSource datesource;
	
	@Test
	public void test() throws Exception {
		System.out.println(datesource);
	}
}
