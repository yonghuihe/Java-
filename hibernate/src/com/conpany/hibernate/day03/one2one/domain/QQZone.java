package com.conpany.hibernate.day03.one2one.domain;

public class QQZone {
	private Long id;
	private String title;
	private QQNumber number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QQNumber getNumber() {
		return number;
	}
	public void setNumber(QQNumber number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "QQZone [id=" + id + ", title=" + title + "]";
	}
}
