package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.models.User;
import com.spring.security.service.UserService;

@RestController
public class UserController {
	@Autowired 
	private UserService userService;
	
	// All User
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userService.getAllUsers();
	}
	
	// Return Single User
	@GetMapping("/users/{username}")
//	@PreAuthorize("hasRole('ADMIN')")
	public User getUser(@PathVariable String username) {
		return this.userService.getUser(username);
	}
	
	// Add User
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
}
