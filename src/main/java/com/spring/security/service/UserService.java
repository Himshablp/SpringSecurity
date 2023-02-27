package com.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.models.User;
import com.spring.security.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	List<User> list = new ArrayList<>();
	 
	public UserService() {
		list.add(new User("abc","abc","abc@gmail.com"));
		list.add(new User("xyz","xyz","xyz@gmail.com"));
		
	}
	
	//get All User
	public List<User> getAllUsers(){
		return list;
	}
	
	//get Single User
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	// Add one User
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}

}
