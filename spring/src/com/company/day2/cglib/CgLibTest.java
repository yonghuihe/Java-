package com.company.day2.cglib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CgLibTest {
	@Test
	public void testCgLib() throws Exception {
		SomeBean target = new SomeBean();
		//增强器
		Enhancer enhancer = new Enhancer();
		//类加载器
		enhancer.setClassLoader(target.getClass().getClassLoader());
		//设置这个动态代理的父类
		enhancer.setSuperclass(SomeBean.class);
		//设置要传入的拦截器
		enhancer.setCallback(new LoginInvocationHandler(target));
		//使用create方法创建代理对象
		SomeBean someBean = (SomeBean) enhancer.create();
		//调用方法
		someBean.print1();
	}
}
