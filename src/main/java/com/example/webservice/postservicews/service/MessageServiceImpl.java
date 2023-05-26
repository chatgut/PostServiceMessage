package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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
    public MessageDTO save(NewMessageDTO newMessageDTO) {
        Message message = new Message();
        message.setMessage(newMessageDTO.getMessage());
        message.setFrom(newMessageDTO.getFrom());
        message.setTo(newMessageDTO.getTo());
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
    public List<MessageDTO> getAllMessages(String from, String to, int page, int nMessages) {
        Pageable paging = PageRequest.of(page, nMessages, Sort.by("date").descending());
        List<MessageDTO> fromAndTo = messageRepository.findMessages(from, to, paging).getContent();
        return fromAndTo;
    }

    private MessageDTO getMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setMessage(message.getMessage());
        messageDTO.setFrom(message.getFrom());
        messageDTO.setTo(message.getTo());
        messageDTO.setDate(message.getDate());
        return messageDTO;
    }
    }