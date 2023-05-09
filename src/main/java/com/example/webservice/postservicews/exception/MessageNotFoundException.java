package com.example.webservice.postservicews.exception;

public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException(String id) {
        super("id " + id + " not found.");
    }
}
