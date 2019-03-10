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
		BlogTag blogTagThree = blogTagRepo.save(new BlogTag("Sport"));
		BlogTag blogTagFour = blogTagRepo.save(new BlogTag("Technology"));
		
		Genre genreFour = genreRepo.save(new Genre("Technology"));
		Genre genreOne = genreRepo.save(new Genre("romance"));
		Genre genreTwo = genreRepo.save(new Genre("sexual situations"));
		Genre genreThree = genreRepo.save(new Genre("Sport"));
		
		

		postRepo.save(new Post("First Blog Post","I really wish Donny let us use Gatsby.Js", authorOne, genreOne, blogTagOne));
		postRepo.save(new Post("Secong Blog Post about Dogs", "I like dogs", authorTwo, genreTwo, blogTagTwo));		
		postRepo.save(new Post("IS THIS THE START OF A GREAT UNITED STRIKE ", "Both players were stars in Paris and there will hopefully be much more to come as the season builds towards its climax. And while Solskjaer feels he hasn't been in charge long enough to see much development in Rashford, he's in no doubt about the youngster's quality.", authorTwo, genreThree, blogTagThree));
		postRepo.save(new Post("The US Air Force�s jet-powered robotic wingman is like something out of a video game ", "Science", authorTwo, genreFour, blogTagFour)
		postRepo.save(new Post("What is Lorem Ipsum?","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", authorOne, genreOne, blogTagOne));
		postRepo.save(new Post("Why do we use it?", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", authorTwo, genreTwo, blogTagTwo));		

		
		
		
		
		
		
	}
	
	
	
	

}
