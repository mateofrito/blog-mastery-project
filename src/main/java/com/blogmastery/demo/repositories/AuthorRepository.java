package com.blogmastery.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogmastery.demo.models.Author;
import com.blogmastery.demo.models.Post;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	Post findByAuthor (String author);
	
}

