package com.example.webservice.postservicews.repository;
import com.example.webservice.postservicews.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
