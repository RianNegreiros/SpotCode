package com.github.riannegreiros.springcloud.springcloud.controllers;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/{id}")
    public Album getById(@PathVariable Long id) {
        return albumService.findById(id);
    }
}