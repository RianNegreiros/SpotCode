package com.github.riannegreiros.springcloud.springcloud.dto;

public class FavoriteRequest {

    private Long id;
    private String type;

    public FavoriteRequest() {
    }

    public FavoriteRequest(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}