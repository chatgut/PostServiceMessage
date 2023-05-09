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

    private String sender;


    private String receiver;


    private String text;

    private LocalDateTime datetime;

    private boolean isRead;

    public Message () {
        this("default", "sender", null, LocalDateTime.now(), false);
    }

    public Message(String text,
                    String sender, Object o, LocalDateTime now, boolean b) {
        this(text, sender, null, LocalDateTime.now(), false);
    }

    @BsonCreator
    public Message(String text,
                    String sender,
                     String parentId,
                   LocalDateTime datetime, boolean isRead) {
        this.text = text;
        this.sender = sender;
        this.receiver = parentId;
        this.datetime = datetime != null ? datetime : LocalDateTime.now();
        this.isRead = isRead;
    }

    public String getId() {
        return id;
    }

    public Message setId(String id) {
        this.id = id;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public Message setSender(@NonNull String sender) {
        this.sender = sender;
        return this;
    }

    @Nullable
    public String getReceiver() {
        return receiver;
    }

    public Message setReceiver(@Nullable String receiver) {
        this.receiver = receiver;
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
        return text.equals(message.text) && sender.equals(message.sender) && Objects.equals(receiver, message.receiver);
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
        return Objects.hash(text, sender, receiver);
    }
}

