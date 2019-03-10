package com.blogmastery.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogmastery.demo.models.Genre;
import com.blogmastery.demo.models.Post;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
	
	Genre findGenreByGenre(String genre);

	Optional<Post> findById(Post postId);

}
