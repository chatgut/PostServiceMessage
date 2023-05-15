package com.example.webservice.postservicews.service;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    List<MessageDTO> getAllMessages();

    MessageDTO save(NewMessageDTO newMessageDTO);


    boolean deleteMessage(String id);
}
