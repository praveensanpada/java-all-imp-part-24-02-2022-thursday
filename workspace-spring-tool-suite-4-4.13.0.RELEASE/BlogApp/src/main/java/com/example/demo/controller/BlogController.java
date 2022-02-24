package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogController {
	
	@GetMapping("/")
	public String HomePage(Model model) {
		return "index";
	}

}
