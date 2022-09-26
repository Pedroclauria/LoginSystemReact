package com.newdsmeta.newdsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newdsmeta.newdsmeta.entities.User;
import com.newdsmeta.newdsmeta.services.LoginService;

@RestController
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	
	@GetMapping
	public User searchUser(
			@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String password
			){
			User result = service.searchUser(email, password);
			//User result = repository.findEmailPass(email, password);
		return result;
	}
	
}
