package com.github.riannegreiros.springcloud.springcloud.dto;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;

import java.util.List;

public class DashboardData {
    private List<Album> recentAlbums;
    private List<Album> recommendAlbums;

    public DashboardData(List<Album> recentAlbums, List<Album> recommendAlbums) {
        this.recentAlbums = recentAlbums;
        this.recommendAlbums = recommendAlbums;
    }

    public List<Album> getRecentAlbums() {
        return recentAlbums;
    }

    public void setRecentAlbums(List<Album> recentAlbums) {
        this.recentAlbums = recentAlbums;
    }

    public List<Album> getRecommendAlbums() {
        return recommendAlbums;
    }

    public void setRecommendAlbums(List<Album> recommendAlbums) {
        this.recommendAlbums = recommendAlbums;
    }
}
