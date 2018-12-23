package com.company.jpa.cascade.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 销售对象
 * 
 * @author yonghui
 *
 */
@Entity
public class SaleBill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String sn;
	private Date inputTime;
	
	@OneToMany(mappedBy="bill",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<SaleBillItem> items = new HashSet<>();

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
