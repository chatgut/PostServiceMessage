package com.example.webservice.postservicews.service;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;


import java.util.List;

public interface MessageService {
    List<MessageDTO> getAllMessages(String from, String to, int page, int nMessages);
    MessageDTO save(NewMessageDTO newMessageDTO);
    boolean deleteMessage(String id);
}
