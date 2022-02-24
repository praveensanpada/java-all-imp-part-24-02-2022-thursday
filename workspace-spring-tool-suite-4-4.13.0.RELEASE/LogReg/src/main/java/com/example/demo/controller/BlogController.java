package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;



@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	public static String uploadDirPath = System.getProperty("user.dir")+"/src/main/resources/static/images/";
	
	@GetMapping("/")
	public String HomePage(Model model) {
		model.addAttribute("blogList", blogService.getAllBlogs());
//		System.out.print(blogService.getAllBlogs());
		return "index";
	}
	
	@GetMapping("/about")
	public String AboutPage(Model model) {
		return "about";
	}
	
	@GetMapping("/blogDetails/{id}")
	public String BlogDetails(@PathVariable (value = "id") long  id, Model model) {
		model.addAttribute("blog", blogService.getBlogById(id));
		return "blogDetails";
	}
	
	@GetMapping("/contact")
	public String ContactPage(Model model) {
		return "contact";
	}
	
	@GetMapping("/addBlog")
	public String AddBlogPage(Model model) {
		Blog blog = new Blog();
		model.addAttribute("blog", blog);
		return "addBlog";
	}
	
	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String SaveNewBlog( @ModelAttribute("blog") Blog blog, Model model) {
		
//		if(bindingResult.hasErrors()) {
////			System.out.println(bindingResult.toString());
//            model.addAttribute("blog", blog);
////            model.addAttribute("blogErr", bindingResult.toString());
//            return "addBlog";
//        }
		
		String fileName = blog.getFile().getOriginalFilename();
		System.out.println(fileName);
		try {
            Path path = Paths.get(uploadDirPath + fileName);
            Files.write(path, blog.getFile().getBytes());
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
		blog.setImage(fileName);
		
		blogService.saveBlog(blog);
		return "redirect:/";
	}
	
	@GetMapping("/updateBlog/{id}")
	public String updateBlog(@PathVariable (value = "id") long  id, Model model) {
		Blog blog = blogService.getBlogById(id);
		model.addAttribute("blog", blog);
		return "updateBlog";
	}

	@RequestMapping(value = "/updateOldBlog", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String updateOldBlog(@ModelAttribute("blog") Blog blog) {
		
		String fileName = blog.getFile().getOriginalFilename();
		System.out.println(fileName);
		try {
            Path path = Paths.get(uploadDirPath + fileName);
            Files.write(path, blog.getFile().getBytes());
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
		blog.setImage(fileName);
		
		blogService.saveBlog(blog);
		return "redirect:/";
	}
	
	@GetMapping("/deleteBlog/{id}")
	public String deleteBlog(@PathVariable (value = "id") long  id) {
		this.blogService.deleteBlog(id);;
		return "redirect:/";
	}
}
