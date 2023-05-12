package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.exception.MessageNotFoundException;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.Message;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
private final MessageRepository messageRepository;

    @Autowired
    MessageServiceImpl (MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDTO save(Message newMessageDTO) {
        Message message = new Message();
        message.setText(newMessageDTO.getText());
        message.setUserID(newMessageDTO.getUserID());
        message.setReceiver(newMessageDTO.getReceiver());
        message = messageRepository.save(message);

        return getMessageDTO(message);
    }

    public void deleteMessage(String id) {
        messageRepository.deleteById(id);
    }

    @Override
    public MessageDTO findById(String id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            return getMessageDTO(message);
        } else {
            throw new MessageNotFoundException("Message not found with id " + id);
        }
    }

    private Date getCreated(String id) {
        var mongoId = new ObjectId(id);
        return mongoId.getDate();
    }

    private MessageDTO getMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setText(message.getText());
        messageDTO.setUserID(message.getUserID());
        messageDTO.setReceiver(message.getReceiver());
        messageDTO.setCreated(getCreated(message.getId()));
        return messageDTO;
    }


    }