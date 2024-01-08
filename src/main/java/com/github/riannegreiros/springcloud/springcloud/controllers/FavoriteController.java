package com.github.riannegreiros.springcloud.springcloud.controllers;

import com.github.riannegreiros.springcloud.springcloud.entities.Favoritable;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import com.github.riannegreiros.springcloud.springcloud.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<List<Favoritable>> getFavorites(@AuthenticationPrincipal User user,
                                                          @RequestParam String favoritableType) {
        List<Favoritable> favorites = favoriteService.getFavorites(user, favoritableType);
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addFavorite(@AuthenticationPrincipal User user,
                                            @RequestParam Long favoritableId,
                                            @RequestParam String favoritableType) {
        favoriteService.addFavorite(user, favoritableId, favoritableType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFavorite(@AuthenticationPrincipal User user,
                                               @RequestParam Long favoritableId,
                                               @RequestParam String favoritableType) {
        favoriteService.removeFavorite(user, favoritableId, favoritableType);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}