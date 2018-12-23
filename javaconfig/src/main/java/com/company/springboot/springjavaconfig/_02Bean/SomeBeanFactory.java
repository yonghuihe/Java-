package com.company.springboot.springjavaconfig._02Bean;

import org.springframework.beans.factory.FactoryBean;

public class SomeBeanFactory implements FactoryBean<SomeBean> {

	@Override
	public SomeBean getObject() throws Exception {
		return new SomeBean();
	}

	@Override
	public Class<?> getObjectType() {
		return SomeBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
