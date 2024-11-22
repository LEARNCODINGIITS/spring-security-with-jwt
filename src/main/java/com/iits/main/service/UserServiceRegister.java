package com.iits.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iits.main.controller.UserController;
import com.iits.main.entity.Users;
import com.iits.main.repository.UserRepository;

@Service
public class UserServiceRegister {

	@Autowired
	JWTService jwtService;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	Logger log = LoggerFactory.getLogger(UserController.class);

	BCryptPasswordEncoder b = new BCryptPasswordEncoder(12);

	public String registerUser(Users users) {
		users.setPassword(b.encode(users.getPassword()));
		Users u = userRepository.save(users);
		if (u != null) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}

	public String verify(Users user) {
		try {
			log.info("--inside verify method: " + user);
			Authentication auth = this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			if (auth.isAuthenticated()) {
				return this.jwtService.generateToken(user.getUsername());
			}
		} catch (AuthenticationException e) {
			log.error("Authentication failed for user: {}", user.getUsername(), e);
			return "FAIL";
		}
		return "FAIL";
	}

}
