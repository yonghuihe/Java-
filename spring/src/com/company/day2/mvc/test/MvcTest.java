package com.company.day2.mvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day2.mvc.web.action.EmployeeAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MvcTest {
	@Autowired
	private EmployeeAction employeeAction;
	
	@Test
	public void testSave() throws Exception {
		employeeAction.save();
	}
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test2() throws Exception {
		EmployeeAction bean1 = ctx.getBean("employeeAction",EmployeeAction.class);
		EmployeeAction bean2 = ctx.getBean("employeeAction",EmployeeAction.class);
		System.out.println(bean1 == bean2);
	}
}
