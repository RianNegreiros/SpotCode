package com.github.riannegreiros.springcloud.springcloud.dto;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Song;

import java.util.List;

public class SearchResults {
    private List<Song> songs;
    private List<Album> albums;
    private List<Artist> artists;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
