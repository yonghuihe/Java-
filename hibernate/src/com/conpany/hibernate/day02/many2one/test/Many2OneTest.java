package com.conpany.hibernate.day02.many2one.test;

import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day02.many2one.dao.IDepartmentDao;
import com.conpany.hibernate.day02.many2one.dao.IEmployeeDao;
import com.conpany.hibernate.day02.many2one.dao.impl.DepartmentDaoImpl;
import com.conpany.hibernate.day02.many2one.dao.impl.EmployeeDaoImpl;
import com.conpany.hibernate.day02.many2one.domain.Department;
import com.conpany.hibernate.day02.many2one.domain.Employee;

public class Many2OneTest {
	
	private IEmployeeDao employeeDao;
	private IDepartmentDao departmentDao;
	
	public Many2OneTest(){
		employeeDao = new EmployeeDaoImpl();
		departmentDao = new DepartmentDaoImpl();
	}
	
	
	@Test
	public void testSave() throws Exception {
		Department d = new Department();
		d.setName("d");
		departmentDao.save(d);
		
		Employee e1 = new Employee();
		e1.setName("e1");
		e1.setDept(d);
		employeeDao.save(e1);
		
		Employee e2 = new Employee();
		e2.setName("e2");
		e2.setDept(d);
		employeeDao.save(e2);
	}
	
	/**
	 * 1.通过many方拿one方，使用延迟加载
	 * 2.可以通过ifnull来判断many方是否有one方关联
	 * 3.拿到的one方必须在session关闭之前实例化，否则不能使用（报no session错误）
	 * @throws Exception
	 */
	@Test
	public void testGet() throws Exception {
		Employee emp = employeeDao.get(1L);
		Department dept = emp.getDept();
		System.out.println(emp);
		/*if(dept != null){
			System.out.println("员工属于一个部门");
		} else{
			System.out.println("员工不属于一个部门");
		}*/
		/*Department department = departmentDao.get(1L);
		System.out.println(department);*/
	}
}
