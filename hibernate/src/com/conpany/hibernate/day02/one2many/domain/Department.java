package com.conpany.hibernate.day02.one2many.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private Long id;
	private String name;
	private Set<Employee> emps = new HashSet<Employee>();

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
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Depratment [id=" + id + ", name=" + name + ", emps=" + emps + "]";
	}
}
