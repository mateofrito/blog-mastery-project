package com.blogmastery.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogmastery.demo.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
	
	Genre findGenreByGenre(String genre);

}
