package com.template.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.template.model.User;

public class RestTemplateProvider {
	
	private final RestTemplate rest = new RestTemplate();
	
	public User getUserData() {
		try {
			return rest.getForObject("http://localhost:8080/RestApi/getData", User.class);
		}catch(RestClientException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResponseEntity<User> post(User user){
		try {
			return rest.postForEntity("http://localhost:8080/RestApi", user, User.class);
		}catch(RestClientException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
