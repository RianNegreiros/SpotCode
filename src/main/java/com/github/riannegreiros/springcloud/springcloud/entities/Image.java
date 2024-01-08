package com.github.riannegreiros.springcloud.springcloud.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_image")
public class Image  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private byte[] data;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private String imageName;

    public Image() {
    }

    public Image(byte[] data, String contentType, String imageName) {
        this.data = data;
        this.contentType = contentType;
        this.imageName = imageName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}