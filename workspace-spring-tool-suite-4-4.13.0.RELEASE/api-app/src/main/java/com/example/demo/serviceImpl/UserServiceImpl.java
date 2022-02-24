package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositpory.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.userRepo.save(user);
		
	}

	@Override
	public User getUserById(long id) {
		java.util.Optional<User>  optional = userRepo.findById(id);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException("User Not Found");
		}
		return user;
	}

	@Override
	public void deleteUser(long id) {
		this.userRepo.deleteById(id);
		
	}

}
