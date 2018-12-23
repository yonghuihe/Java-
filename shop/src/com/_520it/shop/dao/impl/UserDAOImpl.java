package com._520it.shop.dao.impl;

import com._520it.shop.dao.IUserDAO;
import com._520it.shop.domain.User;
import com._520it.shop.handler.impl.BeanHandler;
import com._520it.shop.util.JdbcTemplate;

public class UserDAOImpl implements IUserDAO{

	@Override
	public User checkLogin(String username) {
		String sql = "select * from t_user where username = ?";
		User user = JdbcTemplate.query(sql, new BeanHandler<>(User.class), username);
		return user;
	}
}
