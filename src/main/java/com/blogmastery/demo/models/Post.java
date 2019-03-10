package com.blogmastery.demo.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@Lob
	private String body;
	@ManyToMany
	private Collection<Author> author;
	private LocalDateTime date;
	@ManyToOne
	private Genre genre;
	@ManyToMany
	private Collection<BlogTag> tag;
	
	public Post() {}

	public Post(String title, String body, Author author, Genre genre, BlogTag ...tag) {
		this.title = title;
		this.body = body;
		this.author = Arrays.asList(author);
		this.date = LocalDateTime.now();
		this.genre = genre;
		this.tag = Arrays.asList(tag);
	}
	

	public String getBody() {
		return body;
	}

	public Collection<Author> getAuthor() {
		return author;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Genre getGenre() {
		return genre;
	}

	public Collection<BlogTag> getTag() {
		return tag;
	}

	public Long getId() {

		return id;
	}

	public String getTitle() {
		
		return title;
	}
//	@Override
//	public String toString() {
//		return "Title: " + this.getTitle() +  "; Author: " + this.getAuthor() + "; Genre: " + this.getGenre().getGenre() + "; Body:" + this.getBody() + "; Tags: "+ this.getTag();
//  }

	
	
//	public void addTagToTags(BlogTag tag) {
//		tag.add(tag);
//	}
//	
//	public void addAuthorToAuthors(Author author) {
//		author.add(author);
//	}
//
	
	
}
