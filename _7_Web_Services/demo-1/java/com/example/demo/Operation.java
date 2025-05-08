package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Operation {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/add") 
	public String add(@RequestParam double a , @RequestParam double b) {
		return "<h1> Addition is : " + (a + b) + "  ert</h1>";
	}
}
