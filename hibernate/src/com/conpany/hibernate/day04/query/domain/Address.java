package com.conpany.hibernate.day04.query.domain;

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
