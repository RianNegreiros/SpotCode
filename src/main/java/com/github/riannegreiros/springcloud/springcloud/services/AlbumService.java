package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class AlbumService {
    private static final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    private AlbumRepository repository;

    @Transactional
    public Album save(String title, LocalDate date, Category category, Artist artist) {
        Album album = new Album();
        album.setTitle(title);
        album.setDate(date);
        album.setCategory(category);
        album.setArtist(artist);
        return repository.save(album);
    }

    public Album findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
