package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@ModelAttribute("user") User user, HttpSession session) {
		System.out.println(user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		session.setAttribute("message", "User Created Sucessfully!!!!!!");
		return "redirect:/register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	@PostMapping("/doLogin")
//	public String doLogin(@ModelAttribute("user") User user, HttpSession session) {
//		System.out.println(user);
//		userRepository.save(user);
//		session.setAttribute("message", "User Created Sucessfully!!!!!!");
//		return "redirect:/register";
//	}
	
}
