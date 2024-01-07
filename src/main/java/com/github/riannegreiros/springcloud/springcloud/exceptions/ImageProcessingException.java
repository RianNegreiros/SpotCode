package com.github.riannegreiros.springcloud.springcloud.exceptions;

public class ImageProcessingException extends RuntimeException {

    public ImageProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}