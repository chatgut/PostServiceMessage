package com.example.webservice.postservicews.dto;

import jakarta.validation.constraints.NotNull;


public class NewMessageDTO {
        private String id;
        @NotNull(message = "Text cannot be empty")
        private String text;
        @NotNull(message = "User ID cannot be empty")
        private String sender;
        private String receiver;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String fromRecieverId) {
        this.receiver = receiver;
    }
}
