package com.company.springboot.springjavaconfig._06ImportResource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
	
	@Autowired
	private SomeBean somebean;

	@Test
	public void test() throws Exception {
		System.out.println(somebean.getOtherBean());//com.company.springboot.springjavaconfig._06ImportResource.OtherBean@2236052c
	}
	

}
