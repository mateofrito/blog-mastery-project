package com.blogmastery.demo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogmastery.demo.models.Author;
import com.blogmastery.demo.models.BlogTag;
import com.blogmastery.demo.models.Genre;
import com.blogmastery.demo.models.Post;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.BlogTagRepository;
import com.blogmastery.demo.repositories.GenreRepository;
import com.blogmastery.demo.repositories.PostRepository;

@Controller
public class PostController {
	@Resource
	PostRepository postRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	AuthorRepository authorRepo;
	
	@Resource
	BlogTagRepository blogTagRepo;
	
	@GetMapping("/add")
	public String getPostForm(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", blogTagRepo.findAll());
		
		
		return "post-add";
		
	}
	@PostMapping("/add")
	public String addPost(String title, String body, String author, String tag, String genre) {
		Author postAuthor = authorRepo.findByAuthor(author);
		BlogTag postTag = blogTagRepo.findBlogTagByTagName(tag);
		Genre postGenre = genreRepo.findGenreByGenre(genre);
		
		Post newPost = postRepo.save(new Post(title, body, postAuthor, postGenre, postTag));
		
		return "redirect:" + newPost.getId();
		
	}
	
	@GetMapping("/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		Post postId = postRepo.findById(id).get();
		model.addAttribute("post", postId);
		
		
		
		
		return "post-submitted";
	}
	

	

	@GetMapping("/post/{id}")
	public String getSinglePost(@PathVariable Long id, Model model) {
		Post postId = postRepo.findById(id).get();
		model.addAttribute("post", postId);
		
		return "single-post";
	
	
	}
	
	@GetMapping("/allpost")
	public String getHomePage(Model model) {
		
		model.addAttribute("posts", postRepo.findAll());

		
		return "allpost";
		
	}
	
	
	
	
	
}	
		

