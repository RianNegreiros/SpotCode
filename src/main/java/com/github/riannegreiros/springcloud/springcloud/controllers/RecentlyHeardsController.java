package com.github.riannegreiros.springcloud.springcloud.controllers;


import com.github.riannegreiros.springcloud.springcloud.services.RecentlyHeardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recently-heards")
public class RecentlyHeardsController {

    @Autowired
    private RecentlyHeardService service;

    @PostMapping("/create")
    public ResponseEntity<Void> createRecentlyHeard(
                                                    @RequestParam Long albumId) {
        service.save(albumId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
