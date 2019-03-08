package com.blogmastery.demo.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long id;
	private String tag;
	
	@ManyToMany
	private Collection<Post> post;
	
	public Tag () {}
	
	public Tag (String tag) {
		this.tag = tag;
		
	}

	public Long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public Collection<Post> getPost() {
		return post;
	}
	
	
	

}
