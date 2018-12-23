package com.company.day2.dynProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.day2.dynProxy.txManager.TransactionManager;

public class TransactionInvocationHandler implements InvocationHandler {
	@Autowired
	private Object obj;
	@Autowired
	private TransactionManager txManager;

	public TransactionInvocationHandler(Object obj,TransactionManager txManager) {
		this.obj = obj;
		this.txManager = txManager;
	}

	/**
	 * employee.update(new Employee());
	 * 	employee:是Proxy对象生产的代理对象
	 * 	method:就是代理对象调用的方法：update
	 * 	args:就是代理对象调用的方法时传递的参数：new Employee（）
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		txManager.begin();
		try {
//			System.out.println(method);
//			System.out.println(Arrays.toString(args));
			Object invoke = method.invoke(obj, args);
			txManager.commit();
			return invoke;
		} catch (Exception e) {
			txManager.rollback();
		}
		return null;
	}
}
