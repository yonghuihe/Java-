package com._520it.shop.dao.impl;

import java.util.List;

import com._520it.shop.dao.IProductDAO;
import com._520it.shop.domain.Product;
import com._520it.shop.handler.IResultSetHandler;
import com._520it.shop.handler.impl.BeanHandler;
import com._520it.shop.handler.impl.BeanListHandler;
import com._520it.shop.util.JdbcTemplate;

public class ProductDAOImpl implements IProductDAO {
	private IResultSetHandler<List<Product>> rsh = new BeanListHandler<>(Product.class);
	private IResultSetHandler<Product> beanHandler = new BeanHandler<>(Product.class);
	//private IResultSetHandler<Integer> scaler = new ScalerHandler();
	
	/*public PageResult query(IQuery qo) {
		//��ѯҳ����ʾ�����
		String sql = "SELECT * FROM product" + qo.getWhereAndLimitCase(true);
		List<Object> params = qo.getParams(true);
		System.out.println("querySql -> " + sql);
		System.out.println("params -> " + params);
		List<Product> data = JdbcTemplate.query(sql, rsh, params.toArray());
		//----------------------
		//��ѯ����������ܼ�¼��
		sql = "SELECT count(*) FROM product" + qo.getWhereAndLimitCase(false);
		params = qo.getParams(false);
		System.out.println("countSql -> " + sql);
		System.out.println("params -> " + params);
		Integer totalCount = JdbcTemplate.query(sql, scaler, params.toArray());
		return new PageResult(data, qo.getCurrentPage(), totalCount);
	}*/

	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		return JdbcTemplate.query(sql, beanHandler, id);
	}

	public void update(Product product) {
		String sql = "UPDATE product SET productName = ?, salePrice = ?, dir_id = ?, supplier = ?, brand = ?, cutoff = ?, costPrice = ? WHERE id = ?";
		Object[] params = {product.getProductName(), product.getSalePrice(), product.getDir_id(),
				product.getSupplier(), product.getBrand(), product.getCutoff(), 
				product.getCostPrice(), product.getId()};
		JdbcTemplate.update(sql, params);
	}

	public void save(Product product) {
		String sql = "INSERT product(productName, salePrice, dir_id, supplier, brand, cutoff, costPrice) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {product.getProductName(), product.getSalePrice(), 
				product.getDir_id(), product.getSupplier(), product.getBrand(), 
				product.getCutoff(), product.getCostPrice()};
		JdbcTemplate.update(sql, params);
	}

	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public List<Product> list() {
		String sql = "select * FROM product";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Product.class));
	}
}
