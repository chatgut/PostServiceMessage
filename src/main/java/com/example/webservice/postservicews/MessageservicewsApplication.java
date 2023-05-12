package com.example.webservice.postservicews;
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
