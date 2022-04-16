package com.tafa.GameShop.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tafa.GameShop.models.Game;
import com.tafa.GameShop.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Game> games = gameService.findAll();
        model.addAttribute("games", games);
        return "shop";
    }

    @RequestMapping("/game/{id}")
    public String game(@PathVariable String id, Model model) {
        Long gameId = Long.valueOf(id);
        try {
            Game game = gameService.findGameById(gameId);
            model.addAttribute("game", game);
        } catch (Exception e) {
            System.out.println("Game not found by id.");
            e.printStackTrace();
        }
        return "game";
    }

}
