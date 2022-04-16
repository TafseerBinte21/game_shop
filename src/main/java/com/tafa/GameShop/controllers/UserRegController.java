package com.tafa.GameShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tafa.GameShop.controllers.dto.UserRegDto;
import com.tafa.GameShop.services.UserService;

@Controller
@RequestMapping("/register")
public class UserRegController {

	private UserService userService;

	public UserRegController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegDto userRegistrationDto() {
		return new UserRegDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "register";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegDto registrationDto) {
		// System.out.println(registrationDto+"tafa");
		userService.save(registrationDto);
		return "redirect:/register?success";
	}

}