package com.example.webservice.postservicews.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class MessageDTO {
    private String id;
    private String text;
    private String receiver;
    private String userID;
    private Date created;

}