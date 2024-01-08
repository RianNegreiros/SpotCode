package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.AudioFile;
import com.github.riannegreiros.springcloud.springcloud.entities.Song;
import com.github.riannegreiros.springcloud.springcloud.repositories.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class SongService {
    private static final Logger logger = LoggerFactory.getLogger(SongService.class);

    @Autowired
    private SongRepository repository;

    @Transactional
    public Song save(Album album, String title, MultipartFile audioFile) throws IOException {
        Song song = new Song();
        song.setAlbum(album);
        song.setTitle(title);

        AudioFile audioFileEntity = new AudioFile();
        audioFileEntity.setFileName(audioFile.getOriginalFilename());
        audioFileEntity.setContentType("audio/mpeg");
        audioFileEntity.setData(audioFile.getBytes());

        song.setFile(audioFileEntity);

        return repository.save(song);
    }
}
