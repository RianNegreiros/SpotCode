package com.github.riannegreiros.springcloud.springcloud.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recently_heards")
public class RecentlyHeard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Column(name = "listened_at")
    private LocalDate listenedAt;

    public RecentlyHeard() {
    }

    public RecentlyHeard(Long id, User user, Album album, LocalDate listenedAt) {
        this.id = id;
        this.user = user;
        this.album = album;
        this.listenedAt = listenedAt;
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

    public LocalDate getListenedAt() {
        return listenedAt;
    }

    public void setListenedAt(LocalDate listenedAt) {
        this.listenedAt = listenedAt;
    }
}
