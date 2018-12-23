package com.company.day2.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.InvocationHandler;

public class LoginInvocationHandler implements InvocationHandler {
	@Autowired
	private SomeBean target;

	public LoginInvocationHandler(SomeBean target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("日志-->时间："+new Date()+"当前你调用了："+method+"方法，传入的参数是："+Arrays.toString(args));
		return method.invoke(target, args);
	}
}
