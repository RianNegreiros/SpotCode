package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private RecentlyHeardService recentlyHeardService;

    @Autowired
    private AlbumService albumService;

    public List<Album> getRecentAlbums(Long userId) {
        return recentlyHeardService.getRecentHeards(userId);
    }

    public List<Album> getRecommendedAlbums(List<Album> recentAlbums) {
        List<String> heardCategories = albumService.getHeardCategories(recentAlbums);

        if (!heardCategories.isEmpty()) {
            return albumService.getRecommendedAlbums(heardCategories);
        } else {
            return albumService.getAllAlbumsSample(12);
        }
    }
}