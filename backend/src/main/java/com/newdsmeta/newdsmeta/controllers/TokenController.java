package com.newdsmeta.newdsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newdsmeta.newdsmeta.entities.User;
import com.newdsmeta.newdsmeta.services.TokenService;

@RestController
@RequestMapping(value = "/validate", method = RequestMethod.POST)
public class TokenController {
	
	@Autowired
	private TokenService service;
	
	
	@GetMapping
	public User searchUser(
			@RequestParam(defaultValue = "") String email
			){
			User result = service.searchUser(email);
			//User result = repository.findEmailPass(email, password);
		return result;
	}
	
}
