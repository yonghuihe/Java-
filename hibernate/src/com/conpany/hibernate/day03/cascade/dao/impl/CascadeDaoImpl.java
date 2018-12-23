package com.conpany.hibernate.day03.cascade.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.conpany.hibernate.day03.cascade.dao.ICascadeDao;
import com.conpany.hibernate.day03.cascade.domain.SaleBill;
import com.conpany.hibernate.day03.cascade.domain.SaleBillItem;
import com.conpany.hibernate.util.HibernateUtil;

public class CascadeDaoImpl implements ICascadeDao {

	@Override
	public void save(SaleBill bill) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//级联保存
		session.save(bill);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//级联删除，删除主对象的时候，遍历主对象中的从对象，级联的删除从对象(先发删除从对象的SQL，在删除主对象的SQL)
		SaleBill bill = (SaleBill) session.get(SaleBill.class, id);
		session.delete(bill);
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 删除和主对象没有关系的销售明细对象
	 */
	@Override
	public void update(SaleBill bill) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//根据传进来的bill获取没有删除之前的SaleBill
		SaleBill oldBill = (SaleBill) session.get(SaleBill.class, bill.getId());
		List<SaleBillItem> items = new ArrayList<SaleBillItem>();
		//遍历SaleBillIem和billItem，找出删除的SaleBillItem对象
		for(SaleBillItem billItem :oldBill.getItems()){
			boolean find = false;
			for(SaleBillItem newItem : bill.getItems()){
				if (bill.getId() != null && billItem.getId().equals(newItem.getId())){
					find = true;
				}
			}
			if (!find){
				items.add(billItem);
			}
		}
		//打破SaleBillItem对象与SaleBill对象之间的关系
		oldBill.getItems().removeAll(items);
		for(SaleBillItem item : items){
			item.setBill(null);
		}
		//调用update方法更新
		session.update(oldBill);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	/**
	 * 修改销售订单对象（游离状态）
	 * 保存新的销售订单明细对象（临时状态）
	 * 修改修改过的销售订单明细对象
	 */
	public void update2(SaleBill bill) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		//级联更新
		session.update(bill);
		
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public SaleBill get(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		SaleBill bill = (SaleBill) session.get(SaleBill.class, id);
		//可以初始化一个代理对象（只能初始化bill中的items对象）
		Hibernate.initialize(bill.getItems());
		
		session.getTransaction().commit();
		session.close();
		return bill;
	}

}
