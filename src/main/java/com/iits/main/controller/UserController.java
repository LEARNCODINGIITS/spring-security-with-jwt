package com.iits.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iits.main.entity.Users;
import com.iits.main.service.UserServiceRegister;

@RestController
public class UserController {

      
	@Autowired
	UserServiceRegister userServiceRegister;
	
	 Logger log=LoggerFactory.getLogger(UserController.class);
	
	
	@PostMapping("/save")
	public String registerUser(@RequestBody Users user) {
		return this.userServiceRegister.registerUser(user);
		
		
	}
	
	/*
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Users user) {
	    log.info("-ENTER INTO LOGIN METHOD");
	    String res = this.userServiceRegister.verify(user);
	    if ("SUCCESS".equals(res)) {
	        return ResponseEntity.ok("Login Successful");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	    }
	}*/
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
	    log.info("-ENTER INTO LOGIN METHOD");
	    return this.userServiceRegister.verify(user);
	}
}
