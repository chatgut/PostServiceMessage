package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
private MessageRepository messageRepository;

    @Autowired
    MessageServiceImpl (MessageRepository messageRepository){
       this.messageRepository = messageRepository;
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages(String sender, String receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }


    @Override
    public MessageDTO findById(String id) {
        return null;
    }

    @Override
    public MessageDTO save(NewMessageDTO newMessageDTO) {
        Message message = new Message();
        message.setSender(newMessageDTO.getId());
        message.setReceiver(newMessageDTO.getReceiver());
        message.setText(newMessageDTO.getText());


        return getMessageDto(message);
    }

    private MessageDTO getMessageDto(Message message) {
        return new MessageDTO();
    }
    private MessageDTO getMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setText(message.getText());
        messageDTO.setSender(message.getSender());
        messageDTO.setReceiver(message.getReceiver());
        return messageDTO;
    }


}
