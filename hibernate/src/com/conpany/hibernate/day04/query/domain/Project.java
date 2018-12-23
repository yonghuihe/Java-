package com.conpany.hibernate.day04.query.domain;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private Long id;
	private String name;
	
	private Employee manager;//MANAGER_ID
	private Set<Employee> employees = new HashSet<Employee>();//project_employee EMPLOYEE_ID/PROJECT_ID
	
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
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
}
