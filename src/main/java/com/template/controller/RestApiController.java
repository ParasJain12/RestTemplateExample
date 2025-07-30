package com.template.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.model.User;

@RestController
@RequestMapping(path = "/RestApi",produces="application/json")
@CrossOrigin(origins = "*")
public class RestApiController {
	
	@GetMapping("/getData")
	public User get() {
		User user = new User();
		user.setId("1");
		user.setUserName("ParasJain12");
		user.setData("Data sent by Rest API");
		return user;
	}
	
	@PostMapping
	public ResponseEntity<User> post(@RequestBody User user){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(user,headers,HttpStatus.CREATED);
		
	}
}
