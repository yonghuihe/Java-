package com.company.springboot.springjavaconfig._05Import;

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

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		System.out.println(datesource);//com.company.springboot.springjavaconfig._05Import.DateSource@7d7ca589
		System.out.println(redisTemplate);//com.company.springboot.springjavaconfig._05Import.RedisTemplate@25805bc
	}
	

}
