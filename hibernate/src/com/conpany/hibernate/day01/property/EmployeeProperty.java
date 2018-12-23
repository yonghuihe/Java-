package com.conpany.hibernate.day01.property;

public class EmployeeProperty {

	private Long id;
	private String firstName;
	private String lastName;
	
	private String fullName;

	private String getFullName() {
		return firstName+","+lastName;
	}

	private void setFullName(String fullName) {
		if (fullName != null) {
			String[] names = fullName.split(",");
			if (names != null && names.length == 2) {
				firstName = names[0];
				lastName = names[1];
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeProperty [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
