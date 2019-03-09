package com.blogmastery.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.blogmastery.demo.models.Author;
import com.blogmastery.demo.models.BlogTag;
import com.blogmastery.demo.models.Genre;
import com.blogmastery.demo.models.Post;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.BlogTagRepository;
import com.blogmastery.demo.repositories.GenreRepository;
import com.blogmastery.demo.repositories.PostRepository;

@Service
public class Initializer implements CommandLineRunner {
	
	@Resource
	AuthorRepository authorRepo;
	
	@Resource
	BlogTagRepository blogTagRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Author authorOne = authorRepo.save(new Author("Fry"));
		Author authorTwo = authorRepo.save(new Author("Bini"));
		
		BlogTag blogTagOne = blogTagRepo.save(new BlogTag("github"));
		BlogTag blogTagTwo = blogTagRepo.save(new BlogTag("problems"));
		
		Genre genreOne = genreRepo.save(new Genre("romance"));
		Genre genreTwo = genreRepo.save(new Genre("sexual situations"));
		
		postRepo.save(new Post("First Blog Post","I really wish Donny let us use Gatsby.Js", authorOne, genreOne, blogTagOne));
		postRepo.save(new Post("Secong Blog Post about Dogs", "I like dogs", authorTwo, genreTwo, blogTagTwo));		
		
		
		
		
		
		
	}
	
	
	
	

}
