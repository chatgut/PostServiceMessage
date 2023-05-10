package com.example.webservice.postservicews.dto;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MessageDTO {
    private String id;
    private String text;
    private String receiver;
    private String sender;

    public String getId() {
        return id;
    }

}