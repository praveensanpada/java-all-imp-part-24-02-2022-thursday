package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;


@RestController
public class HomeController {

//	BlogRepository blogRepo;
	@Autowired
	private BlogService blogService;

	@Autowired
	BlogRepository blogRepository;

	@PostMapping(value = { "/blog" })
	public Blog addBlog(@RequestBody Blog blog) {
//		System.out.println(blog.getTitle());
		return this.blogService
			.addBlog(blog);
	}

	@GetMapping(value = { "/blog" })
	public List<Blog> getAuthor() {
		try {
//			List<Blog> blog = (List<Blog>)blogRepository.findAll();
			List<Blog> blog = blogService
				.getAllBlogs();
			return blog;
		} catch (Exception e) {
			e
				.printStackTrace();
			return null;
		}
	}
}
