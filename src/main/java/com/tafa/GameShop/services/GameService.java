package com.tafa.GameShop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tafa.GameShop.controllers.dto.GameDto;
import com.tafa.GameShop.models.Game;

@Service
public interface GameService {
	
	
	Game save(GameDto gameDto);

	Game findgameByname(String name);

	Game findGameById(Long Id) throws Exception;

	List<Game> findgameBykeyword(String keyword);

	List<Game> findAll();
	
//	Boolean isGameExitsById(Long id);

}
