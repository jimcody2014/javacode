package com.example.adp1.controller;

	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("/rest")
	public class HelloController {

	    // Respond with hello
	    @GetMapping("/hello")
	    public String getGreeting() {
	        return "Hello Spring World!";
	    }
	}

