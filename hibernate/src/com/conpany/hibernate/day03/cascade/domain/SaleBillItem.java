package com.conpany.hibernate.day03.cascade.domain;

/**
 * 销售对象的明细对象
 * @author yonghui
 *
 */
public class SaleBillItem {
	private Long id;
	/**
	 * 商品对象，这里简单写成字符串类型
	 */
	private String product;
	/**
	 * 销售对象
	 */
	private SaleBill bill;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public SaleBill getBill() {
		return bill;
	}
	public void setBill(SaleBill bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "SaleBillItem [id=" + id + ", product=" + product + "]";
	}
}
