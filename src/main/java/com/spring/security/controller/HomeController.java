package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/public/home")
	public String getHome() {
		return "This is Our Home Page";
	}
	// Login page 
	@GetMapping("/public/login")
	public String getlogin() {
		return "This is our Login Page";
	}
	// Register Page
	@GetMapping("/public/register")
	public String getRegister() {
		return "This is Our Register Page";
	}

}
