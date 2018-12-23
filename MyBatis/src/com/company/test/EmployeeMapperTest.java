package com.company.test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.company.domain.Employee;
import com.company.mapper.EmployeeMapper;
import com.company.query.EmployeeQueryObject;
import com.company.service.impl.EmployeeServiceImpl;
import com.company.util.MyBatisUtil;
import com.company.util.PageResult;

public class EmployeeMapperTest {

	@Test
	public void testAdd() throws IOException {
		//创建SessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = builder.build(Resources.getResourceAsStream("mybatis.cfg.xml"));
		//创建session
		SqlSession session = sessionFactory.openSession();
		//创建员工对象，并设置值
		Employee employee = new Employee();
		employee.setUsername("jack");
		employee.setPassword("xx");
		employee.setAge(20);
		employee.setInputTime(new Date());
		
		//执行员工添加的方法
		session.insert("com.company.mapper.EmployeeMapper.add", employee);
		
		//提交事务
		session.commit();
		//关闭session
		session.close();
	}
	
	@Test
	public void testEdit() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		//创建员工对象，并设置值
		Employee employee = new Employee();
		employee.setId(35L);
		employee.setUsername("Eliet");
		employee.setPassword("update");
		employee.setAge(25);
		employee.setInputTime(new Date());
		
		//执行员工更新的方法
		session.update("com.company.mapper.EmployeeMapper.edit", employee);
		
		//提交事务
		session.commit();
		//关闭session
		session.close();
	}

	@Test
	public void testDelete() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		//执行员工删除的方法
		session.delete("com.company.mapper.EmployeeMapper.delete", 35L);
		
		//提交事务
		session.commit();
		//关闭session
		session.close();
	}

	@Test
	public void testSelectOne() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		//查询单个的方法
		Employee employee = session.selectOne("com.company.mapper.EmployeeMapper.selectOne", 1L);
		System.out.println(employee);
		
		//关闭session
		session.close();
	}

	@Test
	public void testSelectList() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		//员工查询多个的方法
		List<Employee> list = session.selectList("com.company.mapper.EmployeeMapper.selectList");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		//关闭session
		session.close();
	}

	@Test
	public void testGetOne() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		//员工查询多个的方法
		List<Employee> list = session.selectList("com.company.mapper.EmployeeMapper.getAll");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		//关闭session
		session.close();
	}

	@Test
	public void testQuery() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		EmployeeQueryObject qo = new EmployeeQueryObject();
		qo.setKeywords("j");
		//qo.setBeginDate(new Date());
		qo.setEndDate(new Date());
		
		//员工查询多个的方法
		List<Employee> list = session.selectList("com.company.mapper.EmployeeMapper.query",qo);
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		//关闭session
		session.close();
	}
	
	@Test
	public void testDeleteAll() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		List<Long> ids = new ArrayList<Long>();
		ids.add(9L);
		ids.add(10L);
		
		//执行员工删除的方法
		session.delete("com.company.mapper.EmployeeMapper.deleteAll", ids);
		
		//提交事务
		session.commit();
		//关闭session
		session.close();
	}
	
	@Test
	public void testAddAll() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		
		List<Employee> list = new ArrayList<Employee>();
		//创建员工对象，并设置值
		Employee employee = new Employee();
		employee.setUsername("jack");
		employee.setPassword("xx");
		employee.setAge(20);
		
		list.add(employee);
		list.add(employee);
		
		//执行员工添加的方法
		session.insert("com.company.mapper.EmployeeMapper.addAll", list);
		
		//提交事务
		session.commit();
		//关闭session
		session.close();
	}
	
	@Test
	public void testSelectPageResult() throws IOException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		EmployeeQueryObject qo = new EmployeeQueryObject();
		//qo.setKeywords("j");
		//qo.setBeginDate(new Date());
		//qo.setEndDate(new Date());
		//qo.setPage(2);
		//qo.setRows(2);
		
		PageResult pageResult = service.getPageResult(qo);
		
		System.out.println("总记录数"+pageResult.getTotal());
		
		List<Employee> list = pageResult.getRows();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}

	@Test
	public void testLogin() throws IOException {
		SqlSession session = MyBatisUtil.openSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		
		Employee employee = new Employee();
		employee.setUsername("Eliet");
		employee.setPassword("update");
		
		//employee = mapper.login("Eliet", "update");
		//employee = mapper.login(employee);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", "Eliet");
		map.put("password", "update");
		
		employee = mapper.login(map);
		
		System.out.println(employee);
		
	}

}
