package com.company.day1.conDi;

public class SomeBean {
	private String name;
	private long maxConnection;
	private OtherBean other;

	public SomeBean(long maxConnection, OtherBean other) {
		this("name",maxConnection,other);
		System.out.println("----1----");
	}
	public SomeBean(String name, long maxConnection, OtherBean other) {
		super();
		System.out.println("----2----");
		this.name = name;
		this.maxConnection = maxConnection;
		this.other = other;
	}

	@Override
	public String toString() {
		return "SomeBean [name=" + name + ", maxConnection=" + maxConnection + ", other=" + other + "]";
	}

}
