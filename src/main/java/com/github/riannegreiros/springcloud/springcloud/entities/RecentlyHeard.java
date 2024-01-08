package com.github.riannegreiros.springcloud.springcloud.entities;

import javax.persistence.*;

@Entity
@Table(name = "recently_heards")
public class RecentlyHeard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    public RecentlyHeard() {
    }

    public RecentlyHeard(User user, Album album) {
        this.user = user;
        this.album = album;
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

}
