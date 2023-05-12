package com.example.webservice.postservicews;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MessageservicewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageservicewsApplication.class, args);
        System.out.println("Running");
    }
}
