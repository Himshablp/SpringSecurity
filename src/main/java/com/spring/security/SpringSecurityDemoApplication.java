package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.security.models.User;
import com.spring.security.repo.UserRepository;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setEmail("him@gmail.com");
		user1.setUsername("himanshu");
		user1.setPassword(this.bCryptPasswordEncoder.encode("sharma"));
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
		
		
		User user2 = new User();
		user2.setEmail("mayank@gmail.com");
		user2.setUsername("mayank");
		user2.setPassword(this.bCryptPasswordEncoder.encode("dubey"));
		user2.setRole("ROLE_NORMAL");
		this.userRepository.save(user2);
		
	}

}
