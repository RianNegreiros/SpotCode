package com.github.riannegreiros.springcloud.springcloud.controllers;

import com.github.riannegreiros.springcloud.springcloud.dto.DashboardData;
import com.github.riannegreiros.springcloud.springcloud.repositories.RecentlyHeardRepository;
import com.github.riannegreiros.springcloud.springcloud.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    private RecentlyHeardRepository recentlyHeardRepository;

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/index")
    public DashboardData index() {
        return dashboardService.loadDashboardData();
    }
}