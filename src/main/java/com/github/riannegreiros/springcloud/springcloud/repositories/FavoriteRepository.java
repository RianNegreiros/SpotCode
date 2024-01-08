package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Favorite;
import com.github.riannegreiros.springcloud.springcloud.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Album> findFavoriteAlbumsByUserId(Long userId);

    List<Song> findFavoriteSongsByUserId(Long userId);

    List<Artist> findFavoriteArtistsByUserId(Long userId);
}
