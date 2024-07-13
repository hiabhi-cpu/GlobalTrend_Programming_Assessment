package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MainController {
	
	@Autowired
	MainService service;
	
	@GetMapping("/home")
	public String home() {
		return service.getHome();
	}
	
	@GetMapping("/contact")
	public String contact() {
		return service.getContact();
	}
	
}
