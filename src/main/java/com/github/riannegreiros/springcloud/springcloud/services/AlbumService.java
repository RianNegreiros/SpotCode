package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.entities.Image;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    private static final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    private AlbumRepository repository;

    @Transactional
    public Album save(String title, LocalDate date, Category category, Artist artist, MultipartFile imageFile) throws IOException {
        Album album = new Album();
        album.setTitle(title);
        album.setDate(date);
        album.setCategory(category);
        album.setArtist(artist);

        Image imageEntity = new Image();
        imageEntity.setImageName(imageFile.getOriginalFilename());
        imageEntity.setContentType(imageFile.getContentType());
        imageEntity.setData(imageFile.getBytes());

        album.setCover(imageEntity);

        return repository.save(album);
    }

    public Album findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Album findById(Long id) {
        Optional<Album> album = repository.findById(id);

        return album.orElseThrow(() -> new EntityNotFoundException("Album not found by id:" + id));
    }
    public List<String> getHeardCategories(List<Album> recentAlbums) {
        return recentAlbums.stream()
                .map(Album::getTitle)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Album> getRecommendedAlbums(List<String> heardCategories) {
        return repository.findDistinctByCategoryInOrderByPlayedCount(heardCategories)
                .stream()
                .limit(12)
                .toList();
    }

    public List<Album> getAllAlbumsSample(int limit) {
        return repository.findAll().stream().limit(limit).toList();
    }
}
