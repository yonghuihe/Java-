package com.company.test.oneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.company.domain.Department;
import com.company.domain.Employee;
import com.company.mapper.oneToMany.DepartmentMapper;
import com.company.mapper.oneToMany.EmployeeMapper;
import com.company.util.MyBatisUtil;

public class EmployeeMapperTest {

	@Test
	public void testAdd() {
		SqlSession session = MyBatisUtil.openSession();
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		List<Employee> list = new ArrayList<Employee>();
		
		Employee employee1 = new Employee();
		employee1.setUsername("eName1");
		employee1.setPassword("ePassword1");
		employee1.setAge(1);
		employee1.setInputTime(new Date());

		Employee employee2 = new Employee();
		employee2.setUsername("eName2");
		employee2.setPassword("ePassword2");
		employee2.setAge(2);
		employee2.setInputTime(new Date());
		
		list.add(employee1);
		list.add(employee2);
		
		Department department = new Department();
		department.setName("dName1");
		
		department.setEmps(list);
		
		//保存员工
		employeeMapper.add(employee1);
		employeeMapper.add(employee2);
		
		//保存部门
		departmentMapper.add(department);
		
		//关联关系：更新员工的外键，发送一条update语句
		List<Employee> emps = department.getEmps();
		for (Employee employee : emps) {
			employeeMapper.updateRealation(department.getId(), employee.getId());
		}
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		SqlSession session = MyBatisUtil.openSession();
		
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		
		Department department = departmentMapper.get(7L);
		System.out.println(department);
		
		session.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		
		EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
		DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
		
		//更新员工的部门id为null，再删除员工
		employeeMapper.updateDeptId(7L);
		departmentMapper.delete(7L);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testList() throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		
		session.close();
	}
	
}
