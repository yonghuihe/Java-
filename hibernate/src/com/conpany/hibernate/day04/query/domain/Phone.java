package com.conpany.hibernate.day04.query.domain;

public class Phone {
	private Long id;
	private PhoneTypes types;
	private String number;
	
	private Employee employee;//EMPLOYEE_ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneTypes getTypes() {
		return types;
	}

	public void setTypes(PhoneTypes types) {
		this.types = types;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Phone [id=" + id + ", types=" + types + ", number=" + number + "]";
	}
}
