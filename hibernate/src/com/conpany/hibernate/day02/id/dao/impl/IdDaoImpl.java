package com.conpany.hibernate.day02.id.dao.impl;

import org.hibernate.Session;

import com.conpany.hibernate.day02.id.dao.IIdDao;
import com.conpany.hibernate.day02.id.domain.Id;
import com.conpany.hibernate.util.HibernateUtil;

public class IdDaoImpl implements IIdDao {

	@Override
	public void save(Id idDomain) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		session.save(idDomain);
		session.getTransaction().commit();
		session.close();
		
	}

}
