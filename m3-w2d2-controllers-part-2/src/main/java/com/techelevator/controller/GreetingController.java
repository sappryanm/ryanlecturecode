package com.techelevator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Greeting;

@RestController
@RequestMapping("/api")
public class GreetingController {
	
	@RequestMapping("/greeting")
	public Greeting handleGreeting(
			@RequestParam(value="name", defaultValue="World") String recipient) {
		return new Greeting(recipient);
	}
}
