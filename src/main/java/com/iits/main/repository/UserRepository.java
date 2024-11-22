package com.iits.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iits.main.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	
	Users findByUsername(String username);
	
}
