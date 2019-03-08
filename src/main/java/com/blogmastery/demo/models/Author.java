package com.blogmastery.demo.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	private String author;
	@ManyToMany
	private Collection<Post> post;
	
	public Author() {}

	public Author(String author, Post ...post ) { /*this will tell it it s a list in an array*/
		
		this.author = author;
		this.post = Arrays.asList(post);
	}

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public Collection<Post> getPost() {
		return post;
	}

	
	
	
	
	
	
	
}
