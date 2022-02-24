package com.springjwt.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello I am Praveen";
	}
	
	@PostMapping("/auth")
	public String auth() {
		return "Hello I am Praveen";
	}
}
