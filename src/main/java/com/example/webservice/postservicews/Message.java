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

    public Message () {
        this("default", "sender", null);
    }

    public Message(String id, String text, String sender, String receiver) {
        this.id = id;
        this.text = text;
        this.userID = sender;
        this.receiver = receiver;

    }

    @BsonCreator
    public Message(String text,
                    String userID,
                     String receiver) {
        this.text = text;
        this.userID = userID;
        this.receiver = receiver;

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
}

