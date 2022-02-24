package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Blog;


public interface BlogService {
	
	List<Blog> getAllBlogs();
	
	void saveBlog(Blog blog);
	
	Blog getBlogById(long id);
	
	void deleteBlog(long id);
	
}
