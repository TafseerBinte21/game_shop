package com.tafa.GameShop.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tafa.GameShop.models.Role;
import com.tafa.GameShop.models.User;
import com.tafa.GameShop.repository.UserRepository;
import com.tafa.GameShop.controllers.dto.*;

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware, InitializingBean {

	private UserRepository userRepository;

	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegDto registrationDto) {
		User user = new User(registrationDto.getName(),
				registrationDto.getPhone(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getAddress(),
				Arrays.asList(new Role("ROLE_USER")), registrationDto.getGamelist(), registrationDto.getWishlist());

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByEmail(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return user;
	}

	@Override
	public void deleteGameById(User user, Long id) {
		List<Long> gamelist = user.getGamelist();
		gamelist.remove(id);
		user.setGamelist(gamelist);

		userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteGameByIdFromWishlist(User user, Long id) {
		List<Long> gamelist = user.getWishlist();
		gamelist.remove(id);
		user.setWishlist(gamelist);

		userRepository.saveAndFlush(user);
	}

	@Override
	public void addGameByIdInWishlist(User user, Long id) {
		List<Long> gamelist = user.getWishlist();
		System.out.println("\n" + "\n");

		if (!gamelist.contains(id)) {
			gamelist.add(id);
			user.setWishlist(gamelist);
			userRepository.saveAndFlush(user);
		}
	}

	@Override
	public void deleteGameByIdFromCart(User user, Long id) {
		List<Long> gamelist = user.getCart();
		gamelist.remove(id);
		user.setCart(gamelist);

		userRepository.saveAndFlush(user);
	}

	@Override
	public void addGameByIdInCart(User user, Long id) {
		List<Long> gamelist = user.getCart();
		System.out.println("\n" + "\n");

		if (!gamelist.contains(id)) {
			gamelist.add(id);
			user.setCart(gamelist);
			userRepository.saveAndFlush(user);
		}

	}
	
//	 @Override
//		public Boolean  findbyEmail(String Email) {
//			 return userRepository.findbyEmail(Email);
//		 }
	 
	

}
