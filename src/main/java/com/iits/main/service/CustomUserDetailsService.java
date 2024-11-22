package com.iits.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iits.main.entity.Users;
import com.iits.main.repository.UserPrinciple;
import com.iits.main.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		Users user=this.userRepository.findByUsername(username);
		System.out.println("user:"+user);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		UserDetails userDetails=new UserPrinciple(user);
		
		return userDetails;
	}

}
