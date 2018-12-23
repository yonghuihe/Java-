package com.company.jpa.component;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	private Address address;
	
	
	@AttributeOverrides({
		@AttributeOverride(name="provice",column=@Column(name="REG_PROVICE")),
		@AttributeOverride(name="city",column=@Column(name="REG_CITY")),
		@AttributeOverride(name="street",column=@Column(name="REG_STREET"))
	})
	private Address regAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(Address regAddress) {
		this.regAddress = regAddress;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", regAddress=" + regAddress + "]";
	}

}
