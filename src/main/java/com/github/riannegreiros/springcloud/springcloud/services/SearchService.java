package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Song;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.ArtistRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Song> searchSongs(String query) {
        return songRepository.findByTitleContainingIgnoreCase(query);
    }

    public List<Album> searchAlbums(String query) {
        return albumRepository.findByTitleContainingIgnoreCase(query);
    }

    public List<Artist> searchArtists(String query) {
        return artistRepository.findByNameContainingIgnoreCase(query);
    }
}