package com.conpany.hibernate.day03.one2one.domain;

public class QQNumber {
	private Long id;
	private String name;
	private QQZone zone;

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
	public QQZone getZone() {
		return zone;
	}
	public void setZone(QQZone zone) {
		this.zone = zone;
	}
	@Override
	public String toString() {
		return "QQNumber [id=" + id + ", name=" + name + "]";
	}
}
