package com.company.day1.container.test;

import com.company.day1.container.dao.impl.SomeBeanDaoImpl;

public class SomeBeanFactory {
	
	public SomeBeanDaoImpl create(){
		SomeBeanDaoImpl bean = new SomeBeanDaoImpl();
		bean.init();
		return bean;
	}
	/*public static SomeBeanDaoImpl create(){
		SomeBeanDaoImpl bean = new SomeBeanDaoImpl();
		bean.init();
		return bean;
	}*/
}
