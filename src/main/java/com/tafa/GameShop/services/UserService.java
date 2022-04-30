package com.tafa.GameShop.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tafa.GameShop.controllers.dto.UserRegDto;
import com.tafa.GameShop.models.User;

public interface UserService extends UserDetailsService {
	User save(UserRegDto registrationDto);

	User getUserByEmail(String email);

	void deleteGameById(User user, Long id);

	void deleteGameByIdFromWishlist(User user, Long valueOf);

	void addGameByIdInWishlist(User user, Long valueOf);

	void deleteGameByIdFromCart(User user, Long valueOf);

	void addGameByIdInCart(User user, Long valueOf);

	

	
//	Boolean findbyEmail(String Email);

	
	
	

}
