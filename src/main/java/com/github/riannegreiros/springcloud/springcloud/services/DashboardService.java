package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.dto.DashboardData;
import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.RecentlyHeardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private RecentlyHeardRepository recentlyHeardRepository;

    @Autowired
    AlbumRepository albumRepository;

    public DashboardData loadDashboardData() {
        List<Album> recentAlbums = loadRecentHeard();
        List<Album> recommendAlbums = loadRecommendations(recentAlbums);

        return new DashboardData(recentAlbums, recommendAlbums);
    }

    private List<Album> loadRecentHeard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = null;

        if (authentication != null && authentication.getPrincipal() instanceof User userDetails) {
            userId = userDetails.getId();
        }

        List<RecentlyHeard> recentlyHeardList = recentlyHeardRepository.findByUserId(userId);

        return recentlyHeardList.stream()
                .map(RecentlyHeard::getAlbum)
                .toList();
    }

    private List<Album> loadRecommendations(List<Album> recentAlbums) {
        if (recentAlbums.isEmpty()) {
            return albumRepository.findRandomAlbums(12);
        }

        List<Category> heardCategories = extractHeardCategories(recentAlbums);

        if (!heardCategories.isEmpty()) {
            return albumRepository.findTopRecommendationsByCategories(heardCategories, 12);
        } else {
            return albumRepository.findRandomAlbums(12);
        }
    }

    private List<Category> extractHeardCategories(List<Album> recentAlbums) {
        return recentAlbums.stream()
                .map(Album::getCategory)
                .distinct()
                .toList();
    }

}