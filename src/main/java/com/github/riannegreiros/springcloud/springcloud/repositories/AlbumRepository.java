package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByTitle(String title);
    
    List<Album> findByTitleContainingIgnoreCase(String title);

    @Query(value = "SELECT * FROM tb_album ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Album> findRandomAlbums(int limit);

    @Query(value = "SELECT DISTINCT a.* FROM tb_album a " +
            "INNER JOIN tb_category c ON a.category_id = c.id " +
            "INNER JOIN tb_song s ON a.id = s.album_id " +
            "WHERE c IN :categories " +
            "ORDER BY SUM(s.played_count) DESC " +
            "LIMIT :limit", nativeQuery = true)
    List<Album> findTopRecommendationsByCategories(
            @Param("categories") List<Category> categories,
            @Param("limit") int limit
    );
}