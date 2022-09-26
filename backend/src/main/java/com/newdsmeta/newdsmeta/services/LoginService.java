package com.newdsmeta.newdsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.newdsmeta.newdsmeta.entities.User;
import com.newdsmeta.newdsmeta.repository.LoginRepository;

@Service
public class LoginService {
	
	
	
	@Autowired
	private LoginRepository repository;
	
	
	public User searchUser(String email, String password) {

		return repository.findEmailPass(email, password);
	}
	
}
