package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
private final MessageRepository messageRepository;

    @Autowired
    MessageServiceImpl (MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    @Override
    public MessageDTO save(NewMessageDTO newMessageDTO) {
        Message message = new Message();
        message.setText(newMessageDTO.getText());
        message.setUserID(newMessageDTO.getUserID());
        message.setReceiver(newMessageDTO.getReceiver());
        message = messageRepository.save(message);


        return getMessageDTO(message);
    }

    public boolean deleteMessage(String id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
           messageRepository.deleteById(id);
           return true;
        } else {
            return false;
        }
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        List<Message> messageList = messageRepository.findAll();
        return messageList.stream()
                .map(this::getMessageDTO)
                .collect(Collectors.toList());
    }

    private MessageDTO getMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setText(message.getText());
        messageDTO.setUserID(message.getUserID());
        messageDTO.setReceiver(message.getReceiver());
        messageDTO.setDateTime(message.getDateTime());
        return messageDTO;
    }


    }