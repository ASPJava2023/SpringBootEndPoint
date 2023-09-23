package com.exampleDay4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Maincontroller {
	@GetMapping("/ message")
	public String display() {
		return "Hello from Ankit This is main Controller ";
	}

}
