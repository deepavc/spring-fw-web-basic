package com.deepavc.group.springstartup.dto;

import java.util.List;

public class BooksAndAuthors {

	public BooksAndAuthors() {
		super();
	}

	private String name;
	private String isbn;
	private String publisherName;
	private String publisherAddress;
	private List<String> author;

	public BooksAndAuthors(String name, String isbn, String publisherName, String publisherAddress, List<String> author) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

}
