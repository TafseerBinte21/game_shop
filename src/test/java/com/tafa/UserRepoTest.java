package com.tafa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.tafa.GameShop.controllers.dto.UserRegDto;
import com.tafa.GameShop.services.UserService;



@SpringBootTest
class UserRepoTest {
	
	
	
	@Autowired
	private UserService userService;
	
	@Test
	void findByEmail() {
		
		UserRegDto user= new UserRegDto("2",	0, "jatrabari",	"mehedi@gmail.com",		"mehedi",	"$2a$10$L7ZcuTQeGgyf6AssEOF6n.TvS1ad42adof6XgCx04B2LXq2QOkhi.",	"1941299169");
		 userService.save(user);
		 
	}
	
	
	    @BeforeEach
	    void setUp() {
	        System.out.println("setting up");
	    }

}
