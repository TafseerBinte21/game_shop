package com.tafa.GameShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "main";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
