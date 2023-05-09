/*
package com.example.webservice.postservicews;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

public class MongoConnection {

    private static final String DATABASE_NAME = "mongodb_test";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static final String HOST = "localhost";
    private static final int PORT = 27017;

    public MongoClient getClient() {
        MongoCredential credential = MongoCredential.createCredential(USERNAME, DATABASE_NAME, PASSWORD.toCharArray());
        ServerAddress serverAddress = new ServerAddress(HOST, PORT);
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(serverAddress)))
                .build();
        MongoClient client = MongoClients.create(settings);
        return client;
    }

    public MongoDatabase getDatabase() {
        MongoClient client = getClient();
        MongoDatabase database = client.getDatabase(DATABASE_NAME);
        return database;
    }

}
*/
