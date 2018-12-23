package com.company.day1.mvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day1.mvc.web.action.EmployeeAction;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MvcTest {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testSave() throws Exception {
		EmployeeAction action = ctx.getBean("employeeAction",EmployeeAction.class);
		action.save();
	}
}
