package com.company.jpa.cascade.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import com.company.jpa.cascade.dao.ISaleBillDao;
import com.company.jpa.cascade.domain.SaleBill;
import com.company.jpa.cascade.domain.SaleBillItem;
import com.company.jpa.hello.util.JPAUtil;

public class SaleBillDaoImpl implements ISaleBillDao {

	@Override
	public void save(SaleBill bill) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.persist(bill);
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Long id) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		SaleBill bill = em.find(SaleBill.class, id);
		em.remove(bill);
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update2(SaleBill bill) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.merge(bill);
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 删除和主对象没有关系的销售明细对象
	 */
	@Override
	public void update(SaleBill bill) {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		//根据传进来的bill获取没有删除之前的SaleBill
				SaleBill oldBill = (SaleBill) em.find(SaleBill.class, bill.getId());
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
		em.merge(oldBill);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public SaleBill get(Long id) {
		EntityManager em = JPAUtil.getInstance().entityManager();

		SaleBill bill = em.find(SaleBill.class, id);
		Hibernate.initialize(bill.getItems());
		
		em.close();
		return bill;
	}
}
