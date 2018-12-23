package com.company._6_transform;

public class Department {
	private Long id;
	private String name;
	
	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
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
