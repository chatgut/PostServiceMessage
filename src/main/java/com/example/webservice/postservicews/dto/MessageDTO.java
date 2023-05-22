package com.example.webservice.postservicews.dto;
import com.example.webservice.postservicews.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class MessageDTO {
    private String id;
    private String text;
    private String receiver;
    private String userID;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

}