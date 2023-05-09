package com.example.webservice.postservicews.repository;

import com.example.webservice.postservicews.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByUserIdAndParentIdOrderByDatetimeDesc(String userId, String parentId);
}
