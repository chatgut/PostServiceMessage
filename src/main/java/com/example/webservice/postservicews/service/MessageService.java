package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.Message;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    void save(Message message);

    List<Message> getMessages(String sender, String receiver);

    MessageDTO findById(String id);

    MessageDTO save(NewMessageDTO newMessageDTO);


}
