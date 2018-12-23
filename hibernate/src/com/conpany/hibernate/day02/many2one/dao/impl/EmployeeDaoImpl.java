package com.conpany.hibernate.day02.many2one.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.conpany.hibernate.day02.many2one.dao.IEmployeeDao;
import com.conpany.hibernate.day02.many2one.domain.Employee;
import com.conpany.hibernate.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void save(Employee e) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Employee get(Long id) {
		Session session = null;
		try{			
			session = HibernateUtil.getInstance().openSession();
			Employee emp = (Employee) session.get(Employee.class, id);
			return emp;
		} catch (HibernateException ex){
			ex.printStackTrace();
		} finally{
			session.close();
		}
		return null;
	}
}
