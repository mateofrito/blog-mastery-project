package com.blogmastery.demo.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class BlogTag {
	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	
	@ManyToMany(mappedBy="tag")
	private Collection<Post> post = new ArrayList<Post>();
	
	@Override
	public String toString() {
		return "BlogTag [id=" + id + ", tagName=" + tagName + ", post=" + post + "]";
	}

	public BlogTag () {}
	
	public BlogTag (String tagName) {
		this.tagName = tagName;
		
	}
	
	public BlogTag (String tagName, Collection<Post> post)
	{this.tagName=tagName;
	this.post=post;
	
		
		
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
