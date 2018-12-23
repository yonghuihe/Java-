package com._520it.shop.dao;

import com._520it.shop.domain.User;

public interface IUserDAO {
	/**
	 * 检查登录
	 * @param username	用户名
	 * @return			用户对象
	 */
	User checkLogin(String username);
}
