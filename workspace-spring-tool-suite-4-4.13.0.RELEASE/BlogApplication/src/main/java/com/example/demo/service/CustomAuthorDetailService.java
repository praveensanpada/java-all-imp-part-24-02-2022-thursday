package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.model.CustomAuthorDetail;
import com.example.demo.repository.AuthorRepository;


@Service
public class CustomAuthorDetailService implements UserDetailsService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Author author = this.authorRepository
			.getAuthorByEmail(username);
		if (author == null) {
			throw new UsernameNotFoundException("No user");
		} else {
			return new CustomAuthorDetail(author);
		}
	}

}
