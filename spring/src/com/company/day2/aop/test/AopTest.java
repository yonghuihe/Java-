package com.company.day2.aop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.day2.aop.domain.Employee;
import com.company.day2.aop.service.IDepartmentService;
import com.company.day2.aop.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AopTest {
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IDepartmentService departmentService;
	
	@Test
	public void testSave() throws Exception {
		Employee employee = new Employee();
		employee.setAge(10);
		employee.setName("name");
		employee.setPassword("password");
		employeeService.save(employee);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Employee e = new Employee();
		e.setId(1L);
		e.setName("update");
		employeeService.update(e);
	}
	@Test
	public void testDelete() throws Exception {
		employeeService.delete(2L);
	}
	@Test
	public void testGet() throws Exception {
		Employee employee = employeeService.get(6L);
		System.out.println(employee);
	}
	@Test
	public void testQuery() throws Exception {
		List<Employee> list = employeeService.query();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
}
