package com.tafa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.tafa.GameShop.controllers.dto.GameDto;
import com.tafa.GameShop.models.Game;
import com.tafa.GameShop.repository.GameRepository;
import com.tafa.GameShop.services.GameService;


@SpringBootTest
class GameRepositoryTest {
	
	@Autowired
	private GameRepository gamerepository;
	
	@Autowired
	private GameService gameservice;
	
	@Test
	void isGameExitsById() {
		
		GameDto game = new GameDto((long) 1,"Dota 2 is a multiplayer online battle arena video game developed and published by Valve. The game is a sequel to Defense of the Ancients, which was a community-created mod for Blizzard Entertainment's Warcraft III: Reign of Chaos.", "MOBA",	"/img/dota2.jpg",	"Dota 2",	"0");
		 gameservice.save(game);
		 Boolean actualResult =  gameservice.isGameExitsById(1L);
		 assertThat(actualResult).isTrue();
	}
	
	 @AfterEach
	    void tearDown() {
	        System.out.println("tearing down");
	        gamerepository.deleteAll();
	    }

	    @BeforeEach
	    void setUp() {
	        System.out.println("setting up");
	    }

}
