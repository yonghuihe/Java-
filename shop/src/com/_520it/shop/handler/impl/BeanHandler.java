package com._520it.shop.handler.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com._520it.shop.handler.IResultSetHandler;

public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> clz;
	
	public BeanHandler(Class<T> clz) {
		this.clz = clz;
	}
	
	@Override
	public T handle(ResultSet rs) throws Exception {
		T obj = null;
		PropertyDescriptor[] pds = Introspector.getBeanInfo(clz, Object.class)
				.getPropertyDescriptors();
		if (rs.next()) {
			obj = clz.newInstance();
			for (PropertyDescriptor pd : pds) {
				String name = pd.getName();
				Object value = rs.getObject(name);
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return obj;
	}

}
