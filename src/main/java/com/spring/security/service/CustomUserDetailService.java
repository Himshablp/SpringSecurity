package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.models.CustomUserDetails;
import com.spring.security.models.User;
import com.spring.security.repo.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findById(username).get();
		
		if(user==null) {
			throw new UsernameNotFoundException("NO USER");
		}
		return new CustomUserDetails(user);
	}

}
