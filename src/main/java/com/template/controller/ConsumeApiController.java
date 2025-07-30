package com.template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.template.model.User;
import com.template.service.RestTemplateProvider;

@Controller
@RequestMapping("/Api")
public class ConsumeApiController {

	@GetMapping
	public String get(Model model) {
		RestTemplateProvider restTemplate = new RestTemplateProvider();
		model.addAttribute("user",restTemplate.getUserData());
		model.addAttribute("model",new User());
		return "getData";
	}
	
	@PostMapping
	public String post(@ModelAttribute("model") User user, Model model) {
		RestTemplateProvider restTemplate = new RestTemplateProvider();
		ResponseEntity<User> response = restTemplate.post(user);
		model.addAttribute("user", response.getBody());
		model.addAttribute("headers", response.getHeaders() + " " + response.getStatusCode());
		return "getData";
	}
}
