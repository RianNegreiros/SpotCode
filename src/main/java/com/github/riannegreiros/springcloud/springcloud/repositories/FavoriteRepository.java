package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Favorite;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserAndAlbumIsNotNull(User user);
    List<Favorite> findByUserAndSongIsNotNull(User user);
    List<Favorite> findByUserAndArtistIsNotNull(User user);
    Favorite findByUserAndFavoritableIdAndFavoritableType(User user, Long id, String type);
}