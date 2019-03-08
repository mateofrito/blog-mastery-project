package com.blogmastery.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@Lob
	private String body;
	private String author;
	private String date;
	private String genre;
	private String tags;
	
	public Post() {}

	public Post(String title, String body, String author, String date, String genre, String tags) {
		this.title = title;
		this.body = body;
		this.author = author;
		this.date = date;
		this.genre = genre;
		this.tags = tags;
	}
	

	public String getBody() {
		return body;
	}

	public String getAuthor() {
		return author;
	}

	public String getDate() {
		return date;
	}

	public String getGenre() {
		return genre;
	}

	public String getTags() {
		return tags;
	}

	public Long getId() {

		return id;
	}

	public Object getTitle() {
		
		return title;
	}

}
