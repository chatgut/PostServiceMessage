package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.repository.MessageRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getMessages(String toUserId, String fromUserId) {
        return messageRepository.findByMessage(toUserId, fromUserId);
    }
}
