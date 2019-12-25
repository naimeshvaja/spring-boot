package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/index")
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	@PostMapping("/create")
	public Post createPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}
}
