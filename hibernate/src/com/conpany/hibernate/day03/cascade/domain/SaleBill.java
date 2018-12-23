package com.conpany.hibernate.day03.cascade.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 销售对象
 * @author yonghui
 *
 */
public class SaleBill {
	private Long id;
	/**
	 * 销售单号
	 */
	private String sn;
	/**
	 * 销售单的录入时间
	 */
	private Date inputTime;
	/**
	 * 销售单的明细对象
	 */
	private Set<SaleBillItem> items = new HashSet<SaleBillItem>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public Set<SaleBillItem> getItems() {
		return items;
	}
	public void setItems(Set<SaleBillItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "SaleBill [id=" + id + ", sn=" + sn + ", inputTime=" + inputTime + "]";
	}
}
