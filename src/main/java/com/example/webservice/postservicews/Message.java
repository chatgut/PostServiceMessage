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
    private String userID;
    private String receiver;
    private String text;
    private boolean isRead;

    private LocalDateTime dateTime;

    public Message() {
        this("default", "userID", null, LocalDateTime.now());
    }

    @BsonCreator
    public Message(String text,
                   String userID,
                   String receiver, LocalDateTime dateTime) {
        this.text = text;
        this.userID = userID;
        this.receiver = receiver;
        this.dateTime = dateTime;

    }

    public Message setUserID(@NonNull String userID) {
        this.userID = userID;
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
        return text.equals(message.text) && userID.equals(message.userID) && Objects.equals(receiver, message.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, userID, receiver);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", userID='" + userID + '\'' +
                ", receiver='" + receiver + '\'' +
                ", text='" + text + '\'' +
                ", isRead=" + isRead +
                ", dateTime=" + dateTime +
                '}';
    }
}

