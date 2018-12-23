package com.conpany.hibernate.day03.cascade.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day03.cascade.dao.ICascadeDao;
import com.conpany.hibernate.day03.cascade.dao.impl.CascadeDaoImpl;
import com.conpany.hibernate.day03.cascade.domain.SaleBill;
import com.conpany.hibernate.day03.cascade.domain.SaleBillItem;

public class CascadeTest {
	
	private ICascadeDao dao;
	
	public CascadeTest(){
		dao = new CascadeDaoImpl();
	}

	@Before
	public void testSave() throws Exception {
		//销售明细对象
		SaleBillItem item1 = new SaleBillItem();
		item1.setProduct("Item1");
		SaleBillItem item2 = new SaleBillItem();
		item2.setProduct("Item2");
		SaleBillItem item3 = new SaleBillItem();
		item3.setProduct("Item3");
		//销售对象
		SaleBill bill = new SaleBill();
		bill.setSn("bill");
		bill.setInputTime(new Date());
		bill.getItems().add(item1);
		bill.getItems().add(item2);
		bill.getItems().add(item3);
		
		//维护关系,many方：inverse=true,所以one方来维护关系
		item1.setBill(bill);
		item2.setBill(bill);
		item3.setBill(bill);
		
		//级联保存
		dao.save(bill);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1L);
	}
	
	/**
	 * update：
	 * 	1、修改销售订单对象（游离状态）
	 * 	2、修改新添加的销售订单明细对象（临时状态）
	 * 	3、修改修改过的销售订单明细对象（游离状态）
	 * @throws Exception
	 */
	@Test
	public void testUpdate2() throws Exception {
		SaleBill bill = dao.get(1L);//游离对象
		bill.setSn("newSn");
		
		SaleBillItem item = new SaleBillItem();//临时对象
		item.setProduct("newProduct");
		item.setBill(bill);
		bill.getItems().add(item);
		
		SaleBillItem item1 = bill.getItems().iterator().next();//游离对象
		item1.setProduct("newP");
		
		dao.update2(bill);
	}
	/**
	 * update:
	 * 	删除去掉了销售订单明细对象（删除和主对象没有关系的销售明细对象）
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		//销售订单对象
		SaleBill bill = dao.get(1L);
		//删除销售订单对象中的明细对象
		SaleBillItem delete = bill.getItems().iterator().next();
		bill.getItems().remove(delete);
		
		//调用业务方法更新（删除和主对象没有关系的销售明细对象）
		dao.update(bill);
	}
}
