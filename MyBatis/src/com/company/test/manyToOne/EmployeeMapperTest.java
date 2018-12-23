package com.company.test.manyToOne;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.company.domain.Department;
import com.company.domain.Employee;
import com.company.mapper.manyToOne.DepartmentMapper;
import com.company.mapper.manyToOne.EmployeeMapper;
import com.company.util.MyBatisUtil;

public class EmployeeMapperTest {

	@Test
	public void testAdd() {
		SqlSession session = MyBatisUtil.openSession();
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		
		Employee employee = new Employee();
		employee.setUsername("name2");
		employee.setPassword("password2");
		employee.setAge(2);
		employee.setInputTime(new Date());
		
		Department department = new Department();
		department.setName("name1");
		
		// 先保存部门数据，保证部门有id
		departmentMapper.add(department);
		
		// 关联关系
		employee.setDept(department);
		
		// 保存员工
		employeeMapper.add(employee);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		SqlSession session = MyBatisUtil.openSession();
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

		//第一次查询
		Employee employee = employeeMapper.get(1L);
		System.out.println(employee);
		
		//第二次查询：在同一个session中，没有发送SQL
		employee = employeeMapper.get(1L);
		System.out.println(employee);
		
		session.close();
		
		System.out.println("-----------------");
		
		session = MyBatisUtil.openSession();
		
		employeeMapper = session.getMapper(EmployeeMapper.class);
		
		//第三次查询：session不同，会重新发送SQL
		employee = employeeMapper.get(1L);
		System.out.println(employee);
		
		session.close();
	}
	
	@Test
	public void testList() throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		
		List<Employee> list = employeeMapper.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		session.close();
	}
	
}
