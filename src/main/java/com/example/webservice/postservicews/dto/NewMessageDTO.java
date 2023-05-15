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
        private String text;
        @NotNull(message = "User ID cannot be empty")
        private String userID;
        private String receiver;

        private LocalDateTime dateTime;
}
