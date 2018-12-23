package com.company.jpa.extend2;

import javax.persistence.Entity;

@Entity
public class Book extends Product{
	private String isbn;
	private String author;

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + "]";
	}
}
