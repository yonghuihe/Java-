package com.conpany.hibernate.day03.extend.domain;

public class Cloth extends Product{
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cloth [color=" + color + "]";
	}
}
