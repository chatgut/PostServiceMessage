package com.example.webservice.postservicews.dto;

import lombok.Data;

@Data
public class PostDTO {
    private String id;
    private String text;
    private String authorId;
    private String userId;
}