package com.example.demo.repositpory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
