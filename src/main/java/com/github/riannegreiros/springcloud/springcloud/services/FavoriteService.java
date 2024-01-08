package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.*;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.ArtistRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.FavoriteRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Favoritable> getFavorites(User user, String favoritableType) {
        List<Favorite> favorites = favoriteRepository.findByUserAndFavoritableType(user, favoritableType);
        return favorites.stream().map(Favorite::getFavoritable).collect(Collectors.toList());
    }

    @Transactional
    public void addFavorite(User user, Long favoritableId, String favoritableType) {
        Optional<Favorite> existingFavorite = favoriteRepository.findByUserAndFavoritable(
                user,
                createFavoritableEntity(favoritableId, favoritableType)
        );

        if (existingFavorite.isPresent()) {
            throw new IllegalStateException("Favorite already exists");
        }

        Favorite newFavorite = new Favorite();
        newFavorite.setUser(user);
        newFavorite.setFavoritable(createFavoritableEntity(favoritableId, favoritableType));

        favoriteRepository.save(newFavorite);
    }

    @Transactional
    public void removeFavorite(User user, Long favoritableId, String favoritableType) {
        favoriteRepository.findByUserAndFavoritable(
                user,
                createFavoritableEntity(favoritableId, favoritableType)
        ).ifPresent(favoriteToRemove -> favoriteRepository.delete(favoriteToRemove));
    }

    private Favoritable createFavoritableEntity(Long favoritableId, String favoritableType) {
        return switch (favoritableType) {
            case "Album" -> (Favoritable) albumRepository.findById(favoritableId).orElseThrow(() -> new EntityNotFoundException("Album not found"));
            case "Song" -> (Favoritable) songRepository.findById(favoritableId).orElseThrow(() -> new EntityNotFoundException("Song not found"));
            case "Artist" -> (Favoritable) artistRepository.findById(favoritableId).orElseThrow(() -> new EntityNotFoundException("Artist not found"));
            default -> throw new IllegalArgumentException("Invalid favoritable type");
        };
    }
}