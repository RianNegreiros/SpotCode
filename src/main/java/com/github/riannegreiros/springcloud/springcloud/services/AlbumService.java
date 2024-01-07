package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AlbumService {
    private static final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    private AlbumRepository repository;

    @Transactional
    public Album save(Album album) {
        return repository.save(album);
    }
}
