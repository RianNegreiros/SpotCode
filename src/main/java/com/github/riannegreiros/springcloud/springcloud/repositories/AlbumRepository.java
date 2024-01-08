package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByTitle(String title);
    List<Album> findDistinctByCategoryInOrderSongsPlayedCount(Set<Category> categories);
}