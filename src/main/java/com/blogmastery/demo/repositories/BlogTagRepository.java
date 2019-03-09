package com.blogmastery.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.blogmastery.demo.models.BlogTag;

public interface BlogTagRepository extends CrudRepository<BlogTag, Long>{
	
	BlogTag findBlogTagByTagName(String tag);
	

}
