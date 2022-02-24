package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		try {
			
			User user = userRepository.findByEmail(email);
			
			if(user == null) {
				throw new UsernameNotFoundException("No User");
			}else {
				return new CustomUserDetails(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
