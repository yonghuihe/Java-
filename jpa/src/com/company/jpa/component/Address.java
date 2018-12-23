package com.company.jpa.component;

import javax.persistence.Embeddable;

/**
 * @Embeddable:可嵌入对象，代表这个对象不是一个实体对象，是一个需要嵌入到宿主对象中才有意义的对象
 * @author yonghui
 *
 */
@Embeddable
public class Address {
	private String provice;
	private String city;
	private String street;

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [provice=" + provice + ", city=" + city + ", street=" + street + "]";
	}

}
