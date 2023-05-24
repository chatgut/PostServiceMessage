package com.example.webservice.postservicews;

import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document("messages")
@Getter
@Setter
public class Message {
    @Id
    private String id;
    private String from;
    private String to;
    private String message;
    private boolean isRead;

    private LocalDateTime date;

    public Message() {
        this("default", "userID", null, LocalDateTime.now());
    }

    @BsonCreator
    public Message(String message,
                   String to,
                   String from, LocalDateTime date) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.date = date;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
