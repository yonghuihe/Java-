package com.company._6_transform;

public class Employee implements IJsonObject{
	private Long id;
	private String name;
	private Department dept;
	
	public Employee() {
		super();
	}

	public Employee(Long id, String name, Department dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	public Object toJson() {
		return new EmployeeVO(id,name,dept.getId(),dept.getName());
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

	
}
