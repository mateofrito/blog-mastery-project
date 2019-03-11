package com.blogmastery.demo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogmastery.demo.models.Author;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.BlogTagRepository;
import com.blogmastery.demo.repositories.GenreRepository;
import com.blogmastery.demo.repositories.PostRepository;

@Controller
public class AuthorController {
	@Resource
	PostRepository postRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	AuthorRepository authorRepo;
	
	@Resource
	BlogTagRepository blogTagRepo;
	
	@GetMapping("/addauthor")
		public String getPostForm(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "/authors/author-add";
	}
	
	@PostMapping("/newauthor")
	public String addAuthor(String author) {
		authorRepo.save(new Author(author));
		return "redirect:/addauthor";	
		}
	
		
}
