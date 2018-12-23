package com.conpany.hibernate.day04.query.domain;

public class Department {
	private Long id;
	private String name;
	private String sn;
	
	private Address address;
	private Employee employee;//MANAGER_ID

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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
