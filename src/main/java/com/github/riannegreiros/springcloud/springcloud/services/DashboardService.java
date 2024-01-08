package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.dto.DashboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private RecentlyHeardService recentlyHeardService;

    @Autowired
    private RecommendationService recommendationService;

    public DashboardResponse getDashboardData() {
        DashboardResponse response = new DashboardResponse();

        response.setRecentAlbums(recentlyHeardService.loadRecentHeard());
        response.setRecommendAlbums(recommendationService.loadRecommendations(response.getRecentAlbums()));

        return response;
    }
}