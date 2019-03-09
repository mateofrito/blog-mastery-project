package com.blogmastery.demo.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.blogmastery.demo.Post;

@Entity
public class BlogTag {
	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	
	@ManyToMany(mappedBy="blogTags")
	private Collection<Post> post;
	
	public BlogTag () {}
	
	public BlogTag (String tagName) {
		this.tagName = tagName;
		
	}

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Collection<Post> getPost() {
		return post;
	}
	
	
	

}
