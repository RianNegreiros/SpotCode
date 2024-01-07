package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Song;
import com.github.riannegreiros.springcloud.springcloud.repositories.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SongService {
    private static final Logger logger = LoggerFactory.getLogger(SongService.class);

    @Autowired
    private SongRepository repository;

    @Transactional
    public Song save(Song song) {
        return repository.save(song);
    }
}
