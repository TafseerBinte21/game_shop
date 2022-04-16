package com.tafa.GameShop.controllers;

import java.util.List;

import com.tafa.GameShop.controllers.dto.GameDto;
import com.tafa.GameShop.models.Game;
import com.tafa.GameShop.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public String search() {
        return "search";
    }

    @PostMapping
    public String searchResult(@RequestParam(value = "game") String game, GameDto gameDto, Model model) {
        if (game != "") {
            List<Game> games = gameService.findgameBykeyword(game);
            System.out.println(games);
            model.addAttribute("games", games);
        }
        return "search";
    }

}
