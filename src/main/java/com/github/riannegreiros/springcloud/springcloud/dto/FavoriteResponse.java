package com.github.riannegreiros.springcloud.springcloud.dto;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Song;

import java.util.List;

public class FavoriteResponse {

    private List<Album> favoriteAlbums;
    private List<Song> favoriteSongs;
    private List<Artist> favoriteArtists;

    public FavoriteResponse() {
    }

    public FavoriteResponse(List<Album> favoriteAlbums, List<Song> favoriteSongs, List<Artist> favoriteArtists) {
        this.favoriteAlbums = favoriteAlbums;
        this.favoriteSongs = favoriteSongs;
        this.favoriteArtists = favoriteArtists;
    }

    public List<Album> getFavoriteAlbums() {
        return favoriteAlbums;
    }

    public void setFavoriteAlbums(List<Album> favoriteAlbums) {
        this.favoriteAlbums = favoriteAlbums;
    }

    public List<Song> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(List<Song> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    public List<Artist> getFavoriteArtists() {
        return favoriteArtists;
    }

    public void setFavoriteArtists(List<Artist> favoriteArtists) {
        this.favoriteArtists = favoriteArtists;
    }
}