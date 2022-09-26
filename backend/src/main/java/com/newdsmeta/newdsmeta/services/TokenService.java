package com.newdsmeta.newdsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newdsmeta.newdsmeta.entities.User;
import com.newdsmeta.newdsmeta.repository.TokenRepository;

@Service
public class TokenService {
	
	
	
	@Autowired
	private TokenRepository repository;	
	
	
	public User searchUser(String email) {

		return repository.findToken(email);
	}
	
}
