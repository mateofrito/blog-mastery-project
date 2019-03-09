package com.blogmastery.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogmastery.demo.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	
	Post findByTitle (String title);
	
}
