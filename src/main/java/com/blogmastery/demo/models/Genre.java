package com.blogmastery.demo.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.blogmastery.demo.Post;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;
	private String genre;
	@OneToMany(mappedBy="genre")
	private Collection<Post> post;
	
	
	
	public Genre() {}
	
	public Genre(String genre) {
		this.genre = genre;
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

	
	public String toString() {
		return this.getGenre() + " " + this.getPost();
	}
	
	
	

}
