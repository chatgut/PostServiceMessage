package com.example.webservice.postservicews.dto;

import jakarta.validation.constraints.NotNull;


public class NewMessageDTO {
        private String id;
        @NotNull(message = "Text cannot be empty")
        private String text;
        @NotNull(message = "User ID cannot be empty")
        private String userId;
        private String parentId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String fromUserId) {
        this.parentId = parentId;
    }
}
