package com.company.day1.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class SomeBeanFactory implements FactoryBean<SomeBean> {

	/**
	 * 工厂创建bean的方法
	 */
	@Override
	public SomeBean getObject() throws Exception {
		SomeBean bean = new SomeBean();
		bean.init();
		return bean;
	}

	/**
	 * 方法返回工厂生产出来的对象的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return SomeBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
