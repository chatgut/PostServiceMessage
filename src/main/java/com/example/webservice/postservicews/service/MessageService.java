package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.Message;
import com.example.webservice.postservicews.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    MessageDTO findById(String id);

    MessageDTO save(Message newMessageDTO);


    void deleteMessage(String id);
}
