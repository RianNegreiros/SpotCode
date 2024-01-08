package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.*;
import com.github.riannegreiros.springcloud.springcloud.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User save(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        return repository.save(user);
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new EntityNotFoundException("User not found by id:" + id));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByEmail(s);
        if (user == null) {
            logger.error("User not found: " + s);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + s);
        return user;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }

        return null;
    }

    public List<Album> getFavoriteAlbums(User user) {
        List<Favorite> favoriteAlbums = favoriteRepository.findByUserAndAlbumIsNotNull(user);
        return extractAlbumsFromFavorites(favoriteAlbums);
    }

    public List<Song> getFavoriteSongs(User user) {
        List<Favorite> favoriteSongs = favoriteRepository.findByUserAndSongIsNotNull(user);
        return extractSongsFromFavorites(favoriteSongs);
    }

    public List<Artist> getFavoriteArtists(User user) {
        List<Favorite> favoriteArtists = favoriteRepository.findByUserAndArtistIsNotNull(user);
        return extractArtistsFromFavorites(favoriteArtists);
    }

    public void addToFavorites(User user, Long id, String type) {
        Favorite favorite = new Favorite(user, null, null, null);

        switch (type) {
            case "Album":
                favorite.setAlbum(albumRepository.findById(id).orElse(null));
                break;
            case "Song":
                favorite.setSong(songRepository.findById(id).orElse(null));
                break;
            case "Artist":
                favorite.setArtist(artistRepository.findById(id).orElse(null));
                break;
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }

        favoriteRepository.save(favorite);
    }

    public void removeFromFavorites(User user, Long id, String type) {
        Favorite favorite = favoriteRepository.findByUserAndFavoritableIdAndFavoritableType(user, id, type);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        }
    }

    private List<Album> extractAlbumsFromFavorites(List<Favorite> favoriteAlbums) {
        return favoriteAlbums.stream()
                .filter(favorite -> favorite.getAlbum() != null)
                .map(Favorite::getAlbum)
                .toList();
    }

    private List<Song> extractSongsFromFavorites(List<Favorite> favoriteSongs) {
        return favoriteSongs.stream()
                .filter(favorite -> favorite.getSong() != null)
                .map(Favorite::getSong)
                .toList();
    }

    private List<Artist> extractArtistsFromFavorites(List<Favorite> favoriteArtists) {
        return favoriteArtists.stream()
                .filter(favorite -> favorite.getArtist() != null)
                .map(Favorite::getArtist)
                .toList();
    }
}
