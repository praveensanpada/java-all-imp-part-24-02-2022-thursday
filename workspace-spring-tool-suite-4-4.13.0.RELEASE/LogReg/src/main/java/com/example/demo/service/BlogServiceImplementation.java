package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Blog;
import com.example.demo.repository.BlogRepository;

@Service
public class BlogServiceImplementation implements BlogService{
	
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}
	
	@Override
	public void saveBlog(Blog blog) {
		this.blogRepository.save(blog);
	}
	
	@Override
	public Blog getBlogById(long id) {
		java.util.Optional<Blog>  optional = blogRepository.findById(id);
		Blog employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Blog Not Found");
		}
		return employee;
	}
	
	@Override
	public void deleteBlog(long id) {
		this.blogRepository.deleteById(id);
	}

}
