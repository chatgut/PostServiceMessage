package com.example.webservice.postservicews.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String id) {
        super("id " + id + " not found.");
    }
}
