package com.blogmastery.demo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogmastery.demo.models.Genre;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.BlogTagRepository;
import com.blogmastery.demo.repositories.GenreRepository;
import com.blogmastery.demo.repositories.PostRepository;

@Controller
public class GenreController {
	@Resource
	PostRepository postRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	AuthorRepository authorRepo;
	
	@Resource
	BlogTagRepository blogTagRepo;
	
	@GetMapping("/addgenre")
		public String getPostForm(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		return "/genres/genre-add";
	}
	
	@PostMapping("/newgenre")
	public String addGenre(String genre) {
		genreRepo.save(new Genre(genre));
		return "redirect:/addgenre";	
		}
	
	@GetMapping("/genre/{genre}")
	public String getGenre(@PathVariable String genre, Model model) {
		
		model.addAttribute("genre", genreRepo.findGenreByGenre(genre));
		return "/genres/genre";
	}
		
}
