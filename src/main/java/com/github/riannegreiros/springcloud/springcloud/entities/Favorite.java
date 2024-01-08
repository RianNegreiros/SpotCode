package com.github.riannegreiros.springcloud.springcloud.entities;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorite implements Favoritable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "favoritable_id")
    private Favoritable favoritable;

    @Column(name = "favoritable_type")
    private String favoritableType;

    public Favorite() {
    }

    public Favorite(Long id, User user, Favoritable favoritable, String favoritableType) {
        this.id = id;
        this.user = user;
        this.favoritable = favoritable;
        this.favoritableType = favoritableType.getClass().getSimpleName();
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

    public Favoritable getFavoritable() {
        return favoritable;
    }

    public void setFavoritable(Favoritable favoritable) {
        this.favoritable = favoritable;
    }

    public String getFavoritableType() {
        return favoritableType;
    }

    public void setFavoritableType(String favoritableType) {
        this.favoritableType = favoritableType;
    }

    @Override
    public String getTitle() {
        return favoritable.getTitle();
    }
}
