package com.newdsmeta.newdsmeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.newdsmeta.newdsmeta.entities.User;

public interface LoginRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT obj FROM User obj WHERE obj.email = :email AND  obj.password = :password")
	User findEmailPass(String email, String password);
	
}


