package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Favoritable;
import com.github.riannegreiros.springcloud.springcloud.entities.Favorite;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserAndFavoritableType(User user, String favoritableType);
    Optional<Favorite> findByUserAndFavoritable(User user, Favoritable favoritable);
}
