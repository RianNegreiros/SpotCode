package com.github.riannegreiros.springcloud.springcloud.controllers;

import com.github.riannegreiros.springcloud.springcloud.dto.FavoriteRequest;
import com.github.riannegreiros.springcloud.springcloud.dto.FavoriteResponse;
import com.github.riannegreiros.springcloud.springcloud.entities.*;
import com.github.riannegreiros.springcloud.springcloud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoriteController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<FavoriteResponse> getFavorites() {
        User currentUser = userService.getCurrentUser();
        Set<Favorite> favorites = currentUser.getFavorites();
        List<Album> favoriteAlbums = userService.getFavoriteAlbums(currentUser);
        List<Song> favoriteSongs = userService.getFavoriteSongs(currentUser);
        List<Artist> favoriteArtists = userService.getFavoriteArtists(currentUser);

        FavoriteResponse response = new FavoriteResponse(favoriteAlbums, favoriteSongs, favoriteArtists);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addToFavorites(@RequestBody FavoriteRequest favoriteRequest) {
        User currentUser = userService.getCurrentUser();
        userService.addToFavorites(currentUser, favoriteRequest.getId(), favoriteRequest.getType());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFromFavorites(@RequestParam Long id, @RequestParam String type) {
        User currentUser = userService.getCurrentUser();
        userService.removeFromFavorites(currentUser, id, type);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}