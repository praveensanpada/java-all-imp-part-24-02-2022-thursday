package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;



@Controller
@RequestMapping("/author")
public class SecurityController {

	@Autowired
	AuthorService authorService;

	@RequestMapping(value = "/login")
	public String authorLogin() {
		return "/author/login";
	}

	@GetMapping(value = "/register")
	public String authorRegister(Model model) {
		Author author = new Author();
		model
			.addAttribute("author", author);
		return "/author/register";
	}

	@PostMapping(value = "/register", consumes = "application/x-www-form-urlencoded")
	public String authorRegisterPost(@Valid Author author, BindingResult result) {
		try {

//			if (checkAuthor != null) {
//				result
//					.rejectValue("email", "error.user", "There is already a user registered with the email provided");
//			}
			if (result
				.hasErrors()) {
				return "/author/register";
			}

			Author a = authorService
				.addAuthor(author);
			if (a == null) {
				return "/author/register";
			} else {
				return "redirect:/author/login";
			}

		} catch (Exception e) {
			e
				.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/logout")
	public String logoutAuthor() {
		return "/author/logout";
	}
}
