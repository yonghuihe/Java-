package com._520it.shop.dao;

import java.util.List;

import com._520it.shop.domain.Product;

public interface IProductDAO {
	void save(Product stu);
	
	void update(Product stu);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> list();
}
