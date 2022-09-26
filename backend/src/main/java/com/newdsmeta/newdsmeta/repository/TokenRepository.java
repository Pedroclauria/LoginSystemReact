package com.newdsmeta.newdsmeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.newdsmeta.newdsmeta.entities.User;

public interface TokenRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT obj FROM User obj WHERE obj.email LIKE LOWER(CONCAT('%',:email,'%'))")
	User findToken(String email);
	
}


