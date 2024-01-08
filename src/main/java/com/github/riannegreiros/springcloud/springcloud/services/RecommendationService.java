package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> loadRecommendations(List<Album> recentAlbums) {
        Set<Category> heardCategories = recentAlbums.stream()
                .map(Album::getCategory)
                .collect(Collectors.toSet());

        List<Album> recommendAlbums;

        if (!heardCategories.isEmpty()) {
            recommendAlbums = albumRepository.findDistinctByCategoryInOrderSongsPlayedCount(heardCategories);
        } else {
            recommendAlbums = albumRepository.findAll().stream()
                    .distinct()
                    .limit(12)
                    .collect(Collectors.toList());
        }

        return recommendAlbums;
    }
}