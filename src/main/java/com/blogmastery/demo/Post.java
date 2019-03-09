package com.blogmastery.demo;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.blogmastery.demo.models.Author;
import com.blogmastery.demo.models.BlogTag;
import com.blogmastery.demo.models.Genre;

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
	private String date;
	@ManyToOne
	private Genre genre;
	@ManyToMany
	private Collection<BlogTag> blogTags;
	
	public Post() {}

	public Post(String title, String body, Author author, String date, Genre genre, BlogTag ...blogTags) {
		this.title = title;
		this.body = body;
		this.author = Arrays.asList(author);
		this.date = date;
		this.genre = genre;
		this.blogTags = Arrays.asList(blogTags);
	}
	

	public String getBody() {
		return body;
	}

	public Collection<Author> getAuthor() {
		return author;
	}

	public String getDate() {
		return date;
	}

	public Genre getGenre() {
		return genre;
	}

	public Collection<BlogTag> getTags() {
		return blogTags;
	}

	public Long getId() {

		return id;
	}

	public String getTitle() {
		
		return title;
	}

}
