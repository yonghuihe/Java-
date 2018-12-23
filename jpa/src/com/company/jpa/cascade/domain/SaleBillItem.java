package com.company.jpa.cascade.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 销售对象的明细对象
 * 
 * @author yonghui
 *
 */
@Entity
public class SaleBillItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String product;
	
	@ManyToOne
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
