package com.blogmastery.demo.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;
	private String genre;
	@OneToMany(mappedBy="genre")
	private Collection<Post> post = new ArrayList<Post>();
	
	
	
	public Genre() {}
	
	public Genre(String genre) {
		this.genre = genre;
	}
	
	public Genre(String genre, Collection<Post> post) {
		this.genre = genre;
		this.post = post;
	}
	
	public Long getId() {
		return id;
	}

	public String getGenre() {
		return genre;
	}

	public Collection<Post> getPost() {
		return post;
	}

	@Override
	public String toString() {
		return this.getGenre() + " " + this.getPost();
	}

	
	
	
	
	
	

}
