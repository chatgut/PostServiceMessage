package com.example.webservice.postservicews.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
public class NewMessageDTO {
        private String id;
        @NotNull(message = "Text cannot be empty")
        private String message;
        @NotNull(message = "User ID cannot be empty")
        private String from;
        private String to;

        private LocalDateTime date;
}
