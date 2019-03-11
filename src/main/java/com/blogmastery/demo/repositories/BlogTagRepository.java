package com.blogmastery.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.blogmastery.demo.models.BlogTag;
import com.blogmastery.demo.models.Post;

public interface BlogTagRepository extends CrudRepository<BlogTag, Long>{
	
	BlogTag findBlogTagByTagName(String tag);

	Optional<Post> findById(Post postId);
	

}
