package com.iits.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iits.main.entity.Product;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ProductController {

	List<Product> list=new ArrayList<>();
	
	@GetMapping("/")
	public String greetingMessage() {
		 
		return "Hello" ;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}
	
	@PostMapping("/store")
	public String storeData(@RequestBody Product product) {
		list.add(product);
		System.out.println(list);
		return "successfully store in list";
	}
	 
}
