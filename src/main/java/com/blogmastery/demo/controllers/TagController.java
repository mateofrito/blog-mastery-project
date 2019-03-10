package com.blogmastery.demo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogmastery.demo.models.BlogTag;
import com.blogmastery.demo.repositories.AuthorRepository;
import com.blogmastery.demo.repositories.BlogTagRepository;
import com.blogmastery.demo.repositories.GenreRepository;
import com.blogmastery.demo.repositories.PostRepository;

@Controller
public class TagController {
	@Resource
	PostRepository postRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	AuthorRepository authorRepo;
	
	@Resource
	BlogTagRepository blogTagRepo;
	
	@GetMapping("/addtag")
		public String getPostForm(Model model) {
		model.addAttribute("tags", blogTagRepo.findAll());
		return "/tags/tag-add";
		
	}
	@PostMapping("/newtag")
	public String addTag(String tagName) {
		blogTagRepo.save(new BlogTag(tagName));
		return "redirect:/addtag";	
		}
	
		
}
