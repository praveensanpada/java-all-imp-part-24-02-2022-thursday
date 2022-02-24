package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
	
	@GetMapping("/users")
	public String getUsers() {
		System.out.println("All-Users");
		return "List of Users";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable Long id) {
		System.out.print("User-By-Id-"+id);
		return "User "+id;
	}
	
	@DeleteMapping("/user")
	public String deleteUser(@RequestParam Long id) {
		System.out.print("Delete-By-Id-"+id);
		return "Deleted "+id;
	}
	
	@PostMapping("/user")
	public String saveUser(@RequestBody User user) {
		System.out.print("Save User"+user);
		return "List "+user;
	}

}
