package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.*;
import com.github.riannegreiros.springcloud.springcloud.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Album> getFavoriteAlbums(Long userId) {
        return favoriteRepository.findFavoriteAlbumsByUserId(userId);
    }

    public List<Song> getFavoriteSongs(Long userId) {
        return favoriteRepository.findFavoriteSongsByUserId(userId);
    }

    public List<Artist> getFavoriteArtists(Long userId) {
        return favoriteRepository.findFavoriteArtistsByUserId(userId);
    }

    public void addFavorite(Long userId, Long favoritableId, String favoritableType) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Album not found"));
        Favorite favorite = new Favorite();
        switch (favoritableType) {
            case "Album":
                Album album = albumRepository.findById(favoritableId).orElseThrow(() -> new EntityNotFoundException("Album not found"));
                favorite.setUser(user);
                favorite.setAlbum(album);
                user.getFavorites().add(favorite);
                break;
            case "Song":
                Song song = songRepository.findById(favoritableId).orElseThrow(() -> new EntityNotFoundException("SOng not found"));
                favorite.setUser(user);
                favorite.setSong(song);
                user.getFavorites().add(favorite);
                break;
            case "Artist":
                Artist artist = artistRepository.findById(favoritableId).orElseThrow(() -> new EntityNotFoundException("Artist not found"));
                favorite.setUser(user);
                favorite.setArtist(artist);
                user.getFavorites().add(favorite);
                break;
            default:
                break;
        }
    }

    public void removeFavorite(Long userId, Long favoritableId, String favoritableType) {
        // Similar logic to addFavorite, but remove the corresponding favorite
    }
}