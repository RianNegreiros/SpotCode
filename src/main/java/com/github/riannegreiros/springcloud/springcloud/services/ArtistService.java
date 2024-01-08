package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Image;
import com.github.riannegreiros.springcloud.springcloud.repositories.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class ArtistService {
    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    @Autowired
    private ArtistRepository repository;

    @Transactional
    public Artist save(String name, MultipartFile imageFile) throws IOException {
        Artist artist = new Artist();
        artist.setName(name);

        Image imageEntity = new Image();
        imageEntity.setImageName(imageFile.getOriginalFilename());
        imageEntity.setContentType(imageFile.getContentType());
        imageEntity.setData(imageFile.getBytes());

        artist.setPhoto(imageEntity);

        return repository.save(artist);
    }

    public Artist findByName(String name) {
        return repository.findByName(name);
    }

    public Artist findById(Long id) {
        Optional<Artist> artist = repository.findById(id);
        return artist.orElseThrow(() -> new EntityNotFoundException("Artist not found by id:" + id));
    }
}
