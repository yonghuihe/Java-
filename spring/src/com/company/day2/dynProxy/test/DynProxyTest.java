package com.company.day2.dynProxy.test;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day2.dynProxy.domain.Department;
import com.company.day2.dynProxy.domain.Employee;
import com.company.day2.dynProxy.handler.TransactionInvocationHandler;
import com.company.day2.dynProxy.service.IDepartmentService;
import com.company.day2.dynProxy.service.IEmployeeService;
import com.company.day2.dynProxy.txManager.TransactionManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DynProxyTest {
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private TransactionManager txManager;
	
	/**
	 * Proxy:专门用来生产代理类的对象
	 * 	newProxyInstance：需要三个参数：
	 * 		classLoader:类加载器（专门用来加载类的），相同的ClassLoader加载的类才能互相被看到
	 * 		interface：需要实现的接口，这个接口就是我们的目标对象实现的接口
	 * 		InvocationHandler：我们需要实现这个接口，在实现类的invoke方法中给业务方法加上事务
	 * 	返回值：就是生产出来的代理对象，代理对象和真实对象具有相同的接口（静态代理中也是这样规定），也就是我们传进去的接口
	 * @throws Exception
	 */
	@Test
	public void testProxy() throws Exception {
		IEmployeeService employee = (IEmployeeService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(), 
				new Class[]{IEmployeeService.class}, new TransactionInvocationHandler(employeeService,txManager));
		/**
		 * 使用代理对象调用方法，都会经过TransactionInvocationHandler中的invoke方法
		 */
		employee.update(new Employee());
	}
	@Test
	public void testProxy2() throws Exception {
		IDepartmentService department = (IDepartmentService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(), 
				new Class[]{IDepartmentService.class}, new TransactionInvocationHandler(departmentService,txManager));
		/**
		 * 使用代理对象调用方法，都会经过TransactionInvocationHandler中的invoke方法
		 */
		department.update(new Department());
	}
}
