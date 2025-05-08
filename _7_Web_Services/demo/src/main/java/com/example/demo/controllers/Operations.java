package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Operations {
	@GetMapping("/")
	public String home() {
		return "<h1> HOME PAGE </h1>";
	}
	
	@GetMapping("/add")
	public String add(@RequestParam double a, @RequestParam double b) {
		return "<h1> Addition is : " + (a + b) + " </h1>";
	}
	
}
