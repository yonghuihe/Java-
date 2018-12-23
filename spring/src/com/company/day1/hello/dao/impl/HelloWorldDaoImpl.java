package com.company.day1.hello.dao.impl;

import com.company.day1.hello.dao.IHelloWorldDao;

public class HelloWorldDaoImpl implements IHelloWorldDao {

	@Override
	public void hello() {
		System.out.println("hello spring man");
	}

}
