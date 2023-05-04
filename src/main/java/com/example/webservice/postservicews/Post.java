package com.example.webservice.postservicews;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Post {

        @Id
        private String id;

        @NonNull
        @BsonProperty
        private String text;

        @NonNull
        @BsonProperty
        private String userId;

        @Nullable
        @BsonProperty
        private String authorId;

        public Post() {
            this("default", "userId", null);
        }

        @BsonCreator
        public Post(String text, String userId, String authorId) {
            this.text = text;
            this.userId = userId;
            this.authorId = authorId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @NonNull
        public String getText() {
            return text;
        }

        public void setText(@NonNull String text) {
            this.text = text;
        }

        @NonNull
        public String getUserId() {
            return userId;
        }

        public void setUserId(@NonNull String userId) {
            this.userId = userId;
        }

        @Nullable
        public String getAuthorId() {
            return authorId;
        }

        public void setAuthorId(@Nullable String authorId) {
            this.authorId = authorId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Post)) return false;
            Post post = (Post) o;
            return text.equals(post.text) && userId.equals(post.userId) && Objects.equals(authorId, post.authorId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text, userId, authorId);
        }
    }

