package com.conpany.hibernate.day02.many2one.dao.impl;

import org.hibernate.Session;

import com.conpany.hibernate.day02.many2one.dao.IDepartmentDao;
import com.conpany.hibernate.day02.many2one.domain.Department;
import com.conpany.hibernate.util.HibernateUtil;

public class DepartmentDaoImpl implements IDepartmentDao{

	@Override
	public void save(Department d) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Department get(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
		Department dept = (Department) session.get(Department.class, id);
		session.close();
		return dept;
	}
}
