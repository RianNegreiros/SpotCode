package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.repositories.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArtistService {
    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    @Autowired
    private ArtistRepository repository;

    @Transactional
    public Artist save(String name) {
        Artist artist = new Artist();
        artist.setName(name);
        return repository.save(artist);
    }

    public Artist findByName(String name) {
        return repository.findByName(name);
    }
}
