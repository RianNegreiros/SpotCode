package com.github.riannegreiros.springcloud.springcloud.exceptions;

public class FileProcessingException extends RuntimeException {

    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}