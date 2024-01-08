package com.github.riannegreiros.springcloud.springcloud.exceptions;

public class ImageNotFoundException extends RuntimeException {

    public ImageNotFoundException(String message) {
        super(message);
    }
}