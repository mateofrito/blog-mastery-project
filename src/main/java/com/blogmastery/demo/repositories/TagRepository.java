package com.blogmastery.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogmastery.demo.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	Tag findbyTag(String tag);
	

	

}
