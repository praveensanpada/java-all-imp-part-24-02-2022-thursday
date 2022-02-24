package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	
	List<User> getUsers();
	
	void saveUser(User user);
	
	User getUserById(long id);
	
	void deleteUser(long id);

}
