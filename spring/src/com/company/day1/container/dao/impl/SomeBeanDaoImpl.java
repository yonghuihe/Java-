package com.company.day1.container.dao.impl;

import com.company.day1.container.dao.ISomeBeanDao;

public class SomeBeanDaoImpl implements ISomeBeanDao {
	public SomeBeanDaoImpl() {
		System.out.println("init");
	}
	
	public void init(){}
	
	@Override
	public void print(){
		System.out.println("SomeBean");
	}
}
