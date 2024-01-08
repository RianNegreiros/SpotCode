package com.github.riannegreiros.springcloud.springcloud.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_favorite")
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "favoritable_id")
    private Long favoritableId;

    @Column(name = "favoritable_type")
    private String favoritableType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    public Favorite() {
    }

    public Favorite(User user, Album album, Artist artist, Song song) {
        this.user = user;
        this.album = album;
        this.artist = artist;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Long getFavoritableId() {
        return favoritableId;
    }

    public void setFavoritableId(Long favoritableId) {
        this.favoritableId = favoritableId;
    }

    public String getFavoritableType() {
        return favoritableType;
    }

    public void setFavoritableType(String favoritableType) {
        this.favoritableType = favoritableType;
    }
}