package com.conpany.hibernate.day04.query.domain;

import java.math.BigDecimal;

public class EmployeeVO {
	private Long id;
	private String name;
	private BigDecimal salary;
	private String deptName;
	private String deptSn;
	private String city;

	public EmployeeVO() {
		super();
	}
	public EmployeeVO(Long id, String name, BigDecimal salary, String deptName, String deptSn, String city) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deptName = deptName;
		this.deptSn = deptSn;
		this.city = city;
	}
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
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptSn() {
		return deptSn;
	}
	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", salary=" + salary + ", deptName=" + deptName + ", deptSn="
				+ deptSn + ", city=" + city + "]";
	}
}
