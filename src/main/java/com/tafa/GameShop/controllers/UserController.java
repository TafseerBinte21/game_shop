package com.tafa.GameShop.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tafa.GameShop.models.Game;
import com.tafa.GameShop.models.User;
import com.tafa.GameShop.services.GameService;
import com.tafa.GameShop.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/library")
    public String gamelist(Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        List<Long> gamelist = user.getGamelist();
        List<Game> games = new ArrayList<>();
        for (Long aGame : gamelist) {
            games.add(gameService.findGameById(aGame));
        }
        model.addAttribute("games", games);
        return "gamelist";
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        List<Long> wishlist = user.getWishlist();
        List<Game> games = new ArrayList<>();
        for (Long aGame : wishlist) {
            games.add(gameService.findGameById(aGame));
        }
        model.addAttribute("games", games);
        return "wishlist";
    }

    @RequestMapping("/wishlist/add/{id}")
    public String addGameWishlist(@PathVariable String id, Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        userService.addGameByIdInWishlist(user, Long.valueOf(id));
        return "redirect:/wishlist";
    }

    @RequestMapping("/wishlist/delete/{id}")
    public String deleteGameWishlist(@PathVariable String id, Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        userService.deleteGameByIdFromWishlist(user, Long.valueOf(id));
        return "redirect:/wishlist";
    }

    @GetMapping("/cart")
    public String cart(Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        List<Long> cart = user.getCart();
        List<Game> games = new ArrayList<>();
        for (Long aGame : cart) {
            games.add(gameService.findGameById(aGame));
        }
        model.addAttribute("games", games);
        return "cart";
    }

    @RequestMapping("/cart/add/{id}")
    public String addGameCart(@PathVariable String id, Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        userService.addGameByIdInCart(user, Long.valueOf(id));
        return "redirect:/cart";
    }

    @RequestMapping("/cart/delete/{id}")
    public String deleteGameCart(@PathVariable String id, Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        userService.deleteGameByIdFromCart(user, Long.valueOf(id));
        return "redirect:/cart";
    }

}
