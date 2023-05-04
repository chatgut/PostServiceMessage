package com.example.webservice.postservicews.dto;

public class newDTO {
    private String id;
    private String text;
    private String userId;
    private String parentId;

    public newDTO(String id, String text, String userId, String parentId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.parentId = parentId;
    }

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

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "PostNewDto{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", userId='" + userId + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
