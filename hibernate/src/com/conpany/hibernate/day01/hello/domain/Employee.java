package com.conpany.hibernate.day01.hello.domain;

import java.util.Date;

public class Employee {

	private Long id;
	private String name;
	private Integer age;
	private Date hiredate;
	
	public Employee() {
		super();
	}
	public Employee( String name, Integer age, Date hiredate) {
		super();
		this.name = name;
		this.age = age;
		this.hiredate = hiredate;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", hiredate=" + hiredate + "]";
	}
	
}
