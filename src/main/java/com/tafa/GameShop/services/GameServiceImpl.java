package com.tafa.GameShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.tafa.GameShop.controllers.dto.GameDto;
import com.tafa.GameShop.exception.ResourceNotFoundException;
import com.tafa.GameShop.models.Game;
import com.tafa.GameShop.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gRepository;

	@Override
	public Game save(GameDto gameDto) {
		Game g = new Game(gameDto.getId(), gameDto.getName(), gameDto.getGenre(), gameDto.getDescription(),
				gameDto.getPrice(), gameDto.getImage());

		return gRepository.save(g);
	}

	@Override
	public Game findgameByname(String name) {

		return gRepository.findByname(name);
	}

	@Override
	public List<Game> findgameBykeyword(String keyword) {
		return gRepository.findByKeyword(keyword);
	}

	@Override
	public Game findGameById(Long Id) {
		Game game = gRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Game with id:" + Id + " not found"));
		return game;
	}

	@Override
	public List<Game> findAll() {
		List<Game> games = gRepository.findAll();
		return games;
	}
	
//	 @Override
//	public Boolean isGameExitsById(Long id) {
//		 return gRepository.isGameExitsById(id);
//	 }

}
