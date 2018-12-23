package com._520it.shop.handler.impl;

import java.sql.ResultSet;

import com._520it.shop.handler.IResultSetHandler;



public class ScalerHandler implements IResultSetHandler<Long>{
	public Long handle(ResultSet rs) throws Exception {
		Long value = 0L;
		if (rs.next()) {
			value = rs.getLong(1);
		}
		return value;
	}
}

