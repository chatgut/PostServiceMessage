package com.example.webservice.postservicews.dto;
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
    private String message;
    private String to;
    private String from;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime date;

}