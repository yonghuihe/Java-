package com._520it.shop.handler.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com._520it.shop.handler.IResultSetHandler;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
	private Class<T> clz;
	
	public BeanListHandler(Class<T> clz) {
		this.clz = clz;
	}
	
	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		PropertyDescriptor[] pds = Introspector.getBeanInfo(clz, Object.class)
				.getPropertyDescriptors();
		while (rs.next()) {
			T obj = clz.newInstance();
			for (PropertyDescriptor pd : pds) {
				String name = pd.getName();
				Object value = rs.getObject(name);
				pd.getWriteMethod().invoke(obj, value);
			}
			list.add(obj);
		}
		return list;
	}

}
