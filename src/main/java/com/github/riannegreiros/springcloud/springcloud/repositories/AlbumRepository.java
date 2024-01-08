package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByTitle(String title);

    @Query("SELECT DISTINCT a FROM Album a JOIN a.songs s WHERE a.category IN :categories ORDER BY SUM(s.playedCount) DESC")
    List<Album> findDistinctByCategoryInOrderByPlayedCount(List<String> categories);

    List<Album> findByTitleContainingIgnoreCase(String query);
}