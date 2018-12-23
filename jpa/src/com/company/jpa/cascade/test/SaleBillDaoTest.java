package com.company.jpa.cascade.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.cascade.dao.ISaleBillDao;
import com.company.jpa.cascade.dao.impl.SaleBillDaoImpl;
import com.company.jpa.cascade.domain.SaleBill;
import com.company.jpa.cascade.domain.SaleBillItem;

public class SaleBillDaoTest {

	private ISaleBillDao dao;

	public SaleBillDaoTest() {
		dao = new SaleBillDaoImpl();
	}

	@Before
	public void testSave() {
		SaleBill bill = new SaleBill();
		bill.setSn("bill");
		bill.setInputTime(new Date());

		SaleBillItem item1 = new SaleBillItem();
		item1.setProduct("p1");
		SaleBillItem item2 = new SaleBillItem();
		item2.setProduct("p2");

		bill.getItems().add(item1);
		bill.getItems().add(item2);
		item1.setBill(bill);
		item2.setBill(bill);

		dao.save(bill);

	}

	@Test
	public void testDelete() {
		dao.delete(1L);
	}

	@Test
	public void testUpdate2() {
		SaleBill bill = dao.get(1L);// 游离对象
		bill.setSn("newSn");

		SaleBillItem item = new SaleBillItem();// 临时对象
		item.setProduct("newProduct");
		item.setBill(bill);
		bill.getItems().add(item);

		SaleBillItem item1 = bill.getItems().iterator().next();// 游离对象
		item1.setProduct("newP");

		dao.update(bill);
	}

	@Test
	public void testUpdate() {
		// 销售订单对象
		SaleBill bill = dao.get(1L);
		// 删除销售订单对象中的明细对象
		SaleBillItem delete = bill.getItems().iterator().next();
		bill.getItems().remove(delete);

		// 调用业务方法更新（删除和主对象没有关系的销售明细对象）
		dao.update(bill);
	}

	@Test
	public void testGet() {
		SaleBill bill = dao.get(1L);
		System.out.println(bill);
	}

}
