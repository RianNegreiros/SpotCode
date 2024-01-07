package com.github.riannegreiros.springcloud.springcloud.entities;

import javax.persistence.*;

@Entity
public class Song extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Column(nullable = false)
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private FileAttachment file;

    public Song() {
    }

    public Song(Long id, Album album, String title, FileAttachment file) {
        this.id = id;
        this.album = album;
        this.title = title;
        this.file = file;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FileAttachment getFile() {
        return file;
    }

    public void setFile(FileAttachment file) {
        this.file = file;
    }
}