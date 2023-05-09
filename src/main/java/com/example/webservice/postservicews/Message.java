package com.example.webservice.postservicews;

import com.mongodb.lang.Nullable;
import lombok.NonNull;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document("messages")
public class Message {
    @Id
    private String id;

    private String userId;


    private String parentId;


    private String text;

    private LocalDateTime datetime;

    private boolean isRead;

    public Message () {
        this("default", "userId", null, LocalDateTime.now(), false);
    }

    public Message(String text,
                    String userId, Object o, LocalDateTime now, boolean b) {
        this(text, userId, null, LocalDateTime.now(), false);
    }

    @BsonCreator
    public Message(String text,
                    String userId,
                     String parentId,
                   LocalDateTime datetime, boolean isRead) {
        this.text = text;
        this.userId = userId;
        this.parentId = parentId;
        this.datetime = datetime;
        this.isRead = isRead;
    }

    public String getId() {
        return id;
    }

    public Message setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Message setUserId(@NonNull String userId) {
        this.userId = userId;
        return this;
    }

    @Nullable
    public String getParentId() {
        return parentId;
    }

    public Message setParentId(@Nullable String parentId) {
        this.parentId = parentId;
        return this;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public Message setText(@NonNull String text) {
        this.text = text;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message message)) return false;
        return text.equals(message.text) && userId.equals(message.userId) && Objects.equals(parentId, message.parentId);
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, userId, parentId);
    }
}

